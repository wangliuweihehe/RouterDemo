package com.wlw.admin.shoplib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wlw.admin.annotation.StaticRouter;
import com.wlw.admin.routers.Router;
import com.wlw.admin.routers.rule.ActivityRule;
import com.wlw.admin.utilslib.Application;
import com.wlw.admin.utilslib.Logger;
import com.wlw.admin.utilslib.UseContext;
@StaticRouter(ActivityRule.ACTIVITY_SCHEME+"shop.main")
public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Logger.dump("TAG", "Hei! I am shop !!");
        UseContext.use(Application.get());
        TextView tv_text = findViewById(R.id.tv_text);
        tv_text.setText("Shop!");
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShopActivity.this, R.string.click_notice, Toast.LENGTH_SHORT).show();
                if (Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME + "com.wlw.admin.bbslib.BBSActivity")) {
                    Intent intent = Router.invoke(ShopActivity.this, ActivityRule.ACTIVITY_SCHEME + "com.wlw.admin.bbslib.BBSActivity");
                    startActivity(intent);
                }
            }
        });
    }
}
