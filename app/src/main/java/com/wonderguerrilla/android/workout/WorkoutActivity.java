package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;

public class WorkoutActivity extends SingleFragmentActivity {

    @Override
    protected void setTitle() {
        setTitle(WorkoutHolder.get().getName()) ;
    }

    @Override
    protected Fragment newFragment() {
        return new WorkoutFragment() ;
    }

}
