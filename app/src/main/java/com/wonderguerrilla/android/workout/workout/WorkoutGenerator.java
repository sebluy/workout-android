package com.wonderguerrilla.android.workout.workout;

import com.wonderguerrilla.android.workout.workout.Exercise;

import java.util.ArrayList;

/**
 * Created by sebluy on 1/16/15.
 */
public interface WorkoutGenerator {

    ArrayList<Exercise> generateExercises() ;

    void commit(ArrayList<Exercise> exercises) ;

}
