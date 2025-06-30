package com.wanqing.service.impl;

import com.wanqing.bot.NiChangBotCommands;
import com.wanqing.service.BotCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.menubutton.SetChatMenuButton;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeAllGroupChats;
import org.telegram.telegrambots.meta.api.objects.menubutton.MenuButtonCommands;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.List;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/28 14:25
 * @file GroupServiceImpl
 * @description
 */
@Slf4j
@Service
public class BotCommandServiceImpl implements BotCommandService {
    @Override
    public void setGroupCommands(TelegramClient telegramClient) {

        try {
            List<BotCommand> groupCommands = NiChangBotCommands.setGroupCommand();
            BotCommandScopeAllGroupChats botCommandScopeAllGroupChats = BotCommandScopeAllGroupChats.builder().build();
            SetMyCommands setAnyOneCommands = SetMyCommands.builder().commands(groupCommands).scope(botCommandScopeAllGroupChats).build();
            telegramClient.execute(setAnyOneCommands);
        } catch (TelegramApiException e) {
            log.error("BotCommandServiceImpl.setGroupCommands错误:{}", e.getMessage());
        }

    }

    @Override
    public void setPrivateCommands(TelegramClient telegramClient) {
        try {
            SetChatMenuButton menuButton = SetChatMenuButton.builder()
                    .menuButton(new MenuButtonCommands())
                    .build();
            telegramClient.execute(menuButton);

            List<BotCommand> privetCommand = NiChangBotCommands.setPrivetCommand();
            SetMyCommands setAnyOneCommands = SetMyCommands.builder().commands(privetCommand).build();
            telegramClient.execute(setAnyOneCommands);
        } catch (TelegramApiException e) {
            log.error("BotCommandServiceImpl.setPrivateCommands错误:{}", e.getMessage());
        }
    }
}
