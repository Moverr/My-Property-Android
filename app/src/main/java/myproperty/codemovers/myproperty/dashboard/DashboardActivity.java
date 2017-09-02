package myproperty.codemovers.myproperty.dashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import myproperty.codemovers.myproperty.R;
import myproperty.codemovers.myproperty.authentication.LoginFragment;
import myproperty.codemovers.myproperty.authentication.SignupFragment;
import myproperty.codemovers.myproperty.commons.ActivityBase;

/**
 * Created by Manny on 8/26/2017.
 */

public class DashboardActivity  extends ActivityBase{
    public static final String TAG = "Dashboard Main Activity ";

    AllCollectionsFragment allCollectionsFragment;
    LoginFragment loginFragment;
    SignupFragment signupFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#FF64FFB7"));
        toolbar.setTitle("MY PROPERTY ");

        // Set On Click Handles to the Menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){
            @Override
            public boolean onMenuItemClick(MenuItem item) {
               return ActionBarMenuHandler(item);
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return SideBarMenuHandler(item);
            }
        });


        if (savedInstanceState == null) {
             allCollectionsFragment = AllCollectionsFragment.getInstance();
            replaceFragment(allCollectionsFragment);
        }
    }


    @Override
    public boolean SideBarMenuHandler(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.home:
                allCollectionsFragment = AllCollectionsFragment.getInstance();
                replaceFragment(allCollectionsFragment);
                break;
            case R.id.nav_gallery:
                break;
            case R.id.nav_slideshow:
                break;
            case R.id.nav_manage:
                break;
            case R.id.user_login:
                loginFragment =  LoginFragment.getInstance();
                replaceFragment(loginFragment);
                break;
            case R.id.user_signup:
                signupFragment =  SignupFragment.getInstance();
                replaceFragment(signupFragment);
                break;
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.sample_content_fragment,fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }



}
