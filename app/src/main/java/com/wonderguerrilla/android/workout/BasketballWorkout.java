package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

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

    public int getLayout() {
        return R.layout.fragment_basketball_workout ;
    }

    public void fillLayout(View view) {
        super.fillLayout(view) ;
        TextView duration = (TextView)view.findViewById(R.id.duration) ;
        duration.setText(mDuration + " Minutes") ;
    }

}
