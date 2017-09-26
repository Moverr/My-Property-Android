package myproperty.codemovers.myproperty.connector;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import myproperty.codemovers.myproperty.api.services.IResult;
import myproperty.codemovers.myproperty.api.services.VolleyService;

/**
 * Created by Manny on 9/26/2017.
 */

public class PropertyConnector  extends  ConnectorBase   {

    private static PropertyConnector instance;

    String   accountLoginEndpoint  = "account/login";
    String getPropertyEndpoint = "property/list";


    VolleyService caller ;

    public static PropertyConnector getInstance(){
        if(instance == null){
            instance = new PropertyConnector();
        }
        return  instance;
    }

    public PropertyConnector() {

    }

    @Override
    public void handleFailure(Context context) {

    }

    @Override
    public void handleSuccess(Context context) {
    }


    Map HEADERS = new HashMap();
    Map PARAMS = new HashMap();
    JSONObject BODY = new JSONObject();

    public String get(Context context,  IResult mResultCallback) {

        // get list of data from localhost:

        try {
            String url = caller.getUrl(getPropertyEndpoint);

            Toast.makeText(context, " TRUST ME", Toast.LENGTH_SHORT).show();
            // Add Headers
            HEADERS.put("Content-Type", "application/json");

            //TODO: Missing functionality is adding a callback, and failer response
            caller = VolleyService.getInstance(context, mResultCallback);

            //   new VolleyService(context,mResultCallback);
            // caller = new VolleyService();
            // caller = new VolleyService();
            Toast.makeText(context, " TRUST ME 2", Toast.LENGTH_SHORT).show();
             caller.doGet(context,url,HEADERS);
          //  return caller.doPost(context, url, HEADERS, BODY);


        }
        catch (Exception e){
            Toast.makeText(context, "ERROR SOME THING ", Toast.LENGTH_SHORT).show();
        }


        return "0";
    }
}
