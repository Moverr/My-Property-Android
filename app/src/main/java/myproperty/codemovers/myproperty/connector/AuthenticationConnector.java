package myproperty.codemovers.myproperty.connector;

/**
 * Created by Manny on 9/2/2017.
 */

public class AuthenticationConnector extends ConnectorBase {
    private static AuthenticationConnector instance;


    public static AuthenticationConnector getInstance(){
        if(instance == null){
            instance = new AuthenticationConnector();
        }
        return  instance;
    }

    public AuthenticationConnector() {
        instance = getInstance();
    }

    //TODO: Submit Data
    public boolean submitData(String username, String password){

        return  true;
    }



}
