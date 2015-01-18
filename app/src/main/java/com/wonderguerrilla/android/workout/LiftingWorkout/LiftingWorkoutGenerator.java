package com.wonderguerrilla.android.workout.LiftingWorkout;

import com.wonderguerrilla.android.workout.Exercise;
import com.wonderguerrilla.android.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.WorkoutGenerator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator extends WorkoutGenerator {

    private LiftingWorkoutInfo mInfo ;
    private LiftingWorkoutOrderGenerator mOrderGenerator ;
    private HashMap<String, LiftingExerciseInfo> mExercises ;

    public LiftingWorkoutGenerator(LiftingWorkoutInfo info) {
        mInfo = info ;
        mOrderGenerator = info.getOrderGenerator() ;
        mExercises = info.getStorage().getExercises() ;
    }

    public MultipleExerciseWorkout newWorkout() {
        return new MultipleExerciseWorkout(mInfo.getName(), this) ;
    }

    public ArrayList<Exercise> generateExercises() {
        ArrayList<String> order = mOrderGenerator.generate() ;
        int size = order.size() ;
        ArrayList<Exercise> exerciseList = new ArrayList<>(size) ;

        for (int i = 0 ; i < size ; i++) {
            String exerciseName = order.get(i) ;
            LiftingExerciseInfo exerciseInfo = mExercises.get(exerciseName) ;
            exerciseList.add(exerciseInfo.newExercise()) ;
        }

        return exerciseList ;
    }

}