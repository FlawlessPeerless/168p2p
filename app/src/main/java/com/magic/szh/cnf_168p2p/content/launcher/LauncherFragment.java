package com.magic.szh.cnf_168p2p.content.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.MagicFragment;
import com.magic.szh.util.storage.MagicPreference;
import com.magic.szh.util.timer.BaseTimerTask;
import com.magic.szh.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 启动页fragment
 */

public class LauncherFragment extends MagicFragment implements ITimerListener {
    @BindView(R.id.text_view_launcher_timer)
    AppCompatTextView  mTextViewTimer;

    private Timer mTimer = null;
    private int mCount = 5;

    @OnClick(R.id.text_view_launcher_timer)
    void onClickTimerView() {
        checkIsFirstLauncher();
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    @Override
    public void onTimer() {
        getActivity().runOnUiThread(() -> {
            mTextViewTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
            mCount--;
            if (mCount < 0) {
                if (mTimer != null) {
                    mTimer.cancel();
                    mTimer = null;
                    checkIsFirstLauncher();
                }
            }
        });
    }

    private void initTimer() {
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task, 0, 1000);
    }

    /**
     * 判断是否首次登录
     */
    private void checkIsFirstLauncher() {
        if(MagicPreference.getAppFlag(LauncherTag.HAS_FIRST_LAUNCHER_APP.name())) {
            // TODO 启动GuideFragment
        } else {
            // TODO 检查用户是否登录App

        }
    }
}
