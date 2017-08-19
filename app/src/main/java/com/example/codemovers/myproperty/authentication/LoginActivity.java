package com.example.codemovers.myproperty.authentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.codemovers.myproperty.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends AppCompatActivity {

    LoginButton loginButton;
    CallbackManager callbackManager;
    Context context = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Facebook login button
        loginButton = (LoginButton) findViewById(R.id.faacebooklogin_button);
        loginButton.setReadPermissions("email");


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                Toast toast = Toast.makeText(context,loginResult.getRecentlyGrantedPermissions().toString(),Toast.LENGTH_LONG);
//                toast.show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        setContentView(R.layout.login_screen);


    }

    @Override
    protected  void onPause(){
        super.onPause();
    }

    @Override
    protected  void onResume(){
        super.onResume();
    }


}
