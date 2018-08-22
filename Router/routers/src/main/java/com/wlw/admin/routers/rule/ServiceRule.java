package com.wlw.admin.routers.rule;

import android.app.Service;

import com.wlw.admin.routers.exception.ServiceNotRouteException;


public class ServiceRule extends BaseIntentRule<Service> {

    public static final String SERVICE_SCHEME = "service://";

    @Override
    public void throwException(String pattern) {
        throw new ServiceNotRouteException(pattern);
    }
}
