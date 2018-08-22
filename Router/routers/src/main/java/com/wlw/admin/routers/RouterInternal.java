package com.wlw.admin.routers;

import android.content.Context;
import android.util.Log;


import com.wlw.admin.routers.exception.NotRouteException;
import com.wlw.admin.routers.rule.ActivityRule;
import com.wlw.admin.routers.rule.ReceiverRule;
import com.wlw.admin.routers.rule.Rule;
import com.wlw.admin.routers.rule.ServiceRule;

import java.util.HashMap;
import java.util.Set;

public class RouterInternal {
    private static RouterInternal sInstance;
    /**
     * scheme-> 路由规则
     */
    private HashMap<String, Rule> mRules;

    private RouterInternal() {
        mRules = new HashMap<>();
        initDefaultRouter();
    }

    /**
     * 添加默认的 activity service receiver 路由
     */
    private void initDefaultRouter() {
        addRule(ActivityRule.ACTIVITY_SCHEME, new ActivityRule());
        addRule(ReceiverRule.RECEIVER_SCHEME, new ReceiverRule());
        addRule(ServiceRule.SERVICE_SCHEME, new ServiceRule());
    }

    static RouterInternal get() {
        if (sInstance == null) {
            synchronized (RouterInternal.class) {
                if (sInstance == null) {
                    sInstance = new RouterInternal();
                }
            }
        }
        return sInstance;
    }

    /**
     * 添加自定义路由规则
     *
     * @param scheme 路由scheme
     * @param rule   路由规则
     * @return router 真是调用类
     */
    final RouterInternal addRule(String scheme, Rule rule) {
        mRules.put(scheme, rule);
        return this;
    }

    private <T, V> Rule<T, V> getRule(String pattern) {
        HashMap<String, Rule> rules = mRules;
        Set<String> keySet = rules.keySet();
        Rule<T, V> rule = null;
        for (String scheme : keySet) {
            if (pattern.startsWith(scheme)) {
                rule = rules.get(scheme);
                break;
            }
        }
        return rule;
    }

    /**
     * 添加路由
     *
     * @param pattern uri
     * @param tClass  class
     * @return Router 真是调用类
     */
    public final <T> RouterInternal router(String pattern, Class<T> tClass) {
        Rule<T, ?> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }
        rule.router(pattern, tClass);
        return this;
    }

    /**
     * 路由调用
     *
     * @param ctx     Context
     * @param pattern 路由uri
     * @return 返回对应的返回值
     */
    final <V> V invoke(Context ctx, String pattern) {
        Rule<?, V> rule = getRule(pattern);
        if (rule == null) {
            throw new NotRouteException("unknown", pattern);
        }
        return rule.invoke(ctx, pattern);
    }

    final boolean resolveRouter(String pattern) {
        Rule<?, ?> rule = getRule(pattern);
        Log.e("RouterInternal", rule.getClass().getCanonicalName());
        return rule.resolveRule(pattern);
    }
}
