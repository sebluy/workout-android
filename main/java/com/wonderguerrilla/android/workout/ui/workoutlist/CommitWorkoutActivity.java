package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;
import workout.Workout;

public class CommitWorkoutActivity extends SingleFragmentActivity {

    private Workout mWorkout ;

    @Override
    public Fragment newFragment() {
        return CommitWorkoutFragment.get(mWorkout) ;
    }

    @Override
    public void setTitle() {
        setTitle("Commit " + mWorkout.getName()) ;
    }

    @Override
    protected void initialize() {
        mWorkout = WorkoutHolder.getCurrent() ;
    }

}
