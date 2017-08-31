package com.example.lenovo.android61;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by lenovo on 8/31/2017.
 */


//MockitoJUnitRunner gives you automatic validation of framework usage
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock  // Mocking objects
    private LoginView view;
    @Mock
    private LoginService service;

    private LoginPresenter presenter;

    //Here test class invokes this code block before each test.
    @Before
    public void setUp() throws Exception{
        //Creating object
        presenter=new LoginPresenter(view,service);
    }

    // Here Test is used to mark test method
    @Test//Here it will check that username is empty or not .
    public void usernameEmpty() throws Exception {
        when(view.getUsername()).thenReturn("");
        //here we are calling onLoginClicked
        presenter.onLoginClicked();
        //here we Verifying the method on a mock
        verify(view).showUsernameError(R.string.userNameError);
    }

    @Test //here it will check that password is empty or not .
    public void passwordEmpty() throws Exception {
        when(view.getUsername()).thenReturn("Nitish");
        when(view.getPassword()).thenReturn("");
        //here we are calling onLoginClicked
        presenter.onLoginClicked();
        //here we are Verifying the method on a mock
        verify(view).showPasswordError(R.string.passwordError);

    }

    @Test //here we are ceating startSecondActivity Method
    //it will check the username and password is correct or not
    public void startSecondActivity() throws Exception {
        // Creating when method to check username and password is valid
        when(view.getUsername()).thenReturn("Nitish");
        when(view.getPassword()).thenReturn("123");
        when(service.login("Nitish","123")).thenReturn(true);
        //here we are calling onLoginClicked
        presenter.onLoginClicked();
        //here we are Verifying the method on a mock
        verify(view).startSecondActivity();
    }

    @Test //here we are creating method logInError
    // for check when LogIn failed  .
    public void logInError() throws Exception {
        when(view.getPassword()).thenReturn("123");
        when(service.login("Nitish","123")).thenReturn(false);
        //here we are calling onLoginClicked
        presenter.onLoginClicked();
        //here we are Verifying the method on a mock
        verify(view).showLoginError(R.string.logInError);

    }
}

