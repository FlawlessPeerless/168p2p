package com.magic.szh.cnf_168p2p.content.account;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.ISuccess;

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
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimaryDark));
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            initData(mSwipeRefreshLayout);
        });
    }

    /**
     * 初始化数据
     * @param swipeRefreshLayout
     */
    private void initData(SwipeRefreshLayout swipeRefreshLayout) {
        RestClient.builder()
                .url(Api.GET_ACCOUNT)
                .success(response -> {
                    Log.e("110", response);
                    Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    swipeRefreshLayout.setRefreshing(false);
                })
                .build()
                .get();
    }
}
