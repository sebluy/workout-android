package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExercise extends Exercise {

    int mDuration ;

    public StaticCoreExercise(String name, int duration) {
        super(name) ;
        mDuration = duration ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_core_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view); ;

        TextView duration = (TextView)view.findViewById(R.id.core_exercise_duration) ;
        duration.setText(mDuration + " Seconds") ;
    }
}
