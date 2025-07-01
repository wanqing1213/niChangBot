package com.wanqing.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 婉清
 * @package com.wanqing.entity
 * @project niChangBot
 * @date 2025/6/25 14:18
 * @file User
 * @description 用户类
 */
@Getter
@Setter
@Builder
public class User {

    private String userId;

    private String userName;

    private String tgName;

    private String registerTime;

    private Integer timeCountAdd;

    private Integer timeCountReduce;

    private String toys;

    private String xpInfo;

    private String clothes;

}
