package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExercise implements Exercise {

    private String mName ;
    int mDuration ;

    public StaticCoreExercise(String name, int duration) {
        mName = name ;
        mDuration = duration ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_core_exercise ;
    }

    @Override
    public void fillLayout(View v) {

        TextView name = (TextView)v.findViewById(R.id.core_exercise_name) ;
        TextView duration = (TextView)v.findViewById(R.id.core_exercise_duration) ;

        name.setText(mName) ;
        duration.setText(mDuration + " Seconds") ;

    }
}
