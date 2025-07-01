package com.wanqing.config;

import com.wanqing.constant.NiChangBotConstant;
import com.wanqing.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author 婉清
 * @package com.wanqing.config
 * @project niChangBot
 * @date 2025/7/2 01:09
 * @file ScheduledTasks
 * @description 定时任务
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {


    private final UserMapper userMapper;

    // 每天0点更新时间
    @Scheduled(cron = "0 0 0 * * ?")
    public void updateTimeCount() {
        log.info("开始更新时间：{}", LocalDateTime.now());
        userMapper.updateTimeCount();
        log.info("更新时间完成：{}", LocalDateTime.now());
    }

    public static void main(String[] args) {
        //使用日期格式
        System.out.println("开始更新时间：{}" + LocalDateTime.now().format(NiChangBotConstant.DATE_TIME_FORMATTER));
    }
}
