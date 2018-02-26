package com.magic.szh.cnf_168p2p.content.investment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.magic.szh.cnf_168p2p.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.investment
 * file: SubjectPagerAdapter
 * author: admin
 * date: 2018/2/26
 * description: 投资列表页-  标的适配器
 */

public class SubjectPagerAdapter extends FragmentPagerAdapter {
    List<BaseFragment> subjectList;

    public SubjectPagerAdapter(FragmentManager fm) {
        super(fm);
        subjectList = new ArrayList<>();
        subjectList.add(new RegularInvestmentFragment());
        subjectList.add(new CreditTransferFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return subjectList.get(position);
    }

    @Override
    public int getCount() {
        return subjectList.size();
    }
}
