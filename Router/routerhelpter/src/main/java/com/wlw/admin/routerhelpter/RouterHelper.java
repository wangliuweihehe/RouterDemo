package com.wlw.admin.routerhelpter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RouterHelper {
    public static void install(){
        try {
            Class<?>klass=Class.forName(Config.PACKAGE_NAME+"."+Config.ROUTER_MANAGER);
            Method method=klass.getDeclaredMethod(Config.ROUTER_MANAGER_METHOD);
            method.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
