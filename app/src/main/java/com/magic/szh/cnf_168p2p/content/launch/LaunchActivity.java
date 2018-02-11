package com.magic.szh.cnf_168p2p.content.launch;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;

import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.content.home.HomeActivity;

public class LaunchActivity extends BaseActivity {
    // 启动页持续时间
    private static final int CONST_DURATION_TIME = 3000;

    @Override
    protected void initialize() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(LaunchActivity.this, HomeActivity.class));
            }
        }, CONST_DURATION_TIME);
    }

    @Override
    protected Fragment createFragment() {
        return new LaunchFragment();
    }

}
