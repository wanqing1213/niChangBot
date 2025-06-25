package com.wanqing.config;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author 婉清
 * @package com.wanqing.config
 * @project niChangBot
 * @date 2025/6/23 21:47
 * @file VirtualThreadConfig
 * @description 虚拟线程配置
 */
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;
import java.util.concurrent.ThreadFactory;

@Configuration
@EnableAsync
public class VirtualThreadConfig {

    // 基础虚拟线程执行器
    @Bean(name = "virtualThreadExecutor")
    public Executor virtualThreadExecutor() {
        ThreadFactory factory = Thread.ofVirtual().name("niChang-virtual").factory();
        return Executors.newThreadPerTaskExecutor(factory);
    }

    // 带上下文传递的虚拟线程执行器
    @Bean(name = "contextAwareVirtualThreadExecutor")
    public Executor contextAwareVirtualThreadExecutor() {
        return new VirtualThreadPerTaskExecutorWrapper();
    }

    // 自定义执行器包装类
    private static class VirtualThreadPerTaskExecutorWrapper implements Executor {
        private final Executor delegate = Executors.newVirtualThreadPerTaskExecutor();
        private final TaskDecorator taskDecorator = createMdcTaskDecorator();

        @Override
        public void execute(@NotNull Runnable command) {
            delegate.execute(taskDecorator.decorate(command));
        }

        private TaskDecorator createMdcTaskDecorator() {
            return runnable -> {
                // 捕获提交线程的上下文
                Map<String, String> mdcContext = MDC.getCopyOfContextMap();

                return () -> {
                    try {
                        // 恢复上下文到虚拟线程
                        if (mdcContext != null) {
                            MDC.setContextMap(mdcContext);
                        }
                        runnable.run();
                    } finally {
                        // 确保清理虚拟线程上下文
                        MDC.clear();
                    }
                };
            };
        }
    }
}