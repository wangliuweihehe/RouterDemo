package com.wlw.admin.routers;

import android.content.Context;
import android.util.Log;

import com.wlw.admin.routers.rule.Rule;


/**
 * step 1. 调用Router.router 方法店家路由
 * step 2. 调用Router.invoke 方法根据pattern 调用路由
 */
public class Router {
    /**
     * 添加自定义路由规则
     *
     * @param scheme 路由 scheme
     * @param rule   路由规则
     * @return Router 真是调用类
     */

    public static RouterInternal addRule(String scheme, Rule rule) {
        RouterInternal router = RouterInternal.get();
        router.addRule(scheme, rule);
        return router;
    }
    /**
     * 添加路由
     *
     * @param pattern 路由 uri
     * @param tClass  路由class
     * @return Router 真是调用类
     */
    public static <T> RouterInternal router(String pattern, Class<T> tClass) {
        return RouterInternal.get().router(pattern, tClass);
    }

    /**
     * 路由调用
     *
     * @param ctx     Context
     * @param pattern 路由 uri
     * @return 返回相应的返回值
     */
    public static <V> V invoke(Context ctx, String pattern) {
        return RouterInternal.get().invoke(ctx, pattern);
    }

    public static boolean resolveRouter(String pattern) {
        return RouterInternal.get().resolveRouter(pattern);
    }
}
