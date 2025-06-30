package com.wanqing.service;

import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.service
 * @project niChangBot
 * @date 2025/6/28 20:53
 * @file DeleteMessageService
 * @description 删除消息接口
 */
public interface DeleteMsgService {

    void deleteGroupCommand(TelegramClient telegramClient, Message message);
}
