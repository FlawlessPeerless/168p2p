package com.magic.szh.cnf_168p2p.content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;
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
    @BindView(R.id.view_pager)
    CustomViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Override
    public void initContainer(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mViewPager.setAdapter(new HomePagerAdapter(getSupportFragmentManager()));
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 2 || position == 3) {
                    boolean isLogin = checkLoginState();
                    if (isLogin) {

                    } else {
                        LoginActivity
                                .startLoginActivity(HomeActivity.this);
                    }
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

}
