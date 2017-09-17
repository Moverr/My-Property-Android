package myproperty.codemovers.myproperty.api.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by mover on 8/31/2017.
 */

public class VolleyService {


    private static String url;
    Cache cache ;
    Network network ;
    RequestQueue mRequestQueue ;
    String successResponse;
    private static VolleyService instance;

    Context mContext;
    IResult mResultCallback = null;

    public VolleyService(Context mContext, IResult mResultCallback) {
        this.mContext = mContext;
        this.mResultCallback = mResultCallback;
        cache = new DiskBasedCache(mContext.getCacheDir(),1024*1924);
      //  network = new BasicNetwork(new HurlStack());
    }

    public  static VolleyService getInstance(Context context,IResult mResultCallback){
        if(instance == null)
        {
            instance = new VolleyService(context, mResultCallback);
        }
        return  instance;
    }


    public VolleyService(){
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
        url =  BaseUrl.getProtocolHttp().concat(BaseUrl.getApiHost()).concat(":").concat(BaseUrl.getPORT()).concat("/").concat(endPoint);
        return url;
    }


    //TODO: do Post
    public   String  doPost(final Context context, String url, final Map headers, final JSONObject body){
        Toast.makeText(context, "  MARAGA ", Toast.LENGTH_SHORT).show();
        String response = null;
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "  Success", Toast.LENGTH_SHORT).show();
                mResultCallback.notifySuccess("success",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mResultCallback.notifyError("ERROR",error);
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
        return response;
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

