package com.stoyaniviv.wearematchplay.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.stoyaniviv.wearematchplay.R;
import com.stoyaniviv.wearematchplay.model.LoginDetails;
import com.stoyaniviv.wearematchplay.viewmodel.LoginActivityViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.edt_username)
    EditText edtUserName;
    @BindView(R.id.edt_password)
    EditText edtPassword;

    private LoginActivityViewModel viewModel;
    private boolean nextActivityStarted = false;

    @OnClick(R.id.btn_sign_in)
    void onSignInClicked() {
        String username = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();

        viewModel.loginUser(new LoginDetails(username, password));
        viewModel.getAccessToken().observe(this, apiToken -> {
            if(apiToken != null && !nextActivityStarted) {
                nextActivityStarted = true;
                startActivity(MatchesActivity.getIntent(this, apiToken));
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel.class);

        // HardCoded
        edtUserName.setText("ioscase");
        edtPassword.setText("iOSCase");
    }

    @Override
    protected void onResume() {
        super.onResume();
        nextActivityStarted = false;
    }

}
