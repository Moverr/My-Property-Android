package myproperty.codemovers.myproperty.core.util;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.Date;

import butterknife.internal.Utils;

/**
 * Created by Mover on 9/17/2017.
 */

public class Utilities {


    private static Integer OFFSET = 0;
    private static Integer LIMIT = 10;

    private static String DISPLAY_TIME = "yyyy-MM-dd HH:mm:ss";


    public static Date convertTimeFromMilli(Integer milliseconds) {
        Date date = new Date(milliseconds);
        return date;

    }

    public static Boolean CheckEmailCheckEmail(String email_address) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email_address.matches(emailPattern)) {
            return true;
        }
        return false;
    }

    public static Integer getOFFSET() {
        return OFFSET;
    }

    public static void setOFFSET(Integer OFFSET) {
        Utilities.OFFSET = OFFSET;
    }

    public static Integer getLIMIT() {
        return LIMIT;
    }

    public static void setLIMIT(Integer LIMIT) {
        Utilities.LIMIT = LIMIT;
    }
}
