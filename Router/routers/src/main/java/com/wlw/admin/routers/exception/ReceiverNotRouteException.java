package com.wlw.admin.routers.exception;

public class ReceiverNotRouteException extends NotRouteException {
    public ReceiverNotRouteException( String pattern) {
        super("receiver", pattern);
    }
}
