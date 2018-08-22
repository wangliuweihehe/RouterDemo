package com.wlw.admin.routerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.wlw.admin.routers.Router;
import com.wlw.admin.routers.rule.ActivityRule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_text).setOnClickListener(v -> {
            if (Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME + "shop.main")) {
                Intent intent = Router.invoke(this, ActivityRule.ACTIVITY_SCHEME + "shop.main");
                startActivity(intent);
            }
        });
    }
}
