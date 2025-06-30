package com.wanqing.service;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author 婉清
 * @package com.wanqing.service
 * @project niChangBot
 * @date 2025/6/24 14:08
 * @file UserService
 * @description 用户服务
 */
public interface UserService {

    /**
     * 注册用户
     * @param update telegram.update
     */
    void registerUser(Update update);
}
