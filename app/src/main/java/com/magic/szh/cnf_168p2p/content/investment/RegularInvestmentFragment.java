package com.magic.szh.cnf_168p2p.content.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseRegularInvestment;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.IError;
import com.magic.szh.net.callback.IFailure;
import com.magic.szh.net.callback.ISuccess;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

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
        initRegularInvestmentData();

    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        mSubjectPojoList = new ArrayList<>();
        mAdapter = new RegularInvestmentListAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 初始化 定期理财 数据列表
     */
    private void initRegularInvestmentData() {
        updateRegularInvestmentData(mCurrentPage);
    }

    /**
     * 更新 定期理财 数据列表
     * @param page 当前页码
     */
    private void updateRegularInvestmentData(int page){
        RestClient.builder()
                .url(Api.GET_MAIN_INVESTMENT_REGULAR)
                .params("page", page)
                .params("type", "borrowList")
                .params("logtype", "andior")
                .success(response -> {
                    ResponseRegularInvestment json = ResponseRegularInvestment.getInstance(response);
                    if (json.getCode() == 200) {
                        List<ResponseRegularInvestment.SubjectPojo> newList = json.getList().getList();
                        if (newList.size() > 0) {
                            mAdapter.addDataItems(newList);
                        } else {
                            // TODO 加载完毕
                        }
                    }
                })
                .failure(t -> {

                })
                .error((code, msg) -> {

                })
                .build()
                .get();
    }
}
