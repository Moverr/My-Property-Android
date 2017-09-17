package myproperty.codemovers.myproperty.authentication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.api.services.IResult;
import myproperty.codemovers.myproperty.connector.AuthenticationConnector;
import myproperty.codemovers.myproperty.core.BaseFragment;

import myproperty.codemovers.myproperty.core.util.Utilities;
import myproperty.codemovers.myproperty.entitity._account;
import myproperty.codemovers.myproperty.core.util.Utilities.*;


/**
 * Created by Manny on 8/29/2017.
 */

public class SignupFragment  extends BaseFragment {

    private static SignupFragment instance = null;


    EditText names,email_address,password,repassword;
    Button register;

    IResult mResultCallback  = null;
    AuthenticationConnector authenticationConnector;

    public static SignupFragment getInstance(){
        if(instance == null){
            instance = new SignupFragment();
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
        View view = inflater.inflate(R.layout.signup_screen,container,false);

        names = (EditText) view.findViewById(R.id.names);
        email_address = (EditText) view.findViewById(R.id.email_address);
        password = (EditText) view.findViewById(R.id.password);
        repassword = (EditText) view.findViewById(R.id.repassword);
        register = (Button) view.findViewById(R.id.register);

        initVoleyCallback();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });

        return view;

    }

    // plates are done
    private String NAMES;
    private String EMAIL_ADDRESS;
    private String PASSWORD;
    private String RE_PASSWORD;

    private void handleRegister() {
        Toast.makeText(getContext(), "Handler Registration ", Toast.LENGTH_SHORT).show();

        NAMES = names.getText().toString();
        EMAIL_ADDRESS = email_address.getText().toString();
        PASSWORD = password.getText().toString();
        RE_PASSWORD = repassword.getText().toString();

        //todo: check to see that there is not empty


        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(NAMES.length() <= 0 ||  EMAIL_ADDRESS.length() <= 0 || PASSWORD.length() <= 0 || RE_PASSWORD.length() <= 0 ){
            Toast.makeText(getContext(), "Fill Blanks", Toast.LENGTH_SHORT).show();
        }
        else if (!Utilities.CheckEmailCheckEmail(emailPattern) ){
            Toast.makeText(getContext(), "Invalid Email Address ", Toast.LENGTH_SHORT).show();
        }
        else{
            try {


                _account account = new _account();
               // account.setEmail_address(EMAIL_ADDRESS);
                //account.setNames(NAMES);
                //account.setPassword(PASSWORD);

                Toast.makeText(getContext(), " Testing the Send of ", Toast.LENGTH_SHORT).show();
                //  authenticationConnector.submitRegistration(getContext(),account,mResultCallback);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getContext(), e.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
            }

        }

    }

    private void initVoleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, String response) {
                Toast.makeText(getContext(), "Success Response on Wall ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                Toast.makeText(getContext(), "An Error Was Encountered ", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
