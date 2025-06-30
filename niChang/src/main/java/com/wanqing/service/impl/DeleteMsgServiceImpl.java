package com.wanqing.service.impl;

import com.wanqing.service.DeleteMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/28 20:56
 * @file DeleteMsgServiceImpl
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DeleteMsgServiceImpl implements DeleteMsgService {

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Override
    public void deleteGroupCommand(TelegramClient telegramClient, Message message) {
        scheduler.schedule(() -> {
            DeleteMessage deleteMessage = DeleteMessage.builder().chatId(message.getChatId()).messageId(message.getMessageId()).build();
            try {
                telegramClient.execute(deleteMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }


        },10, TimeUnit.SECONDS);

    }
}
