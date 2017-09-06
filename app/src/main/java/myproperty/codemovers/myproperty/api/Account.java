package myproperty.codemovers.myproperty.api;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Mover on 9/6/2017.
 */

public class Account  extends  EngineCaller{
    public void loginAccount(Context context, String Username, String Password){
            doPost(context,Password,Username);
    }

    @Override
    public String SuccessResponse(String Response) {
        return Response;
    }
}
