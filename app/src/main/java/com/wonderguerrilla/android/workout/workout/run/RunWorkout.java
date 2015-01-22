package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutInfo;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class RunWorkout extends Workout {

    private ArrayList<String> mOrder ;

    public RunWorkout(WorkoutInfo info, ArrayList<String> order) {
        super(RunWorkoutInfo.NAME, info) ;
        mOrder = order ;
    }

    public ArrayList<String> getOrder() {
        return mOrder ;
    }
}
