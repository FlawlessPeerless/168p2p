package com.magic.szh.cnf_168p2p.content.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.base.BaseFragment;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.login
 * file: LoginActivity
 * author: admin
 * date: 2018/3/5
 * description: 登录模块
 */

public class LoginActivity extends BaseActivity {
    public static final int TYPE_PHONE = 0;
    public static final int TYPE_WECHAT = 1;
    public static final int TYPE_QQ = 2;
    public static final int TYPE_WEIBO = 3;
    public static final int TYPE_CNF = 4;

    /**
     * 启动登录
     * @param context 上下文
     * @param type 登录方式
     */
    public static void startLoginActivity(Context context, int type) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("type", type);
        context.startActivity(intent);
    }

    /**
     * 启动登录
     * @param context 上下文
     */
    public static void startLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        initLoginLayout();
    }

    /**
     * 初始化登录类型对应布局
     */
    private void initLoginLayout() {
        BaseFragment loginByPhoneFragment = new LoginPhoneFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.layout_fragment_wrapper, loginByPhoneFragment)
                .commit();
    }
}
