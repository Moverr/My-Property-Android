package myproperty.codemovers.myproperty;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


import myproperty.codemovers.myproperty.dashboard.DashboardActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    private static final String TAG =  "SPLASH";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(TAG,"On Create Splash Screen");

        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.v(TAG,"Starting Dashboard Activity");
                        Intent i = new Intent(SplashActivity.this,DashboardActivity.class);
                        startActivity(i);
                        finish();
                    }
                },SPLASH_TIME_OUT);
    }


}
