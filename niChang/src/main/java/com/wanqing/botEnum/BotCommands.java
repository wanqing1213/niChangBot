package com.wanqing.botEnum;

import lombok.Getter;

/**
 * @author 婉清
 * @package com.wanqing.botEnum
 * @project niChangBot
 * @date 2025/6/25 21:05
 * @file BotCommands
 * @description bot命令枚举
 */
@Getter
public enum BotCommands {

    IS_BOT_COMMAND("bot_command"),


    /**
     * 私有命令
     */
    START("/start"),

    HELP("/help"),


    //=================================================================================================================

    /**
     * 群组命令
     */
    LOCK("/lock"),

    JIAO_LANG("/jiaolang");


    private final String command;

    BotCommands(String command) {
        this.command = command;
    }

}
