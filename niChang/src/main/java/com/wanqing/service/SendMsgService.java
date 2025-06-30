package com.wanqing.service;

import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.service
 * @project niChangBot
 * @date 2025/6/27 23:02
 * @file SendMessageService
 * @description 发送消息接口
 */
public interface SendMsgService {

    /**
     * 发送带按钮的消息
     *
     * @param telegramClient
     * @param chatId
     * @return
     */
    void sendButtonMessage(TelegramClient telegramClient, String chatId);
}
