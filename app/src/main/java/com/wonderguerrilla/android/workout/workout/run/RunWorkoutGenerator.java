package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.Workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */
public class RunWorkoutGenerator  {

    private RunWorkoutInfo mInfo ;

    private ArrayList<String> mOrder ;

    public RunWorkoutGenerator(RunWorkoutInfo info) {
        mInfo = info ;
        mOrder = info.getStorage().getOrder() ;
    }

    public Workout generate() {
        return new Workout(mInfo.getName(), mInfo) ;
    }

}
