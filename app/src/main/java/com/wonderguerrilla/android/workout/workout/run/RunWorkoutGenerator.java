package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.Workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */
public class RunWorkoutGenerator  {

    private RunWorkoutController mInfo ;

    private ArrayList<String> mOrder ;

    public RunWorkoutGenerator(RunWorkoutController info) {
        mInfo = info ;
        mOrder = info.getStorage().getOrder() ;
    }

    public Workout generate() {
        return new RunWorkout(mInfo, mOrder) ;
    }

}
