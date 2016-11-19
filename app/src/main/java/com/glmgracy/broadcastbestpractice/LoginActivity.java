package com.glmgracy.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by glmgr on 2016/11/19.
 */

public class LoginActivity extends BaseActivity {
    private Button btnLogin;
    private EditText etAccount;
    private EditText etPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etAccount = (EditText) findViewById(R.id.tvAccount);
        etPassword = (EditText) findViewById(R.id.tvPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if("admin".equals(etAccount.getText().toString()) && "123456".equals(etPassword.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "account or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
