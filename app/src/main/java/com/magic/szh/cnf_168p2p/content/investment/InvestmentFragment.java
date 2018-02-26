package com.magic.szh.cnf_168p2p.content.investment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseFragment;

import butterknife.BindView;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: InvestmentFragment
 * author: admin
 * date: 2018/2/22
 * description: 主页 - 投资tab fragment
 */

public class InvestmentFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Override
    public Object setLayout() {
        return R.layout.fragment_investment;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initViewPager();
        initTabLayout();
    }

    /**
     * 初始化 标的列表
     */
    private void initViewPager() {
        mViewPager.setAdapter(new SubjectPagerAdapter(getChildFragmentManager()));
        mViewPager.setOffscreenPageLimit(2);
    }

    /**
     * 初始化 顶部切换按钮
     */
    private void initTabLayout() {
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(tabCreator(i));
        }
    }

    private View tabCreator(int position) {
        TextView textView = new TextView(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(layoutParams);
        int[] colors = new int[]{getContext().getResources().getColor(R.color.colorPrimary), Color.WHITE};
        int[][] state = new int[2][];
        state[0] = new int[]{android.R.attr.state_selected};
        state[1] = new int[]{};
        ColorStateList colorStateList = new ColorStateList(state, colors);
        textView.setTextColor(colorStateList);
        textView.setGravity(Gravity.CENTER);
        if (position == 0) {
            textView.setText("定期理财");
            textView.setBackgroundResource(R.drawable.selector_investment_title_left);
        } else {
            textView.setText("债权转让");
            textView.setBackgroundResource(R.drawable.selector_investment_title_right);
        }
        return textView;
    }
}
