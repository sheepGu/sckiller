package com.seck.exception;

/**秒杀相关的业务异常
 * Created by Tman on 2017/2/22.
 */
public class SeckillException extends RuntimeException{

    public SeckillException() {
    }

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
