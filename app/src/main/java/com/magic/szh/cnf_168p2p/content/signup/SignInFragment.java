package com.magic.szh.cnf_168p2p.content.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.MagicFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.signup
 * file: SignInFragment
 * author: admin
 * date: 2018/2/22
 * description: 登录
 */

public class SignInFragment extends MagicFragment {
    @BindView(R.id.edit_sign_in_email)
    TextInputEditText mEmail;
    @BindView(R.id.edit_sign_in_password)
    TextInputEditText mPassword;
    @OnClick(R.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {

        }
    }
    @OnClick(R.id.icon_sign_in_wechat)
    void onClickWechat() {

    }
    @OnClick(R.id.text_view_link_sign_up)
    void onClickLink() {
        start(new SignUpFragment());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
}
