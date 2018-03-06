package com.magic.szh.cnf_168p2p.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.content.home.AccountFragment;
import com.magic.szh.cnf_168p2p.content.home.ForumFragment;
import com.magic.szh.cnf_168p2p.content.login.LoginActivity;
import com.magic.szh.cnf_168p2p.shared_preference.Constant;
import com.magic.szh.cnf_168p2p.ui.CustomViewPager;
import com.magic.szh.util.storage.MagicPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p
 * file: HomeActivity
 * author: admin
 * date: 2018/2/11
 * description: 主页
 */

public class HomeActivity extends BaseActivity {
    public static final String KEY_CURRENT_PAGE = "current_page";
    /**
     * tab状态标识 [0.首页 1.投资 2.账户 3.论坛 4.更多]
     */
    public static final int TAB_HOME = 0;
    public static final int TAB_INVESTMENT = 1;
    public static final int TAB_ACCOUNT = 2;
    public static final int TAB_FORUM = 3;
    public static final int TAB_MORE = 4;

    @BindView(R.id.view_pager)
    CustomViewPager mViewPager;
    @BindView(R.id.radio_group)
    RadioGroup mRadioGroup;
    @BindView(R.id.button_home)
    RadioButton mButtonHome;
    @BindView(R.id.button_investment)
    RadioButton mButtonInvestment;
    @BindView(R.id.button_account)
    RadioButton mButtonAccount;
    @BindView(R.id.button_forum)
    RadioButton mButtonForum;
    @BindView(R.id.button_more)
    RadioButton mButtonMore;

    private HomePagerAdapter mAdapter;

    private int mCurrentPage = R.id.button_home;

    /**
     * 切换至主页模块
     * @param context 上下文
     * @param page 当前页 {@linkplain HomeActivity}
     */
    public static void startHomeActivity(Context context, int page) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra(KEY_CURRENT_PAGE, page);
        context.startActivity(intent);
    }

    public static void startHomeActivity(Context context) {
        HomeActivity.startHomeActivity(context, TAB_HOME);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Log.e("home", "new_intent");
        getBackHome(intent.getExtras());
    }

    @Override
    public void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
        initTabFooter();
    }

    /**
     * 初始化底部footer
     */
    private void initTabFooter() {
        mRadioGroup.check(R.id.button_home);
        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.button_home:
                    tabSelected(TAB_HOME);
                    break;
                case R.id.button_investment:
                    tabSelected(TAB_INVESTMENT);
                    break;
                case R.id.button_account:
                    if (checkLoginState()) {
                        tabSelected(TAB_ACCOUNT);
                    } else {
                        group.check(mCurrentPage);
                        LoginActivity.startLoginActivity(HomeActivity.this, LoginActivity.TYPE_ACCOUNT);
                    }
                    break;
                case R.id.button_forum:
                    if (checkLoginState()) {
                        tabSelected(TAB_FORUM);
                    } else {
                        group.check(mCurrentPage);
                        LoginActivity.startLoginActivity(HomeActivity.this, LoginActivity.TYPE_FORUM);
                    }
                    break;
                case R.id.button_more:
                    tabSelected(TAB_MORE);
                    break;
            }
        });
    }


    /**
     * 检查当前用户登录状态
     * @return boolean True 已登录 / False 未登录
     */
    private boolean checkLoginState() {
        return !TextUtils.isEmpty(MagicPreference.getString(Constant.SESSION_ID, null))
                && MagicPreference.getBoolean(Constant.USER_PHONE_BINDING, false);
    }

    /**
     * 从其他模块来到主模块
     * @param bundle 携带的数据
     */
    private void getBackHome(Bundle bundle) {
        int currentPage = bundle.getInt(KEY_CURRENT_PAGE);
        tabSelected(currentPage);
        switch (currentPage) {
            case TAB_ACCOUNT:
                AccountFragment accountFragment = (AccountFragment) mAdapter.getItem(TAB_ACCOUNT);
                accountFragment.loadData();
                break;
            case TAB_FORUM:
                ForumFragment forumFragment = (ForumFragment) mAdapter.getItem(TAB_FORUM);
                forumFragment.loadData();
                break;
        }
    }

    /**
     * 切换对应的tab
     * @param tab {@link HomeActivity}
     */
    private void tabSelected(int tab) {
        // 先检查是否登录
        switch (tab) {
            case TAB_HOME:
                mViewPager.setCurrentItem(0);
                mCurrentPage = R.id.button_home;
                break;
            case TAB_INVESTMENT:
                mViewPager.setCurrentItem(1);
                mCurrentPage = R.id.button_investment;
                break;
            case TAB_ACCOUNT:
                mViewPager.setCurrentItem(2);
                mCurrentPage = R.id.button_account;
                break;
            case TAB_FORUM:
                mViewPager.setCurrentItem(3);
                mCurrentPage = R.id.button_forum;
                break;
            case TAB_MORE:
                mViewPager.setCurrentItem(4);
                mCurrentPage = R.id.button_more;
                break;
        }
        mRadioGroup.check(mCurrentPage);
    }

}
