package com.wonderguerrilla.android.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public abstract class SingleFragmentActivity extends ActionBarActivity {

    protected abstract Fragment newFragment() ;

    protected void setTitle() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setTitle() ;

        FragmentManager fragmentManager = getSupportFragmentManager() ;
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer) ;

        if (fragment == null) {
            fragment = newFragment() ;
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, fragment).commit() ;
        }

    }

}
