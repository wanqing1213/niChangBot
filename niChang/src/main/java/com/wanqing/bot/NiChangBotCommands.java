package com.wanqing.bot;

import com.wanqing.botEnum.BotCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import java.util.List;

/**
 * @author 婉清
 * @package com.wanqing.bot
 * @project niChangBot
 * @date 2025/6/28 14:19
 * @file NiChangBotCommands
 * @description 霓裳Bot命令
 */
public class NiChangBotCommands {

    public static List<BotCommand> setGroupCommand() {
        return List.of(
                new BotCommand(BotCommands.LOCK.getCommand(), "锁信息"),
                new BotCommand(BotCommands.JIAO_LANG.getCommand(), "郊狼")
        );
    }

    public static List<BotCommand> setPrivetCommand() {
        return List.of(
                new BotCommand(BotCommands.START.getCommand(), "启动Bot"),
                new BotCommand(BotCommands.HELP.getCommand(), "帮助")
        );
    }
}
