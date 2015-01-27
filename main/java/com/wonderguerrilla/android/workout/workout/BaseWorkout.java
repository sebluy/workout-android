package com.wonderguerrilla.android.workout.workout;

/**
 * Created by sebluy on 12/25/14.
 */

public class BaseWorkout implements Workout {

    public static final String NAME = "Base" ;

    private WorkoutController mController ;

    public BaseWorkout(WorkoutController info) {
        mController = info ;
    }

    @Override
    public String getName() {
        return NAME ;
    }

    @Override
    public void commit() {
        mController.commit(this) ;
    }

    @Override
    public Workout generate() {
        return mController.generate() ;
    }

}
