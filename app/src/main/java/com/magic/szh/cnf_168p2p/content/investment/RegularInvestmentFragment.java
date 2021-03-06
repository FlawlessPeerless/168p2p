package com.magic.szh.cnf_168p2p.content.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseRegularInvestment;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.net.RestClient;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: RegularInvestmentFragment
 * author: admin
 * date: 2018/2/26
 * description: Investment -  定期理财
 */

public class RegularInvestmentFragment extends BaseFragment {
    // 当前是否在加载数据的状态
    private boolean isLoading = false;
    // 当前请求的页码
    private int mCurrentPage = 1;
    // 标的数据实体类列表
    List<ResponseRegularInvestment.SubjectPojo> mSubjectPojoList;

    // 数据列表适配器
    private RegularInvestmentListAdapter mAdapter;

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;


    @Override
    public Object setLayout() {
        return R.layout.fragment_regular_investment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initLayout();

    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        mSubjectPojoList = new ArrayList<>();
        mAdapter = new RegularInvestmentListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (isLoading) return;
                updateRegularInvestmentData(refreshLayout);
            }
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (isLoading) return;
                initRegularInvestmentData(refreshLayout);
            }
        });
        initRegularInvestmentData(mRefreshLayout);
    }

    /**
     * 初始化 定期理财 数据列表
     * @param refreshLayout
     */
    private void initRegularInvestmentData(RefreshLayout refreshLayout) {
        refreshLayout.setNoMoreData(false);
        isLoading = true;
        mCurrentPage = 1;
        RestClient.builder()
                .url(Api.GET_MAIN_INVESTMENT_REGULAR)
                .params("page", mCurrentPage)
                .params("type", "borrowList")
                .params("logtype", "andior")
                .success(response -> {
                    isLoading = false;
                    ResponseRegularInvestment json = ResponseRegularInvestment.getInstance(response);
                    if (json.getCode() == 200) {
                        List<ResponseRegularInvestment.SubjectPojo> newList = json.getList().getList();
                        if (newList.size() > 0) {
                            mAdapter.initDataItems(newList);
                        } else {
                            // 加载完毕
                            Toast.makeText(getContext(), "没有数据", Toast.LENGTH_SHORT).show();
                        }
                        refreshLayout.finishRefresh(true);
                    } else {
                        refreshLayout.finishRefresh(false);
                    }
                })
                .build()
                .get();
    }

    /**
     * 更新 定期理财 数据列表
     * @param refreshLayout 下拉刷新模块
     */
    private void updateRegularInvestmentData(RefreshLayout refreshLayout){
        isLoading = true;
        mCurrentPage++;
        RestClient.builder()
                .url(Api.GET_MAIN_INVESTMENT_REGULAR)
                .params("page", mCurrentPage)
                .params("type", "borrowList")
                .params("logtype", "andior")
                .success(response -> {
                    isLoading = false;
                    ResponseRegularInvestment json = ResponseRegularInvestment.getInstance(response);
                    if (json.getCode() == 200) {
                        List<ResponseRegularInvestment.SubjectPojo> newList = json.getList().getList();
                        if (newList.size() > 0) {
                            mAdapter.addDataItems(newList);
                            refreshLayout.finishLoadMore(true);
                        } else {
                            refreshLayout.finishLoadMoreWithNoMoreData();
                        }
                    } else {
                        refreshLayout.finishLoadMore(false);
                    }
                })
                .build()
                .get();
    }
}
