package com.magic.szh.cnf_168p2p.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;

import com.magic.szh.cnf_168p2p.R;
import com.mikepenz.iconics.context.IconicsContextWrapper;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.base
 * file: BaseActivity
 * author: admin
 * date: 2018/2/11
 * description: activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        mFragmentManager = getSupportFragmentManager();
        initContainer(savedInstanceState);
    }

    public abstract void initContainer(@Nullable Bundle savedInstanceState);

    /**
     * 添加fragment
     * @param viewId 挂载的view id
     * @param fragment 挂载的fragment
     */
    public void addFragment(@IdRes int viewId, MagicFragment fragment) {
        mFragmentManager
                .beginTransaction()
                .add(viewId, fragment)
                .commit();
    }

    /**
     * 替换fragment
     * @param viewId 挂载的view id
     * @param fragment 挂载的view
     */
    public void replaceFragment(@IdRes int viewId, MagicFragment fragment) {
        mFragmentManager
                .beginTransaction()
                .replace(viewId, fragment)
                .commit();
    }

    /**
     * 垃圾回收
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    /**
     * 重写自定义文字图标
     * @param newBase
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }
}
