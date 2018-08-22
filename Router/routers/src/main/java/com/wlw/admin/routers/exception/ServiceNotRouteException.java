package com.wlw.admin.routers.exception;

public class ServiceNotRouteException extends NotRouteException {
    public ServiceNotRouteException(String pattern) {
        super("service", pattern);
    }
}
