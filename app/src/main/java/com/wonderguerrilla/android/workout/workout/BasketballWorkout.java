package com.wonderguerrilla.android.workout.workout;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;

/**
 * Created by sebluy on 12/25/14.
 */

public class BasketballWorkout extends Workout {

    public static final String NAME = "Basketball" ;

    private int mDuration ;

    public BasketballWorkout(int duration) {
        super(NAME) ;
        mDuration = duration ;
    }

    public int getDuration() {
        return mDuration;
    }



}
