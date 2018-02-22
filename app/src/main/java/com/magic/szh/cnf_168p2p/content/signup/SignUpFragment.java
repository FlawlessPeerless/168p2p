package com.magic.szh.cnf_168p2p.content.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.magic.szh.cnf_168p2p.R;
import com.magic.szh.cnf_168p2p.base.MagicFragment;
import com.magic.szh.net.RestClient;
import com.magic.szh.net.callback.ISuccess;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * project: CNF_168p2p
 * package: com.magic.szh.cnf_168p2p.content.signup
 * file: SignUpFragment
 * author: admin
 * date: 2018/2/22
 * description: 注册
 */

public class SignUpFragment extends MagicFragment {
    @BindView(R.id.edit_sign_up_name)
    TextInputEditText mName;
    @BindView(R.id.edit_sign_up_email)
    TextInputEditText mEmail;
    @BindView(R.id.edit_sign_up_phone)
    TextInputEditText mPhone;
    @BindView(R.id.edit_sign_up_password)
    TextInputEditText mPassword;
    @BindView(R.id.edit_sign_up_re_password)
    TextInputEditText mRePassword;
    @OnClick(R.id.btn_sign_up)
    void onClickSignUp() {
        if (checkForm()) {
//            RestClient.builder()
//                    .url("sign_up")
//                    .params("","")
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//
//                        }
//                    })
//                    .build()
//                    .post();
            Toast.makeText(getContext(), "验证通过",Toast.LENGTH_SHORT).show();
        }
    }
    @OnClick(R.id.text_view_link_sign_in)
    void onClickLink() {
        start(new SignInFragment());
    }

    @Override
    public Object setLayout() {
        return R.layout.fragment_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    private boolean checkForm() {
        final String name = mName.getText().toString();
        final String email = mEmail.getText().toString();
        final String phone = mPhone.getText().toString();
        final String password = mPassword.getText().toString();
        final String rePassword = mRePassword.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mName.setError("请输入姓名");
            isPass = false;
        } else {
            mName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 6 || !(rePassword.equals(password))) {
            mRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            mRePassword.setError(null);
        }

        return isPass;
    }
}
