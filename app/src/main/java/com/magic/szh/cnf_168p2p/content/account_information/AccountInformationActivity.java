package com.magic.szh.cnf_168p2p.content.account_information;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.account_information
 * file: AccountInformationActivity
 * author: admin
 * date: 2018/3/9
 * description: 账户信息详情页
 */

public class AccountInformationActivity extends BaseActivity {
    public static final String KEY_MODULE_NAME = "module_name";
    // 待收收益
    public static final int MODULE_EARNING = 0;
    // 总资产 & 可用余额
    public static final int MODULE_TOTAL_ASSETS = 1;
    // 红包详情
    public static final int MODULE_BONUS = 2;
    // 现金券详情
    public static final int MODULE_CASH_COUPON = 3;
    // 回款计划
    public static final int MODULE_CASH_RETURNED_PREVIEW = 4;



    public static void startAccountModule(Context context, int module) {
        Intent intent = new Intent(context, AccountInformationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MODULE_NAME, module);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_fragment_wrapper);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) return;
        moduleDispatch(bundle.getInt(KEY_MODULE_NAME));
    }

    /**
     * 模块调度
     * @param module 模块编号
     */
    private void moduleDispatch(int module) {
        switch (module) {
            case MODULE_EARNING:
                Toast.makeText(AccountInformationActivity.this, "待收收益模块进入", Toast.LENGTH_SHORT).show();
                break;
            case MODULE_TOTAL_ASSETS:
                Toast.makeText(AccountInformationActivity.this, "总资产模块进入", Toast.LENGTH_SHORT).show();
                break;
            case MODULE_BONUS:
                Toast.makeText(AccountInformationActivity.this, "红包详情模块进入",Toast.LENGTH_SHORT).show();
                break;
            case MODULE_CASH_COUPON:
                Toast.makeText(AccountInformationActivity.this, "现金券详情模块进入",Toast.LENGTH_SHORT).show();
                break;
            case MODULE_CASH_RETURNED_PREVIEW:
                Toast.makeText(AccountInformationActivity.this, "回款计划详情模块进入",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
