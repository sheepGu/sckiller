package com.seck.exception;

/**
 * 重复秒杀异常
 * Created by Tman on 2017/2/22.
 */
public class RepeatKillException extends  SeckillException{
    public RepeatKillException() {
    }

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
