package com.magic.szh.cnf_168p2p.content.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.base.MagicFragment;

public class LauncherActivity extends BaseActivity {

    @Override
    public void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_fragment_wrapper);
        addFragment(R.id.layout_fragment_wrapper, new LauncherFragment());
    }
}
