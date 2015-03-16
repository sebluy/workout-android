package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;

public class StretchActivity extends SingleFragmentActivity {


    @Override
    public Fragment newFragment() {
        return new StretchFragment() ;
    }

    @Override
    public void setTitle() {
        setTitle("Stretch") ;
    }

}
