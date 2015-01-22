package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.MultipleExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Workout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator {

    private LiftingWorkoutController mInfo ;
    private LiftingWorkoutOrderGenerator mOrderGenerator ;

    public LiftingWorkoutGenerator(LiftingWorkoutController info) {
        mInfo = info ;
        mOrderGenerator = info.getOrderGenerator() ;
    }

    public Workout generate() {
        return new MultipleExerciseWorkout(mInfo.getName(), mInfo, generateExercises()) ;
    }

    private ArrayList<Exercise> generateExercises() {
        ArrayList<String> order = mOrderGenerator.generate() ;
        int size = order.size() ;
        ArrayList<Exercise> exerciseList = new ArrayList<>(size) ;

        for (int i = 0 ; i < size ; i++) {
            String exerciseName = order.get(i) ;
            LiftingExerciseInfo exerciseInfo = mInfo.getExercise(exerciseName) ;
            exerciseList.add(exerciseInfo.newExercise()) ;
        }

        return exerciseList ;
    }

}
