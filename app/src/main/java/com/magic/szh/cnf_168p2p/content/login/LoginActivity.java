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
    /**
     *  入口点 键
     */
    public static final String KEY_LOGIN_ENTRANCE = "login_entrance";
    /**
     * 入口点 值 [0.启动页 1.投资列表 2.个人中心 3.论坛 4.更多]
     */
    public static final int TYPE_LAUNCHER = 0;
    public static final int TYPE_INVESTMENT = 1;
    public static final int TYPE_ACCOUNT = 2;
    public static final int TYPE_FORUM = 3;
    public static final int TYPE_MORE = 4;

    /**
     * 启动登录 带参（入口点信息）
     * @param context 上下文
     * @param type 登录入口点
     */
    public static void startLoginActivity(Context context, int type) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(KEY_LOGIN_ENTRANCE, type);
        context.startActivity(intent);
    }

    /**
     * 启动登录 (默认启动页登录)
     * @param context 上下文
     */
    public static void startLoginActivity(Context context) {
        LoginActivity.startLoginActivity(context, 0);
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
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_LOGIN_ENTRANCE, getIntent().getIntExtra(KEY_LOGIN_ENTRANCE, 0));
        BaseFragment loginByPhoneFragment = new LoginPhoneFragment();
        // 设置参数
        loginByPhoneFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.layout_fragment_wrapper, loginByPhoneFragment)
                .commit();
    }
}
