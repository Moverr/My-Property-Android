package myproperty.codemovers.myproperty.api.services;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by Manny on 9/7/2017.
 */

public interface IResult {
    public void notifySuccess(String requestType,String response);
    public void notifyError(String requestType,VolleyError error);
}
