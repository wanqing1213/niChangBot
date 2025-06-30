package com.wanqing.exception;

/**
 * @author 婉清
 * @package com.wanqing.exception
 * @project niChangBot
 * @date 2025/6/28 21:16
 * @file BusinessException
 * @description
 */
public class BaseException extends RuntimeException  {

    private final int code;


    public BaseException(int code,String message) {
        super(message);
        this.code = code;
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

}
