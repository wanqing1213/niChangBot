package com.wanqing.exception;

import lombok.Getter;

/**
 * @author 婉清
 * @package com.wanqing.exception
 * @project niChangBot
 * @date 2025/6/28 21:20
 * @file ErrorCode
 * @description 错误码枚举
 */
@Getter
public enum ErrorCode {
    USER_NOT_FOUND(1001, "用户不存在"),
    INVALID_PARAM(1002, "参数无效");

    private final int code;
    private final String message;
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取错误信息
     */
    public static String getMessageByCode(int code) {
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (errorCode.code == code) {
                return errorCode.message;
            }
        }
        return null;
    }

}
