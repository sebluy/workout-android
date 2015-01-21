package com.wonderguerrilla.android.workout.workout;

/**
 * Created by sebluy on 1/20/15.
 */
public interface WorkoutInfo {

    Workout generate() ;

    void commit(Workout workout) ;

}
