package com.wanqing.utils;

import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author 婉清
 * @package com.wanqing.utils
 * @project niChangBot
 * @date 2025/6/25 23:34
 * @file UserUtil
 * @description user工具类
 */
public class UserUtil {

    /**
     * 合并用户名
     * 根据传入的Update对象，获取并合并用户的名字和姓氏
     * 如果用户没有姓氏，直接返回名字
     *
     * @param update 更新对象，包含用户的消息和用户信息
     * @return 用户的名字或名字与姓氏的组合
     */
    public static String combineUserName(Update update) {
        String firstName = update.getMessage().getFrom().getFirstName();
        String lastName = update.getMessage().getFrom().getLastName();
        if (StringUtils.isBlank(lastName)) {
            return firstName;
        } else {
            return firstName + lastName;
        }
    }
}
