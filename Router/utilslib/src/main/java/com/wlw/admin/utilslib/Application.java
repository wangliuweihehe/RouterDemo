package com.wlw.admin.utilslib;

import android.annotation.SuppressLint;

public class Application {
    private static android.app.Application sInstance;

    @SuppressLint("PrivateApi")
    public static android.app.Application get() {
        android.app.Application app = null;
        try {
            app = (android.app.Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
            if (app == null) {
                throw new IllegalStateException("Static initialization of Applications must be on main thread");
            }
        } catch (Exception e) {
            try {
                sInstance = (android.app.Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            sInstance = app;
        }
        return sInstance;
    }
}
