package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import workout.BasketballWorkout;

/**
 * Created by sebluy on 1/19/15.
 */
public class BasketballWorkoutFragment extends WorkoutFragment {

    private BasketballWorkout mWorkout ;

    public int getLayout() {
        return R.layout.fragment_basketball_workout ;
    }

    public void fillLayout(View view) {
        super.fillLayout(view) ;
        TextView duration = (TextView)view.findViewById(R.id.duration) ;
        duration.setText(mWorkout.getDuration() + " Minutes") ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        mWorkout = (BasketballWorkout)WorkoutHolder.getCurrent() ;
    }

}
