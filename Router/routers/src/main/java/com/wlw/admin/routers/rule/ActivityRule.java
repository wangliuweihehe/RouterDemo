package com.wlw.admin.routers.rule;

import android.app.Activity;

import com.wlw.admin.routers.exception.ActivityNotRouteException;


public class ActivityRule extends BaseIntentRule<Activity> {
    /**
     * @param pattern
     */
    public static final String ACTIVITY_SCHEME = "activity://";

    @Override
    public void throwException(String pattern) {
        throw new ActivityNotRouteException(pattern);
    }
}
