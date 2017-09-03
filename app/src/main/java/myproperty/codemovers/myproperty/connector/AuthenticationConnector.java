package myproperty.codemovers.myproperty.connector;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;

import org.json.JSONObject;

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
    public boolean submitData(Context context,String username, String password) throws  Exception{

        if(!username.isEmpty() && !password.isEmpty()){
            //Todo: send message to the server

            String url = caller.getUrl(accountLoginEndpoint);



                // Add Headers
                Map headers = new HashMap();
                headers.put("Content-Type", "application/json");

                // Add Params
                Map params = new HashMap();
                params.put("username", username);
                params.put("password", password);

                //TODO: add jsob object object
                JSONObject body = new JSONObject();
                body.put("username",username);
                body.put("password",password);


//            jsonBody.put("username", "firstvalue");
//            jsonBody.put("password", "secondobject");




            //TODO: Missing functionality is adding a callback, and failer response



            // Instantiate the cache

            // Instantiate the RequestQueue with the cache and network.
          //  RequestQueue mRequestQueue ;

           caller = new EngineCaller(context);
            caller.doPost(context,url,headers,body);




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
