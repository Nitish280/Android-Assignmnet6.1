package com.example.lenovo.android61;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {

    // declaration
    EditText username;
    EditText password;
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting up UI component
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        loginPresenter = new LoginPresenter(this, new LoginService());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull  Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
    public void  onLoginClicked(View view) {
        loginPresenter.onLoginClicked();
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void startSecondActivity() {
        new ActivityUtil(this).startSecondActivity();
}

    @Override
    public void showUsernameError(int resId) {
        username.setError(getString(resId));

    }

    @Override
    public void showPasswordError(int resId) {
        password.setError(getString(resId));

    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(getApplicationContext(),getString(resId),Toast.LENGTH_LONG).show();

    }
}
