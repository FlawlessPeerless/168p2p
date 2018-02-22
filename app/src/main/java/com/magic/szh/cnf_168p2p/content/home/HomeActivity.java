package com.magic.szh.cnf_168p2p.content.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseActivity;
import com.magic.szh.cnf_168p2p.base.MagicFragment;
import com.magic.szh.cnf_168p2p.ui.CustomViewPager;

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
        mTabLayout.setupWithViewPager(mViewPager);
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

}
