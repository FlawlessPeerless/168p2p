package com.magic.szh.cnf_168p2p.content.investment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.IError;
import com.magic.szh.net.callback.IFailure;
import com.magic.szh.net.callback.ISuccess;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: RegularInvestmentFragment
 * author: admin
 * date: 2018/2/26
 * description: Investment -  定期理财
 */

public class RegularInvestmentFragment extends BaseFragment {
    private int mCurrentPage = 1;

    @Override
    public Object setLayout() {
        return R.layout.fragment_regular_investment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRegularInvestmentData();

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
                    Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                })
                .failure(t -> {

                })
                .error((code, msg) -> {

                })
                .build()
                .get();
    }
}
