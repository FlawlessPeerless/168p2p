package com.magic.szh.cnf_168p2p.content.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.cnf_168p2p.content.investment.InvestmentFragment;
import com.magic.szh.cnf_168p2p.content.more.MoreFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: HomePagerAdapter
 * author: admin
 * date: 2018/2/22
 * description: 主页tab适配器
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragmentList;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new InvestmentFragment());
        mFragmentList.add(new AccountFragment());
        mFragmentList.add(new ForumFragment());
        mFragmentList.add(new MoreFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentList.get(position).getClass().getSimpleName();
    }
}
