package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseInfo;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/18/15.
 */
public interface RunWorkoutStorage {

    CHIRunWorkoutInfo getCHIInfo() ;

    LSDRunWorkoutInfo getLSDInfo() ;

    INTRunWorkoutInfo getINTInfo() ;

    ArrayList<String> getOrder() ;

}

