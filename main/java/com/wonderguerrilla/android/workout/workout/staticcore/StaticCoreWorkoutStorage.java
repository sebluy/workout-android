package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public interface StaticCoreWorkoutStorage {

    ArrayList<StaticCoreExerciseInfo> getExerciseList() ;

    StaticCoreExerciseInfo getExercise(String name) ;

    void commit() ;

}

