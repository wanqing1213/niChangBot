package com.wanqing.botEnum;

import lombok.Getter;

/**
 * @author  婉清
 * @package com.wanqing.botEnum
 * @project niChangBot
 * @date    2025/6/25 21:12
 * @file    BotAttribute
 * @description bot属性
 */
@Getter
public enum BotAttribute {
    NAME("nichangs_bot"),

    PRIVATE("private"),

    SUPERGROUP("supergroup");

    private final String type;

    BotAttribute(String type) {
        this.type = type;
    }
}
