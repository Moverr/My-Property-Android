package myproperty.codemovers.myproperty.connector;

import android.content.Context;

/**
 * Created by Manny on 9/2/2017.
 */

public  abstract    class ConnectorBase {
    private static ConnectorBase instance;
    public abstract void handleFailure(Context context);
    public abstract void handleSuccess(Context context);




}
