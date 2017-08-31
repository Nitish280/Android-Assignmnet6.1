package com.example.lenovo.android61;

/**
 * Created by lenovo on 8/31/2017.
 */

interface LoginView {
    String getUsername();

    String getPassword();

    void startSecondActivity();

    void showUsernameError(int resId);

    void showPasswordError(int resId);

    void showLoginError(int resId);
}
