package com.wlw.admin.routers.rule;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.HashMap;

public abstract class BaseIntentRule<T> implements Rule<T, Intent> {
    private HashMap<String, Class<T>> mIntentRules;

    public BaseIntentRule() {
        mIntentRules = new HashMap<>();
    }

    @Override
    public void router(String pattern, Class<T> tClass) {
        mIntentRules.put(pattern, tClass);
    }

    @Override
    public Intent invoke(Context ctx, String pattern) {
        Class<T> cls = mIntentRules.get(pattern);
        if (cls == null) {
            throwException(pattern);
        }
        return new Intent(ctx, cls);
    }

    @Override
    public boolean resolveRule(String pattern) {
        Log.e("BaseIntentRule",pattern);
        Log.e("BaseIntentRule",mIntentRules.get(pattern).getCanonicalName());
        Log.e("BaseIntentRule",String.valueOf(mIntentRules.get(pattern) != null));
        return mIntentRules.get(pattern) != null;
    }

    /**
     * 当找不到路由规则是抛出异常
     */
    public abstract void throwException(String pattern);
}
