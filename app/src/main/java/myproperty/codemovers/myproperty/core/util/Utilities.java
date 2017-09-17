package myproperty.codemovers.myproperty.core.util;

import android.support.annotation.NonNull;
import android.widget.Toast;

/**
 * Created by Manny on 9/17/2017.
 */

public class Utilities {


    public static Boolean CheckEmailCheckEmail(String email_address){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email_address.matches(emailPattern) ){
           return true;
        }
        return false;
    }

}
