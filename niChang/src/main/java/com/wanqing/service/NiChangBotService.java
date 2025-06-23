package com.wanqing.service;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.service
 * @project niChangBot
 * @date 2025/6/23 20:25
 * @file NiChangBotService
 * @description 霓裳Bot主方法接口
 */
public interface NiChangBotService {

    void mainFunction(TelegramClient telegramClient, Update update);
}
