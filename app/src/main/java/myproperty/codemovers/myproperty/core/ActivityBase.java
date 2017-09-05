package myproperty.codemovers.myproperty.core;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

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

    public boolean SideBarMenuHandler(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            default:
                break;
        }
        return true;
    }

    public boolean ActionBarMenuHandler(MenuItem item) {
        int id = item.getItemId();
        switch (id){

            default:
                break;
        }
        return true;
    }


}
