package com.example.codemovers.myproperty;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


public class SplashActivity extends AppCompatActivity {

    long m_dwSplashTime = 3000;
    boolean m_bpaused = false;
    boolean  m_bSplashActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Thread splashTimer = new Thread(){
            public void  Run(){
                try{
                    //todo: wait loop
                    long ms = 0;
                    while (m_bSplashActive && ms < m_dwSplashTime){
                        sleep(100);
                        if(!m_bpaused){
                            ms += 100;
                        }
                    }

                }catch (Exception em){
                    Log.e("Splash",em.toString());
                }finally {
                    finish();
                }
            }
        };
        splashTimer.start();

    }

}
