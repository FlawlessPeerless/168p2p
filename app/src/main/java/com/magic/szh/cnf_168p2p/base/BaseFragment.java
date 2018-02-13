package com.magic.szh.cnf_168p2p.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magic.szh.cnf_168p2p.R;
import com.mikepenz.iconics.context.IconicsLayoutInflater;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.base
 * file: BaseFragment
 * author: admin
 * date: 2018/2/11
 * description: fragment 基类
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = createView(inflater, container, savedInstanceState);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) mUnbinder.unbind();
    }

    protected abstract View createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
