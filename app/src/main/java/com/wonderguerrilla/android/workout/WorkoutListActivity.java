package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class WorkoutListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setTitle("Workouts") ;

        FragmentManager fm = getSupportFragmentManager() ;
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer) ;

        if (fragment == null) {
            fragment = new WorkoutListFragment() ;
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit() ;
        }

    }

}
