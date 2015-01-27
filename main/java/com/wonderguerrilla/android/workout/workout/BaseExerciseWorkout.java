package com.wonderguerrilla.android.workout.workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class BaseExerciseWorkout extends BaseWorkout {

    public static final String NAME = "Base Exercise" ;

    private ArrayList<Exercise> mExercises ;

    public BaseExerciseWorkout(WorkoutController controller, ArrayList<Exercise> exercises) {
        super(controller) ;
        mExercises = exercises ;
    }

    public Exercise getExercise(int index) {
        return mExercises.get(index) ;
    }

    public ArrayList<Exercise> getExercises() {
        return mExercises ;
    }

    public int size() {
        return mExercises.size() ;
    }

    @Override
    public String getName() {
        return NAME ;
    }

}
