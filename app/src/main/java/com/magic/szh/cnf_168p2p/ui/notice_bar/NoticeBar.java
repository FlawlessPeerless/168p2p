package com.magic.szh.cnf_168p2p.ui.notice_bar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseHome;

import java.util.List;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.ui.notice_bar
 * file: NoticeBar
 * author: admin
 * date: 2018/2/24
 * description: 公告栏
 */

public class NoticeBar extends ViewFlipper {
    private ItemClickListener mListener;

    public NoticeBar(Context context) {
        super(context);
    }

    public NoticeBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setData(List<ResponseHome.Notice> datas) {
        for (int i = 0; i < datas.size(); i++) {
            ResponseHome.Notice data = datas.get(i);
            View view = setView(data, i);
            int finalI = i;
            view.setOnClickListener(v -> {
                if (mListener != null) mListener.onItemClick(finalI, data);
            });
            addView(view);
        }
    }

    /**
     * 设置对应的公告item
     * @param data 数据
     * @param position 下标
     * @return view 视图
     */
    private AppCompatTextView setView(ResponseHome.Notice data, int position) {
        AppCompatTextView view = new AppCompatTextView(getContext());
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics()),0,0,0);
        view.setText(data.name);
        view.setLayoutParams(params);
        view.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
        view.setTextSize(Dimension.SP, 12);
        view.setTextColor(Color.GRAY);
        Drawable drawableLeft = getResources().getDrawable(R.drawable.icon_home_info_speaker);
        drawableLeft.setBounds(0,0,drawableLeft.getMinimumWidth(), drawableLeft.getMinimumHeight());
        Drawable drawableRight = null;
        if (data.isHot == 1) {
            drawableRight = getResources().getDrawable(R.drawable.icon_home_anouncement_new);
            drawableRight.setBounds(0,0,drawableRight.getMinimumWidth(),drawableRight.getMinimumHeight());
        }
        view.setCompoundDrawables(
                drawableLeft,
                null,
                drawableRight,
                null);
        view.setCompoundDrawablePadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
        return view;
    }

    /**
     * 设置按键监听
     * @param listener 监听事件对象
     */
    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }

    public interface ItemClickListener {
        void onItemClick(int position, ResponseHome.Notice data);
    }
}
