package com.magic.szh.cnf_168p2p.content.launcher;

import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.base.MagicFragment;

public class LauncherActivity extends BaseActivity {

    @Override
    public MagicFragment setRootFragment() {
        return new LauncherFragment();
    }

}
