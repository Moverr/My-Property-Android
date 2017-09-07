package myproperty.codemovers.myproperty.authentication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.api.services.IResult;
import myproperty.codemovers.myproperty.api.services.VolleyService;
import myproperty.codemovers.myproperty.core.BaseFragment;
import myproperty.codemovers.myproperty.connector.AuthenticationConnector;
import myproperty.codemovers.myproperty.core.abstracts.EngineCallerAbstract;

/**
 * Created by Manny on 8/29/2017.
 */

public class LoginFragment extends BaseFragment  {

    private static LoginFragment instance = null;


    Button login_button, register_button;

    SignupFragment signupFragment;

   EditText username, password;

    Dialog dialog;

    IResult mResultCallback  = null;

    AuthenticationConnector authenticationConnector;

    VolleyService caller ;
    String   accountLoginEndpoint  = "account/login";

    Map HEADERS = new HashMap();
    Map PARAMS = new HashMap();
    JSONObject BODY = new JSONObject();


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

        initVoleyCallback();

        login_button.setOnClickListener(new View.OnClickListener() {
            //TODO: handle login process
            @Override
            public void onClick(View v)  {
                try {
                    handleLogin();
                }catch (Exception e){

                }
            }
        });


        return view;

    }

    private void initVoleyCallback() {
        mResultCallback = new IResult() {
            @Override
            public void notifySuccess(String requestType, JSONObject response) {
                Toast.makeText(getContext(), "Hello Rogers Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void notifyError(String requestType, VolleyError error) {
                Toast.makeText(getContext(), "Hello Rogers Error", Toast.LENGTH_SHORT).show();
            }
        };
    }

    //TODO: handle Login
    public void handleLogin() throws Exception{
        authenticationConnector = AuthenticationConnector.getInstance();
        String _username = username.getText().toString();
        String _password = password.getText().toString();

        if(_username.isEmpty() || _password.isEmpty()  ){

            Toast.makeText(this.getContext(), "Fill Blanks ", Toast.LENGTH_LONG).show();
            String url = caller.getUrl(accountLoginEndpoint);

            // Add Headers
            HEADERS.put("Content-Type", "application/json");

            // Add Parameters
            PARAMS.put("username", username);
            PARAMS.put("password", password);

            //TODO: add jsob object object
            BODY.put("username",username);
            BODY.put("password",password);

            //   caller = new VolleyService(context);
               caller.doPost(getContext(),url,HEADERS,BODY);

        }else
        {
            Toast.makeText(this.getContext(), "Testing Me Out ", Toast.LENGTH_SHORT).show();
            String response =  authenticationConnector.submitData(getContext(),_username,_password);


            Toast.makeText(this.getContext(), response, Toast.LENGTH_SHORT).show();

        }

    }



}
