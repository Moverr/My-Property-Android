package myproperty.codemovers.myproperty.api.services;

/**
 * Created by Manny on 9/5/2017.
 */

public class BaseUrl {
    private static final String PROTOCOL_HTTPS = "https://";
    private static final String PROTOCOL_HTTP = "http://";
    private static final String API_HOST  = "10.0.2.2";
    private static final String API_ENDPOINT = "v1";
    private static final String PORT = "8080";

    public static String getProtocolHttps() {
        return PROTOCOL_HTTPS;
    }

    public static String getProtocolHttp() {
        return PROTOCOL_HTTP;
    }

    public static String getApiHost() {
        return API_HOST;
    }

    public static String getApiEndpoint() {
        return API_ENDPOINT;
    }

    public static String getPORT() {
        return PORT;
    }

    public String getName(){
        return "myproperty";
    }

}
