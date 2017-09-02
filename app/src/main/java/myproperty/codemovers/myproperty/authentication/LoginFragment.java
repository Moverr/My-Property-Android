package myproperty.codemovers.myproperty.authentication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.commons.FragmentBase;
import myproperty.codemovers.myproperty.connector.AuthenticationConnector;

/**
 * Created by Manny on 8/29/2017.
 */

public class LoginFragment extends FragmentBase {

    private static LoginFragment instance = null;
    Button login_button, register_button;

    SignupFragment signupFragment;

   EditText username, password;

    Dialog dialog;

    AuthenticationConnector authenticationConnector;

    public static LoginFragment getInstance(){
        if(instance == null){
            instance = new LoginFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_screen,container,false);

        signupFragment = new SignupFragment();

        login_button = (Button) view.findViewById(R.id.login_button);
        register_button = (Button) view.findViewById(R.id.register_button);

        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);



        login_button.setOnClickListener(new View.OnClickListener() {
            //TODO: handle login process
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });



        return view;

    }
    //TODO: handle Login
    public void handleLogin(){
        authenticationConnector = AuthenticationConnector.getInstance();
        String _username = username.getText().toString();
        String _password = password.getText().toString();

        if(_username.isEmpty() || _password.isEmpty()  ){
            Toast.makeText(getContext(), "Fill Blanks ", Toast.LENGTH_LONG).show();
        }else
        {
            authenticationConnector.submitData(getContext(),_username,_password);
        }

      //  username =
    }




}
