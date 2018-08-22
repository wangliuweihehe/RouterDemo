package com.wlw.admin.routers.rule;

import android.content.Context;

/**
 * 路由规则接口
 */
public interface Rule<T, V> {
    /**
     * 添加路由
     *
     * @param pattern 路由uri
     */
    void router(String pattern, Class<T> tClass);

    /**
     * 路由条用
     *
     * @param ctx     Context
     * @param pattern 路由uri
     * @return 返回值
     */
    V invoke(Context ctx, String pattern);

    /**
     * @param pattern uri
     * @return 查看是否存在 pattern 对应的路由
     */
    boolean resolveRule(String pattern);
}
