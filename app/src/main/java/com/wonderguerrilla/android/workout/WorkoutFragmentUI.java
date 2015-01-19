package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.BasketballWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

/**
 * Created by sebluy on 1/19/15.
 */
public class WorkoutFragmentUI {

    public static WorkoutFragmentUI get(Workout workout) {
        if (workout.getClass() == BasketballWorkout.class) {
            return new BasketballWorkoutFragmentUI(workout) ;
        } else {
            return new WorkoutFragmentUI(workout) ;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Workout mWorkout ;

    public WorkoutFragmentUI(Workout workout) {
        mWorkout = workout ;
    }

    public Workout getWorkout() {
        return mWorkout ;
    }

    public int getLayout() {
        return R.layout.fragment_workout ;
    }

    public void fillLayout(View view) {
        TextView title = (TextView)view.findViewById(R.id.name) ;
        title.setText(mWorkout.getName()) ;
    }
}
