package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;

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
