package com.wonderguerrilla.android.workout.workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public interface ExerciseWorkout extends Workout {

    public Exercise getExercise(int index) ;

    public ArrayList<Exercise> getExercises() ;

    public int size() ;

}
