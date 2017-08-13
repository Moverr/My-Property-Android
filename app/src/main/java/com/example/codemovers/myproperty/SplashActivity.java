package com.example.codemovers.myproperty;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.example.codemovers.myproperty.authentication.LoginActivity;
import com.example.codemovers.myproperty.authentication.helper.Logger;


public class SplashActivity extends AppCompatActivity {

    long m_dwSplashTime = 3000;
    boolean m_bpaused = false;
    boolean  m_bSplashActive = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        Thread splashTimer = new Thread(){
            public void  run(){
                try{
                    Logger.system_log("SPLASH","INSIDE THE RUN METHOD");
                    //todo: wait loop
                    long ms = 0;
                    while (m_bSplashActive && ms < m_dwSplashTime){
                        sleep(100);
                        if(!m_bpaused){
                            ms += 100;
                        }
                    }

                    //TODO: Get me to the Next Activity
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                //    startActivity(intent);

                }catch (Exception em){
                    Logger.system_log("SPLASH EXCEPTION",em.toString());
                }finally {
                  // finish();
                }
            }
        };
        splashTimer.start();

    }

    @Override
    protected  void onPause(){
        super.onPause();
        m_bpaused = true;
    }

    @Override
    protected  void onResume(){
        super.onResume();;
        m_bpaused = false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
         super.onKeyDown(keyCode, event);
        m_bSplashActive = false;
        return  true;
    }
}
