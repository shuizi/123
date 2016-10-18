package com.rca_gps.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendAuth;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

public class MainActivity extends AppCompatActivity {
    private String APP_ID = "wxe67de8e7791ddf88";
    public static final String APP_SECRET = "ac9c6dc94e3e84be9f0bd41a83c50bcb";
    private IWXAPI api;
    private SendAuth.Req req;
    private static final String WEIXIN_SCOPE = "snsapi_userinfo";
    private static final String WEIXIN_STATE = "login_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        api = WXAPIFactory.createWXAPI(this, APP_ID);
        api.registerApp(APP_ID);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendAuth();
            }
        });
    }

    private void sendAuth() {
        req = new SendAuth.Req();
        req.scope = WEIXIN_SCOPE;
        req.state = WEIXIN_STATE;
        api.sendReq(req);
    }
}
