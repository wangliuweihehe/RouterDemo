package com.wlw.admin.routerdemo.app;

import android.support.multidex.MultiDexApplication;

import com.wlw.admin.annotation.Components;
import com.wlw.admin.routerhelpter.RouterHelper;
import com.wlw.admin.utilslib.Logger;

@Components({"shop", "bbs"})
public class App extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.dump("TAG", "application: " + getClass().getName());
        RouterHelper.install();
    }
}
