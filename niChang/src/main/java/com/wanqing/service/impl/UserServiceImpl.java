package com.wanqing.service.impl;

import com.wanqing.mapper.UserMapper;
import com.wanqing.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/25 14:09
 * @file UserServiceImpl
 * @description
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public void registerUser(Update update) {

    }
}
