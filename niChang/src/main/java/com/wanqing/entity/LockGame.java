package com.wanqing.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 婉清
 * @package com.wanqing.entity
 * @project niChangBot
 * @date 2025/7/1 00:31
 * @file LockGame
 * @description 锁游戏
 */
@Getter
@Setter
@Builder
public class LockGame {

    private String lockId;

    private String userId;

    private String userName;

    private String status;

    private String modeId;

    private String startTime;

    private String endTime;

    private String resumeTime;

    private String pauseTime;

}
