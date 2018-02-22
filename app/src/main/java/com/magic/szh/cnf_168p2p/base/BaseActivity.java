package com.magic.szh.cnf_168p2p.base;

import android.content.Context;
import android.os.Bundle;
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

public abstract class BaseActivity extends SupportActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setContentView(R.layout.activity_fragment_wrapper);
        mFragmentManager = getSupportFragmentManager();
        initContainer(savedInstanceState);
    }

    /**
     * 设置初始fragment
     * @return MagicFragment 实现类
     */
    public abstract MagicFragment setRootFragment();

    private void initContainer(@Nullable Bundle savedInstanceState) {
        final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.fragment_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fragment_container, setRootFragment());
        }
    }

    /**
     * 垃圾回收
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(IconicsContextWrapper.wrap(newBase));
    }
}
