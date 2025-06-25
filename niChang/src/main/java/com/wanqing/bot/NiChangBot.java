package com.wanqing.bot;

import com.wanqing.service.NiChangBotService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * @author 婉清
 * @package com.wanqing.bot
 * @project niChangBot
 * @date 2025/6/23 20:14
 * @file NiChangBot
 * @description 霓裳Bot
 */

@Getter
@Component
public class NiChangBot implements SpringLongPollingBot, LongPollingSingleThreadUpdateConsumer {

    private final NiChangBotService niChangBotService;

    private final TelegramClient telegramClient;

    @Value("${telegram.bot.token}")
    private final String botToken;

    public NiChangBot(@Value("${telegram.bot.token}") String botToken, NiChangBotService niChangBotService) {
        this.telegramClient = new OkHttpTelegramClient(botToken);
        this.botToken = botToken;
        this.niChangBotService = niChangBotService;
    }


    @Override
    public LongPollingUpdateConsumer getUpdatesConsumer() {
        return this;
    }

    @Override
    public void consume(Update update) {
        niChangBotService.mainFunction(telegramClient, update);

    }
}
