package com.wlw.admin.bbslib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.wlw.admin.annotation.AutoRouter;
import com.wlw.admin.routers.Router;
import com.wlw.admin.routers.rule.ActivityRule;
import com.wlw.admin.utilslib.Application;
import com.wlw.admin.utilslib.UseContext;

@AutoRouter
public class BBSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
        UseContext.use(Application.get());
        findViewById(R.id.btn_bbs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BBSActivity.this,R.string.click_notice,Toast.LENGTH_SHORT).show();
                if(Router.resolveRouter(ActivityRule.ACTIVITY_SCHEME+"shop.main")){
                    Intent it = Router.invoke(BBSActivity.this, ActivityRule.ACTIVITY_SCHEME + "shop.main");
                    startActivity(it);
                }
            }
        });
    }
}
