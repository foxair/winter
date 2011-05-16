package com.gm.common.utils.async;
/**
 * 用于捕获AsyncToken在通知IResponder结果时,IResponder的抛出的异常
 * 
 *
 */
@SuppressWarnings("all")
public interface UncaughtExceptionHandler {
        
        void uncaughtException(IResponder responder,Throwable e);
        
}