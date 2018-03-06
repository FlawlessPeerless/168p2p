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
import android.widget.ImageView;
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
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    private HomePagerAdapter mAdapter;

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
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                if (pos == 2) {

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        initTabLayout();
    }

    /**
     * 初始化tab layout布局
     */
    private void initTabLayout() {
        int count = mTabLayout.getTabCount();
        for (int i = 0; i < count; i++) {
            int drawable = 0;
            String name = "";
            switch (i) {
                case 0:
                    name = "首页";
                    drawable = R.drawable.selector_home_tab_work;
                    break;
                case 1:
                    name = "理财";
                    drawable = R.drawable.selector_home_tab_discovery;
                    break;
                case 2:
                    name = "账户";
                    drawable = R.drawable.selector_home_tab_mine;
                    break;
                case 3:
                    name = "社区";
                    drawable = R.drawable.selector_home_tab_forum;
                    break;
                case 4:
                    name = "更多";
                    drawable = R.drawable.selector_home_tab_more;
                    break;
            }
            mTabLayout.getTabAt(i).setCustomView(tabCreator(name, drawable));
        }
    }

    /**
     * 构建自定义 home tab
     * @param name tab 名
     * @param iconId tab 图标id
     * @return view 返回视图
     */
    private View tabCreator(String name, int iconId) {
        View newTab = LayoutInflater.from(this).inflate(R.layout.tab_home_view, null, false);
        TextView textView = newTab.findViewById(R.id.text_view_title);
        textView.setText(name);
        ImageView imageView = newTab.findViewById(R.id.image_view_icon);
        imageView.setImageResource(iconId);
        return newTab;
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
        mViewPager.setCurrentItem(currentPage);
        if (currentPage == TAB_ACCOUNT) {
            // 直接启动个人中心
            AccountFragment accountFragment = (AccountFragment) mAdapter.getItem(TAB_ACCOUNT);
            accountFragment.loadData();
        } else if (currentPage == TAB_FORUM) {
            // 直接启动论坛
            ForumFragment forumFragment = (ForumFragment) mAdapter.getItem(TAB_FORUM);
            forumFragment.loadData();
        }
    }

    /**
     * 自定义tab点击事件
     */
    private View.OnClickListener mTabOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = (int) v.getTag();
            if (pos == 2) {
                Toast.makeText(HomeActivity.this, "111", Toast.LENGTH_SHORT).show();
            } else {
                TabLayout.Tab tab = mTabLayout.getTabAt(pos);
                if (tab != null) {
                    tab.select();
                    mViewPager.setCurrentItem(pos);
                }
            }
        }
    };

    private boolean onTabSelected(int pos) {
        boolean isLogin = false;
        if (pos == 2 || pos == 3) {
            //checkLoginState();
            if (false) {
              isLogin = true;
            } else {
                int loginType;
                switch (pos) {
                    case 2:
                        loginType = LoginActivity.TYPE_ACCOUNT;
                        break;
                    case 3:
                        loginType = LoginActivity.TYPE_FORUM;
                        break;
                    default:
                        loginType = LoginActivity.TYPE_LAUNCHER;
                }
                LoginActivity
                        .startLoginActivity(HomeActivity.this, loginType);
            }
        }
        return isLogin;
    }

}
