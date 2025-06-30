package com.wanqing.service;

import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.service
 * @project niChangBot
 * @date 2025/6/28 14:24
 * @file GroupService
 * @description
 */
public interface BotCommandService {

    void  setGroupCommands(TelegramClient telegramClient);

    void  setPrivateCommands(TelegramClient telegramClient);
}
