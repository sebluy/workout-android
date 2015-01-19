package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.BasketballWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

/**
 * Created by sebluy on 1/19/15.
 */
public class BasketballWorkoutFragmentUI extends WorkoutFragmentUI {

    private BasketballWorkout mWorkout ;

    public BasketballWorkoutFragmentUI(Workout workout) {
        super(workout) ;
        mWorkout = (BasketballWorkout)workout ;
    }

    public int getLayout() {
        return R.layout.fragment_basketball_workout ;
    }

    public void fillLayout(View view) {
        super.fillLayout(view) ;
        TextView duration = (TextView)view.findViewById(R.id.duration) ;
        duration.setText(mWorkout.getDuration() + " Minutes") ;
    }
}
