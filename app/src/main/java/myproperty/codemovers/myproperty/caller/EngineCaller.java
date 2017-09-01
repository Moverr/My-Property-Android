package myproperty.codemovers.myproperty.caller;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Manny on 8/31/2017.
 */

public class EngineCaller {
    private static final int PORT = 8080;
    private static final String HOST = "http:localhost:"+PORT+"/";
    private Context context;
    private String endPoint;
    private String url;

    // Instantiate the cache
    Cache cache ;
    // Set up the network to use HttpURLConnection as the HTTP client.
    Network network ;
    // Instantiate the RequestQueue with the cache and network.
    RequestQueue mRequestQueue ;

    EngineCaller instance;
    public EngineCaller getInstance(){
        if(instance == null) {
            instance = new EngineCaller();
        }
        return instance;
    }



    public EngineCaller() {
        cache = new DiskBasedCache(context.getCacheDir(),1024*1924);
        network = new BasicNetwork(new HurlStack());
    }

    public RequestQueue getmRequestQueue() {
        if(mRequestQueue == null){
            mRequestQueue = new RequestQueue(cache,network);
        }
        return  mRequestQueue;
    }



    public void startQue(){
        mRequestQueue.start();
    }
    public void stopQue(){
        mRequestQueue.stop();
    }


    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    //get URL ::
    public String getUrl() {
        url = this.HOST.concat("/").concat(endPoint);
        return url;
    }

    // do Get
    public String doGet(){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // do something
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // do something
            }
        });
        // andd this to the que::
        getmRequestQueue().add(stringRequest);

        return "";
    }




}
