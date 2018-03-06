package com.magic.szh.cnf_168p2p.content.login;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.magic.szh.Magic;
import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.api.response.ResponseLoginByPhone;
import com.magic.szh.cnf_168p2p.api.response.ResponseUserInfo;
import com.magic.szh.cnf_168p2p.api.url.Api;
import com.magic.szh.cnf_168p2p.base.BaseFragment;
import com.magic.szh.cnf_168p2p.content.HomeActivity;
import com.magic.szh.cnf_168p2p.shared_preference.Constant;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.ISuccess;
import com.magic.szh.util.storage.MagicPreference;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.login
 * file: LoginPhoneFragment
 * author: admin
 * date: 2018/3/5
 * description: 手机登录 fragment
 */

public class LoginPhoneFragment extends BaseFragment {
    @BindView(R.id.text_login_phone)
    TextView mTextPhone;
    @BindView(R.id.edit_phone)
    TextInputEditText mEditPhone;
    @BindView(R.id.edit_password)
    TextInputEditText mEditPassword;
    /**
     * 入口点标识码{@link LoginActivity}
     */
    private int mLoginEntrance;

    @Override
    public Object setLayout() {
        return R.layout.fragment_login_phone;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initData();
        initLayout();
    }

    /**
     * 初始化数据参数
     */
    private void initData() {
        mLoginEntrance = getArguments().getInt(LoginActivity.KEY_LOGIN_ENTRANCE, 0);
    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        String telephone = MagicPreference.getString(Constant.USER_USER_NAME, null);
        if (TextUtils.isEmpty(telephone)){
            mTextPhone.setVisibility(View.GONE);
        } else {
            mTextPhone.setText(telephone);
            mEditPhone.setText(telephone);
            mTextPhone.setVisibility(View.VISIBLE);
        }
        mEditPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                 mTextPhone.setText(phoneNumberFormat(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) {
                    if (mTextPhone.getVisibility() == View.VISIBLE)
                        mTextPhone.setVisibility(View.GONE);
                } else {
                    if (mTextPhone.getVisibility() == View.GONE)
                        mTextPhone.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    /**
     * 本地验证登录信息
     * @return boolean 是否验证通过
     */
    private boolean checkForm() {
        String phone = mEditPhone.getText().toString().trim();
        String password = mEditPassword.getText().toString().trim();
        if (phone.isEmpty()) {
            Toast.makeText(getContext(), "手机号码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!Patterns.PHONE.matcher(phone).matches()) {
            Toast.makeText(getContext(), "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.isEmpty()) {
            Toast.makeText(getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.length() < 6 || password.length() > 16) {
            Toast.makeText(getContext(), "请输入6~16位字符密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 登录
     */
    @OnClick(R.id.button_sign_in)
    void clickSignIn() {
        if (checkForm()) {
            String phone = mEditPhone.getText().toString().trim();
            String password = mEditPassword.getText().toString().trim();
            startSignUp(phone, password);
        }
    }

    /**
     * 开始请求登录接口
     * @param phone 号码
     * @param password 密码
     */
    private void startSignUp(String phone, String password) {
        RestClient.builder()
                .url(Api.POST_LOGIN_BY_PHONE_NUMBER)
                .params("phone", phone)
                .params("password", password)
                .success(response -> {
                    ResponseLoginByPhone json = ResponseLoginByPhone.getInstance(response);
                    if (json.getCode() == 200) {
                        // TODO 成功跳转
                        MagicPreference.putString(Constant.SESSION_ID, json.getSessionId());
                        MagicPreference.putBoolean(Constant.USER_PHONE_BINDING, true);
                        MagicPreference.putLong(Constant.USER_LOGIN_DATE, System.currentTimeMillis());
                        // 获取用户信息
                        getUserInfo();

                    } else {
                        Toast.makeText(getContext(), json.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                })
                .build()
                .post();
    }

    /**
     * 请求用户信息
     */
    private void getUserInfo() {
        RestClient.builder()
                .url(Api.GET_USER_INFORMATION)
                .success(response -> {
                    ResponseUserInfo json = ResponseUserInfo.getInstance(response);
                    redirect(mLoginEntrance);
                })
                .build()
                .get();
    }

    /**
     * 注册
     */
    @OnClick(R.id.button_sign_up)
    void clickSignUp() {

    }

    /**
     * 找回密码
     */
    @OnClick(R.id.text_forget_button)
    void clickForgetPasswordView() {

    }

    /**
     * 切换登录方式
     */
    @OnClick(R.id.text_show_sign_in_type)
    void clickChangeSignInType() {

    }

    /**
     * 格式化手机号码
     * @param string 需要格式化的电话号码
     * @return 格式化后的电话号码
     */
    private String phoneNumberFormat(String string) {
        StringBuilder phoneBuilder = new StringBuilder();
        if (string.length() <= 3)
            phoneBuilder.append(string);
        if (string.length() > 3 && string.length() <= 7)
            phoneBuilder
                .append(string.subSequence(0, 3))
                .append("-")
                .append(string.substring(3));
        if (string.length() > 7)
            phoneBuilder
                .append(string.subSequence(0, 3))
                .append("-")
                .append(string.substring(3, 7))
                .append("-")
                .append(string.substring(7));
        return phoneBuilder.toString();
    }

    /**
     * 重定向至指定页面
     */
    private void redirect(int entrance) {
        int homeModuleCurrentPage;
        switch (entrance) {
            case LoginActivity.TYPE_INVESTMENT:
                homeModuleCurrentPage = HomeActivity.TAB_INVESTMENT;
                break;
            case LoginActivity.TYPE_ACCOUNT:
                homeModuleCurrentPage = HomeActivity.TAB_ACCOUNT;
                break;
            case LoginActivity.TYPE_FORUM:
                homeModuleCurrentPage = HomeActivity.TAB_FORUM;
                break;
            case LoginActivity.TYPE_MORE:
                homeModuleCurrentPage = HomeActivity.TAB_MORE;
                break;
            case LoginActivity.TYPE_LAUNCHER:
            default:
                homeModuleCurrentPage = HomeActivity.TAB_HOME;
        }
        HomeActivity.startHomeActivity(getContext(), homeModuleCurrentPage);
    }
}
