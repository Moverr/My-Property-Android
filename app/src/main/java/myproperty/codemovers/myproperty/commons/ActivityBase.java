package myproperty.codemovers.myproperty.commons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Manny on 8/26/2017.
 */

public class ActivityBase extends FragmentActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void initializeLogging(){

    }
}
