package com.magic.szh.cnf_168p2p.content.account;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseAccount;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.cnf_168p2p.content.account_information.AccountInformationActivity;
import com.magic.szh.cnf_168p2p.content.login.LoginActivity;
import com.magic.szh.cnf_168p2p.shared_preference.Constant;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.ISuccess;
import com.magic.szh.util.number.NumberUtil;
import com.magic.szh.util.storage.MagicPreference;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

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
    // 待收收益 文字
    @BindView(R.id.text_earnings)
    TextView mTextEarnings;
    // 总资产 文字
    @BindView(R.id.text_total)
    TextView mTextTotal;
    // 可用余额 文字
    @BindView(R.id.text_balance)
    TextView mTextBalance;
    // 红包 文字
    @BindView(R.id.text_red_bag)
    TextView mTextRedBagCount;
    // 现金券 文字
    @BindView(R.id.text_cash_coupon)
    TextView mTextCashCoupon;
    // 待收益 显示/隐藏按钮
    @BindView(R.id.text_desc_earnings)
    TextView mTextDescEarnings;

    @Override
    public Object setLayout() {
        return R.layout.fragment_account;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initLayout();
        initData(mSwipeRefreshLayout);
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
     * @param swipeRefreshLayout 下拉刷新模块
     */
    private void initData(SwipeRefreshLayout swipeRefreshLayout) {
        RestClient.builder()
                .url(Api.GET_ACCOUNT)
                .success(response -> {
                    ResponseAccount data = ResponseAccount.getInstance(response);
                    if (data.getCode() == 200 && data.getList() != null) {
                        renderView(data.getList());
                    } else if (data.getCode() == 11000) {
                        // 无法获取信息 返回登录界面
                        LoginActivity.startLoginActivity(getContext(), LoginActivity.TYPE_ACCOUNT);
                    } else {
                        Toast.makeText(getContext(), data.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                    swipeRefreshLayout.setRefreshing(false);
                })
                .build()
                .get();
    }

    /**
     * 根据数据 填充视图
     * @param list 数据
     */
    private void renderView(ResponseAccount.AccountInfo list) {
        mTextEarnings.setTag(NumberUtil.formatCurrency(list.getDsy()));
        mTextTotal.setTag(NumberUtil.formatCurrency(list.getZcze()));
        mTextBalance.setTag(NumberUtil.formatCurrency(list.getKyye()));
        boolean isShow = MagicPreference.getBoolean(Constant.USER_ACCOUNT_DISPLAY_STATUS, true);
        renderHeader(isShow);

        mTextRedBagCount.setText(String.format("%s元", NumberUtil.formatCurrency(list.getRedbagTotal())));
        mTextCashCoupon.setText(String.format(Locale.CHINA, "%d张可使用", list.getVoucherNum()));
    }

    /**
     * 点击切换头部信息展示状态
     */
    @OnClick(R.id.text_desc_earnings)
    void clickToggleHeadText() {
        boolean isShow = MagicPreference.getBoolean(Constant.USER_ACCOUNT_DISPLAY_STATUS, true);
        renderHeader(!isShow);
        MagicPreference.putBoolean(Constant.USER_ACCOUNT_DISPLAY_STATUS, !isShow);
    }

    /**
     * 点击查看待收收益
     */
    @OnClick(R.id.text_earnings)
    void clickBrowseEarnings() {
        // todo 查看待收收益
        AccountInformationActivity
                .startAccountModule(getContext(), AccountInformationActivity.MODULE_EARNING);
    }

    /**
     * 点击查看总资产信息
     */
    @OnClick({R.id.text_total, R.id.text_balance})
    void clickBrowseAccountAssetInfo() {
        // todo 查看总资产
        Toast.makeText(getContext(), "总资产", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击查看红包详情
     */
    @OnClick(R.id.button_red_bag)
    void clickBrowseRedBagInfo() {
        // todo 跳转信息查看模块
        Toast.makeText(getContext(), "红包详情", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击查看现金券详情
     */
    @OnClick(R.id.button_cash_coupon)
    void clickBrowseCouponList() {
        // todo 跳转查看现金券列表
        Toast.makeText(getContext(), "现金券列表", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击查看回款计划
     */
    @OnClick(R.id.button_back_plan)
    void clickBorwseBackPlan() {
        // todo 跳转查看回款计划
        Toast.makeText(getContext(), "回款计划", Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击查看投资记录
     */
    @OnClick(R.id.button_investment_record)
    void clickBorwseInvestmentRecord() {
        // todo 跳转查看投资记录
    }

    /**
     * 点击查看资金记录
     */
    @OnClick(R.id.button_fund_record)
    void clickBorwseFundRecord() {
        // todo 跳转查看资金记录
    }

    /**
     * 点击前往智能理财
     */
    @OnClick(R.id.button_smart_finance)
    void clickToSmartFinance() {
        // todo 点击跳转智能理财
    }

    /**
     * 点击转让债权
     */
    @OnClick(R.id.button_debt_transfer)
    void clickToTransferDebt() {
        // todo 点击债权转让
    }

    /**
     * 点击联盟计划
     */
    @OnClick(R.id.button_alliance_plan)
    void clickToAlliancePlan() {
        // todo 点击跳转联盟计划
    }

    /**
     * 点击组队理财
     */
    @OnClick(R.id.button_finance_group)
    void clickBorwseFinanceGroup() {
        // todo 组队理财
    }

    /**
     * 点击跳转投资助手
     */
    @OnClick(R.id.button_investment_assistant)
    void clickToInvestmentAssistant() {
        // todo 投资助手
    }


    /**
     * 根据状态显示数据
     * @param isShow 是否显示状态文字
     */
    private void renderHeader(boolean isShow) {
        if (isShow) {
            mTextEarnings.setText((String) mTextEarnings.getTag());
            mTextTotal.setText((String) mTextTotal.getTag());
            mTextBalance.setText((String) mTextBalance.getTag());
        } else {
            String hiddenText = "******";
            mTextEarnings.setText(hiddenText);
            mTextTotal.setText(hiddenText);
            mTextBalance.setText(hiddenText);
        }
        mTextDescEarnings.setCompoundDrawablesWithIntrinsicBounds(0, 0, isShow ? R.drawable.see_pressed2 : R.drawable.see_unpressed2, 0);
    }


}
