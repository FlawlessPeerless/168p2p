package com.magic.szh.cnf_168p2p.content.home;

import android.support.v4.app.Fragment;

import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.base.MagicFragment;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p
 * file: HomeActivity
 * author: admin
 * date: 2018/2/11
 * description: 主页
 */

public class HomeActivity extends BaseActivity {

    @Override
    public MagicFragment setRootFragment() {
        return new HomeFragment();
    }
}
