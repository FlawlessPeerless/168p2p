package com.magic.szh.cnf_168p2p.content.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseTransferInvestment;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.IError;
import com.magic.szh.net.callback.IFailure;
import com.magic.szh.net.callback.ISuccess;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.List;

import butterknife.BindView;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: CreditTransferFragment
 * author: admin
 * date: 2018/2/26
 * description: Investment - 债权转让
 */

public class CreditTransferFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    // 数据列表适配器
    CreditTransferListAdapter mAdapter;
    // 当前加载的页数
    private int mCurrentPage = 1;
    // 是否正在加载数据中
    private boolean isLoading = false;


    @Override
    public Object setLayout() {
        return R.layout.fragment_creadit_transfer;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initLayout();
    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        mAdapter = new CreditTransferListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                if (isLoading) return;
                updateTransferInvestmentData(refreshLayout);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                if (isLoading) return;
                initTransferInvestmentData(refreshLayout);
            }
        });
        initTransferInvestmentData(mRefreshLayout);
    }

    private void initTransferInvestmentData(RefreshLayout refreshLayout) {
        refreshLayout.setNoMoreData(false);
        isLoading = true;
        mCurrentPage = 1;
        RestClient.builder()
                .url(Api.GET_MAIN_INVESTMENT_TRANSFER)
                .params("page",mCurrentPage)
                .success(response -> {
                    isLoading = false;
                    ResponseTransferInvestment data = ResponseTransferInvestment.getInstance(response);
                    if (data.getCode() == 200) {
                        List<ResponseTransferInvestment.SubjectPojo> list =  data.getList();
                        if (list.size() > 0) {
                            mAdapter.initData(list);
                        } else {
                            // TODO 显示空数据图标
                            Toast.makeText(getContext(), "没有数据了...", Toast.LENGTH_SHORT).show();
                        }
                        refreshLayout.finishRefresh(true);
                    } else {
                        refreshLayout.finishRefresh(false);
                    }
                })
                .error((code, msg) -> refreshLayout.finishRefresh(false))
                .build()
                .get();
    }

    private void updateTransferInvestmentData(RefreshLayout refreshLayout) {
        isLoading = true;
        mCurrentPage++;
        RestClient.builder()
                .url(Api.GET_MAIN_INVESTMENT_TRANSFER)
                .params("page", mCurrentPage)
                .success(response -> {
                    isLoading = false;
                    ResponseTransferInvestment data = ResponseTransferInvestment.getInstance(response);
                    if (data.getCode() == 200) {
                        List<ResponseTransferInvestment.SubjectPojo> list = data.getList();
                        if (list.size() > 0) {
                            mAdapter.addData(list);
                            refreshLayout.finishLoadMore(true);
                        } else {
                            refreshLayout.finishLoadMoreWithNoMoreData();
                        }
                    } else {
                        refreshLayout.finishLoadMore(false);
                    }
                })
                .error((code, msg) -> refreshLayout.finishLoadMore(false))
                .build()
                .get();
    }

}
