package com.magic.szh.cnf_168p2p.base;

import android.content.Context;
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
import me.yokeyword.fragmentation.SupportFragment;

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
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer)setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("setLayout() type must be int or View");
        }

        mUnbinder = ButterKnife.bind(this, rootView);
        onBindView(savedInstanceState, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) mUnbinder.unbind();
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity)getActivity();
    }


    public abstract Object setLayout();

    /**
     * 视图被绑定后的回调
     * @param savedInstanceState 已存储的状态实例生命周期
     * @param rootView 视图类
     */
    public abstract void onBindView(@Nullable Bundle savedInstanceState, View rootView);
}
