package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class RunWorkout extends Workout {

    private ArrayList<String> mOrder ;

    public RunWorkout(WorkoutController info, ArrayList<String> order) {
        super(RunWorkoutController.NAME, info) ;
        mOrder = order ;
    }

    public ArrayList<String> getOrder() {
        return mOrder ;
    }
}
