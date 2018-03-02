package com.magic.szh.cnf_168p2p.content.more;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.util.pkg.PackageUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.home
 * file: MoreFragment
 * author: admin
 * date: 2018/2/22
 * description: 主页 - tab 更多
 */

public class MoreFragment extends BaseFragment {

    @BindView(R.id.text_version)
    TextView mVersionText;

    @Override
    public Object setLayout() {
        return R.layout.fragment_more;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        getCurrentVersion();
    }

    /**
     * 获取当前apk版本
     */
    private void getCurrentVersion() {
        mVersionText.setText(String.format("168理财v%s", PackageUtil.getAppVersion(getContext())));
    }

    /**
     * 关于我们 按钮
     */
    @OnClick(R.id.button_about)
    void clickAboutButton() {
        // TODO 关于
    }

    /**
     * 简介 按钮
     */
    @OnClick(R.id.button_intro)
    void clcikIntroButton() {
        // TODO 公司简介
    }

    /**
     * 意见反馈 按钮
     */
    @OnClick(R.id.button_feedback)
    void clickFeedbackButton() {
        // TODO 意见反馈
    }

    /**
     * 退出登录 按钮
     */
    @OnClick(R.id.button_quit)
    void clickQuit() {
        // TODO 退出登录
    }

    /**
     * 分享至 微信
     */
    @OnClick(R.id.button_contact_wechat)
    void clickShareToWechat() {
        // TODO 分享至微信
    }

    /**
     * 分享至 QQ
     */
    @OnClick(R.id.button_contact_qq)
    void clickShareToQQ() {
        // TODO 分享至QQ
    }

    /**
     * 拨打客服电话
     */
    @OnClick(R.id.button_contact_tel)
    void clickToCall() {
        // TODO 拨打客服电话
    }


}
