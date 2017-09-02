package myproperty.codemovers.myproperty.connector;

import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import myproperty.codemovers.myproperty.caller.EngineCaller;

/**
 * Created by Manny on 9/2/2017.
 */

public class AuthenticationConnector extends  ConnectorBase   {
    private static AuthenticationConnector instance;

    String   accountLoginEndpoint  = "account/login";


    EngineCaller caller ;

    public static AuthenticationConnector getInstance(){
        if(instance == null){
            instance = new AuthenticationConnector();
        }
        return  instance;
    }

    public AuthenticationConnector() {

    }



    //TODO: Submit Data
    public boolean submitData(Context context,String username, String password){

        if(!username.isEmpty() && !password.isEmpty()){
            //Todo: send message to the server

            String url = caller.getUrl(accountLoginEndpoint);

            Map headers = new HashMap();
            headers.put("Content-Type","application/json");

            Map params = new HashMap();
            params.put("username",username);
            params.put("password",password);

            //TODO: Missing functionality is adding a callback, and failer response
            caller = new EngineCaller();
            caller.doPost(context,url,headers,params);




            return true;
        }else
            Toast.makeText(context, "Fill in Blanks", Toast.LENGTH_SHORT).show();
        return  true;
    }


    @Override
    public void handleFailure(Context context){

    }

    @Override
    public void handleSuccess(Context context){

    }





}
