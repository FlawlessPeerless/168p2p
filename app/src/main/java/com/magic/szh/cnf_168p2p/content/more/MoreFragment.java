package com.magic.szh.cnf_168p2p.content.more;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.BaseResponse;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.cnf_168p2p.content.login.LoginActivity;
import com.magic.szh.cnf_168p2p.shared_preference.Constant;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.ISuccess;
import com.magic.szh.util.pkg.PackageUtil;
import com.magic.szh.util.storage.MagicPreference;

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
    @BindView(R.id.button_quit)
    Button mQuitButton;

    @Override
    public Object setLayout() {
        return R.layout.fragment_more;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        setCurrentVersion();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (checkLoginStatus()) mQuitButton.setVisibility(View.VISIBLE);
        else mQuitButton.setVisibility(View.INVISIBLE);
    }

    /**
     * 获取当前apk版本
     */
    private void setCurrentVersion() {
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
    void clickIntroButton() {
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
        // TODO 退出登录 （跳出alert确定退出）
        RestClient.builder()
                .url(Api.GET_LOG_OUT)
                .success((String response) -> {
                    BaseResponse json = BaseResponse.getInstance(response);
                    if (json.getCode() == 200) {
                        LoginActivity.clearLogoutConfig();
                        LoginActivity.startLoginActivity(getContext(), LoginActivity.TYPE_MORE);
                        mQuitButton.setVisibility(View.INVISIBLE);
                    } else {
                        Toast.makeText(getContext(), json.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .get();
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

    /**
     * 检测是否登录
     * @return True 登录 / False 未登录
     */
    private boolean checkLoginStatus() {
        return !TextUtils.isEmpty(MagicPreference.getString(Constant.SESSION_ID, null))
                && MagicPreference.getBoolean(Constant.USER_PHONE_BINDING, false);
    }

}
