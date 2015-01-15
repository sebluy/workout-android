package com.wonderguerrilla.android.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;

public abstract class SingleFragmentActivity extends ActionBarActivity {

    private Fragment mFragment ;

    protected abstract Fragment newFragment() ;

    protected Fragment getFragment() {
        return mFragment ;
    }
    protected void initialize() {}

    protected void setTitle() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(R.layout.activity_fragment);
        setTitle() ;

        FragmentManager fragmentManager = getSupportFragmentManager() ;
        mFragment = fragmentManager.findFragmentById(R.id.fragmentContainer) ;

        if (mFragment == null) {
            mFragment = newFragment() ;
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, mFragment).commit() ;
        }

    }

}
