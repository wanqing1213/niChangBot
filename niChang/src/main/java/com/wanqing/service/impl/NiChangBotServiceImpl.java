package com.wanqing.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.wanqing.config.VirtualThreadConfig;
import com.wanqing.service.NiChangBotService;
import com.wanqing.service.SendMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@Slf4j
@Service
@RequiredArgsConstructor
public class NiChangBotServiceImpl implements NiChangBotService {

    private final Executor virtualThreadExecutor;

    private final SendMsgService sendMsgService;

    @Override
    public void mainFunction(TelegramClient telegramClient, Update update) {

        virtualThreadExecutor.execute(() -> {
            log.info("update:{}", JSONObject.toJSONString(update));
            if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().isCommand()) {

                switch (update.getMessage().getText()) {
                    case "/start":
                        // 返回链接
                        sendMsgService.sendButtonMessage(telegramClient, update.getMessage().getChatId().toString());
                        break;
                    case "/help":
                        // 帮助
                        break;
                    default:
                        break;
                }
            }
        });
    }


}
