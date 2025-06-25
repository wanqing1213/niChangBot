package com.wanqing.controller;

import com.wanqing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author 婉清
 * @package com.wanqing.controller
 * @project niChangBot
 * @date 2025/6/24 11:40
 * @file UserController
 * @description user 控制器
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000") // 仅作用于当前控制器
public class UserController {

    @Autowired
    private UserService userService;



}
