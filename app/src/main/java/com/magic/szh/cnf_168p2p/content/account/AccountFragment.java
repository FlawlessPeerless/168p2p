package com.magic.szh.cnf_168p2p.content.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseFragment;

import butterknife.BindView;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: AccountFragment
 * author: admin
 * date: 2018/2/22
 * description: 用户账户
 */

public class AccountFragment extends BaseFragment {
    @BindView(R.id.refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public Object setLayout() {
        return R.layout.fragment_account;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initLayout();
    }

    /**
     * 加载数据
     */
    public void loadData() {
        // todo 数据加载
    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            if (mSwipeRefreshLayout.isRefreshing()) return;
            initData();
            mSwipeRefreshLayout.setRefreshing(false);

        });
    }

    /**
     * 初始化数据
     */
    private void initData() {

    }
}
