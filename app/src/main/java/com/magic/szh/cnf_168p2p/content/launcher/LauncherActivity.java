package com.magic.szh.cnf_168p2p.content.launcher;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.content.home.HomeActivity;
import com.magic.szh.net.RestClient;

public class LauncherActivity extends BaseActivity {
    // 启动页持续时间
    private static final int CONST_DURATION_TIME = 3000;

    @Override
    protected void initialize() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LauncherActivity.this, HomeActivity.class));
            }
        }, CONST_DURATION_TIME);
        RestClient.builder()
                .url("https://api.168p2p.com/version/version/peizhi")
                .success(response -> Log.e("123",response))
                .build()
                .get();
    }

    @Override
    protected Fragment createFragment() {
        return new LauncherFragment();
    }

}
