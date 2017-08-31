package com.example.lenovo.android61;

/**
 * Created by lenovo on 8/31/2017.
 */

class LoginPresenter {
    // Creating objects
    private LoginView view;
    private LoginService service;

    public LoginPresenter(LoginView view, LoginService service) { //Creates constructor
        this.view = view;
        this.service = service;
    }
    //onLoginClick Method
    public void onLoginClicked() {
        //geeting username
        String username = view.getUsername();
        //Applying Condition
        // if username is empty
        if (username.isEmpty()) {
            view.showUsernameError(R.string.userNameError); //Error message
            return;
        }
        //Getting Password
        String password = view.getPassword();
        //Applying Condition
        // if password is empty
        if (password.isEmpty()) {
            view.showPasswordError(R.string.passwordError); //Error message
            return;
        }
        boolean loginSucceeded = service.login(username, password);
        //Applying Condition
        // if LogIn is successful
        if (loginSucceeded) {
            view.startSecondActivity(); // View Second activity
            return;
        }
        view.showLoginError(R.string.logInError); //LogIn error message
    }
}

