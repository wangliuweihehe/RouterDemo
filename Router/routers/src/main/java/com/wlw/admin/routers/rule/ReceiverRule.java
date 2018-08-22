package com.wlw.admin.routers.rule;

import android.content.BroadcastReceiver;

import com.wlw.admin.routers.exception.ReceiverNotRouteException;


public class ReceiverRule extends BaseIntentRule<BroadcastReceiver> {
    public static final String RECEIVER_SCHEME = "receiver://";

    @Override
    public void throwException(String pattern) {
        throw new ReceiverNotRouteException(pattern);
    }
}
