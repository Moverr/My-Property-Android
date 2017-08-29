package myproperty.codemovers.myproperty.commons;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import myproperty.codemovers.myproperty.R;

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
