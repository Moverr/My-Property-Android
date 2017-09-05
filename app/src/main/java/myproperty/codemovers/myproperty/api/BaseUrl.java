package myproperty.codemovers.myproperty.api;

/**
 * Created by Manny on 9/5/2017.
 */

public class BaseUrl {
    private static final String PROTOCOL_HTTPS = "https://";
    private static final String PROTOCOL_HTTP = "http://";
    private static final String API_HOST  = "localhost";
    private static final String API_ENDPOINT = "v1";
    private static final String PORT = "8080";

    public String getName(){
        return "myproperty";
    }

}
