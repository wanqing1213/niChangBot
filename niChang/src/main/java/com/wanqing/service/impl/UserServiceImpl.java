package com.wanqing.service.impl;

import com.wanqing.entity.User;
import com.wanqing.mapper.UserMapper;
import com.wanqing.service.UserService;
import com.wanqing.utils.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardRow;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

/**
 * @author 婉清
 * @package com.wanqing.service.impl
 * @project niChangBot
 * @date 2025/6/25 14:09
 * @file UserServiceImpl
 * @description
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   // private final UserMapper userMapper;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void registerUser(Update update) {
        //从redis查询有没有这个用户id
        String userId = update.getMessage().getFrom().getId().toString();
        String userName = UserUtil.combineUserName(update);
        Boolean hasUserId = stringRedisTemplate.hasKey(userId);
        if (Boolean.TRUE.equals(hasUserId)){
            return;
        }
        User user = User.builder().userId(userId).userName(userName).build();
        // 创建按钮并设置 Web App
        InlineKeyboardButton keyboardButton = InlineKeyboardButton.builder().text("请点击!").webApp(new WebAppInfo("https://noticeably-positive-bird.ngrok-free.app")).build();
        // 设置按钮行
        InlineKeyboardRow row = new InlineKeyboardRow();
        row.add(keyboardButton);
        // 创建键盘并设置到消息中
        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder().keyboardRow(row).build();


    }
}
