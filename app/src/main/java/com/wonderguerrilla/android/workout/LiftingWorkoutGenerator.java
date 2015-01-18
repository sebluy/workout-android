package com.wonderguerrilla.android.workout;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkoutGenerator extends WorkoutGenerator {

    public static LiftingWorkoutGenerator newUpper() {
        LiftingWorkoutInfo info = LiftingWorkoutInfo.newUpper() ;
        LiftingWorkoutOrderGenerator orderGenerator = LiftingWorkoutOrderGenerator.newUpper() ;
        return new LiftingWorkoutGenerator(info, orderGenerator) ;
    }

    public static LiftingWorkoutGenerator newLower() {
        LiftingWorkoutInfo info = LiftingWorkoutInfo.newLower() ;
        LiftingWorkoutOrderGenerator orderGenerator = LiftingWorkoutOrderGenerator.newLower() ;
        return new LiftingWorkoutGenerator(info, orderGenerator) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private LiftingWorkoutInfo mInfo;
    private LiftingWorkoutOrderGenerator mOrderGenerator ;

    public LiftingWorkoutGenerator(LiftingWorkoutInfo info, LiftingWorkoutOrderGenerator orderGenerator) {
        mInfo = info ;
        mOrderGenerator = orderGenerator ;
    }

    public MultipleExerciseWorkout generateWorkout() {
        return new MultipleExerciseWorkout(mInfo.getName(), this) ;
    }

    public ArrayList<Exercise> generateExercises() {
        ArrayList<String> order = mOrderGenerator.generate() ;
        int size = order.size() ;
        ArrayList<Exercise> exerciseList = new ArrayList<>(size) ;

        for (int i = 0 ; i < size ; i++) {
            String exerciseName = order.get(i) ;
            LiftingExerciseInfo exerciseInfo = mInfo.getExerciseInfo(exerciseName) ;
            exerciseList.add(exerciseInfo.newExercise()) ;
        }

        return exerciseList ;
    }

}
