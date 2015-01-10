package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class WorkoutListActivity extends SingleFragmentActivity {

    @Override
    protected void setTitle() {
        setTitle("Workouts") ;
    }

    @Override
    protected Fragment newFragment() {
        return new WorkoutListFragment() ;
    }

}
