package com.wanqing.service.impl;

import com.wanqing.config.VirtualThreadConfig;
import com.wanqing.service.NiChangBotService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.concurrent.Executor;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/23 20:26
 * @file NiChangBotServiceImpl
 * @description 霓裳Bot主方法实现类
 */

@Service
public class NiChangBotServiceImpl implements NiChangBotService {

    private final Executor virtualThreadExecutor;

    public NiChangBotServiceImpl(
            @Qualifier("contextAwareVirtualThreadExecutor") Executor virtualThreadExecutor
    ) {
        this.virtualThreadExecutor = virtualThreadExecutor;
    }


    @Override
    public void mainFunction(TelegramClient telegramClient, Update update) {

    }
}
