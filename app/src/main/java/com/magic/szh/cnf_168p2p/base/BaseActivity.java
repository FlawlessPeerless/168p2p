package com.magic.szh.cnf_168p2p.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.magic.szh.cnf_168p2p.R;

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
        setContentView(R.layout.activity_fragment_wrapper);
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = createFragment();
        if (fragment == null) return;
        mFragmentManager.beginTransaction()
                .add(R.id.layout_fragment_wrapper, fragment)
                .commit();

        initialize();
    }

    /**
     * activity初始化
     */
    protected abstract void initialize();

    /**
     * 创建初始fragment
     * @return Fragment
     */
    protected abstract Fragment createFragment();

    /**
     * 添加fragment
     * @param fragment 被添加的fragment
     * @param args fragment参数
     * @param tag 对应的回退栈标记
     */
    public void addFragment(Fragment fragment,Bundle args ,String tag) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layout_fragment_wrapper, fragment, tag);
        if (args != null) {
            fragment.setArguments(args);
        }
        if (!TextUtils.isEmpty(tag)) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.commit();
    }

    public void addFragment(Fragment fragment) {
        addFragment(fragment, null, null);
    }

    public void addFragment(Fragment fragment, Bundle args) {
        addFragment(fragment, args, null);
    }

    public void addFragment(Fragment fragment, String tag) {
        if (TextUtils.isEmpty(tag)) {
            tag = null;
        }
        addFragment(fragment, null, tag);
    }


}
