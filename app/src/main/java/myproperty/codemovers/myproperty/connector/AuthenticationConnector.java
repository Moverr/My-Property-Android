package myproperty.codemovers.myproperty.connector;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import myproperty.codemovers.myproperty.api.services.VolleyService;

/**
 * Created by Manny on 9/2/2017.
 */

public class AuthenticationConnector extends  ConnectorBase   {
    private static AuthenticationConnector instance;

    String   accountLoginEndpoint  = "account/login";


    VolleyService caller ;

    public static AuthenticationConnector getInstance(){
        if(instance == null){
            instance = new AuthenticationConnector();
        }
        return  instance;
    }

    public AuthenticationConnector() {

    }

    Map HEADERS = new HashMap();
    Map PARAMS = new HashMap();
    JSONObject BODY = new JSONObject();

    //TODO: Submit Data
    public String submitData(Context context,String username, String password) throws  Exception{

        if(!username.isEmpty() && !password.isEmpty()){
            //Todo: send message to the server
               String url = caller.getUrl(accountLoginEndpoint);

                // Add Headers
                HEADERS.put("Content-Type", "application/json");

                // Add Parameters
                PARAMS.put("username", username);
                PARAMS.put("password", password);

                //TODO: add jsob object object
                BODY.put("username",username);
                BODY.put("password",password);


            //TODO: Missing functionality is adding a callback, and failer response

         //   caller = new VolleyService(context);
          return   caller.doPost(context,url,HEADERS,BODY);



        }else
            Toast.makeText(context, "Fill in Blanks", Toast.LENGTH_SHORT).show();
       return null;
    }


    @Override
    public void handleFailure(Context context){

    }

    @Override
    public void handleSuccess(Context context){

    }





}
