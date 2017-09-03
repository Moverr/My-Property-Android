package myproperty.codemovers.myproperty.caller;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mover on 8/31/2017.
 */

public class EngineCaller {
    private static final int PORT = 8080;
    //private static final String HOST = "http:localhost:"+PORT+"";
    //private static final String HOST = "10.0.2.2:"+PORT+"";
    private static final String HOST = "http://10.0.2.2:"+PORT+"";
    //private static final String HOST = "https://www.google.com/";



    private Context context;

    private static String url;

    // Instantiate the cache
    Cache cache ;
    // Set up the network to use HttpURLConnection as the HTTP client.
    Network network ;
    // Instantiate the RequestQueue with the cache and network.
    RequestQueue mRequestQueue ;




    public EngineCaller(Context context) {
        try{
            cache = new DiskBasedCache(context.getCacheDir(),1024*1924);
             network = new BasicNetwork(new HurlStack());
        }catch (Exception em){
            Toast.makeText(context, em.getMessage(), Toast.LENGTH_SHORT).show();

        }

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



    //get URL ::
    public  static String getUrl(String endPoint) {
        url = HOST.concat("/").concat(endPoint);
        return url;
    }

    //TODO: do Post
    public static void doPost(final Context context, String url, final Map headers, final JSONObject body){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "  Success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                Toast.makeText(context, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            public byte[] getBody() throws AuthFailureError {

                try {
                    String mRequestBody = body.toString();
                    return mRequestBody.toString().getBytes("utf-8");
                }
                catch (Exception e){
                    return null;
                }
            }

            @Override
            public String getBodyContentType() {
                return "application/json;";
            }


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return  headers;
            }
        };
        queue.add(stringRequest);
    }

    //TODO: do Get
    public static void doGet(Context context, String url, final Map headers){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        queue.add(stringRequest);
    }

    //TODO: do PUT
    public static void doPut(Context context, String url, final Map headers){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        queue.add(stringRequest);
    }

    //TODO: do DELETE
    public static void doDelete(Context context, String url, final Map headers){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        queue.add(stringRequest);
    }







}

