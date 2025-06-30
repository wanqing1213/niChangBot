package com.wanqing.service.impl;

import com.wanqing.service.SendMsgService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/27 23:44
 * @file SendMessageServiceImpl
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SendMsgServiceImpl implements SendMsgService {
    @Override
    public void sendButtonMessage(TelegramClient telegramClient, String chatId) {
        try {
            InlineKeyboardButton inlineKeyboardButton = InlineKeyboardButton.builder().text("这里，点这里!").webApp(new WebAppInfo("https://noticeably-positive-bird.ngrok-free.app")).build();
            InlineKeyboardRow inlineKeyboardRow = new InlineKeyboardRow();
            inlineKeyboardRow.add(inlineKeyboardButton);
            InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder().keyboardRow(inlineKeyboardRow).build();
            SendMessage sendMessage = SendMessage.builder().replyMarkup(inlineKeyboardMarkup).chatId(chatId).text("霓裳Bot，男娘的快乐").build();
            telegramClient.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("发送消息失败: {}", e.getMessage());
        }
    }
}
