package com.wonderguerrilla.android.workout;

import android.content.Context;
/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends MultipleExerciseWorkout {

    public static final String LOWER_NAME = "Lower Lifting" ;
    public static final String UPPER_NAME = "Upper Lifting" ;

    private static LiftingWorkout sUpper ;
    private static LiftingWorkout sLower ;

    public static LiftingWorkout getUpper(Context context) {
        if (sUpper == null) {
            sUpper = newUpper(context) ;
        }
        return sUpper ;
    }

    public static LiftingWorkout getLower(Context context) {
        if (sLower == null) {
            sLower = newLower(context) ;
        }
        return sLower ;
    }

    private static LiftingWorkout newUpper(Context context) {
        return newInstance(UPPER_NAME, LiftingWorkoutStorage.getUpper(context)) ;
    }

    private static LiftingWorkout newLower(Context context) {
        return newInstance(LOWER_NAME, LiftingWorkoutStorage.getLower(context)) ;
    }

    private static LiftingWorkout newInstance(String name, LiftingWorkoutStorage storage) {
        LiftingWorkoutOrderGenerator orderGenerator = new LiftingWorkoutOrderGenerator(storage.getOrder()) ;
        LiftingWorkoutGenerator generator = new LiftingWorkoutGenerator(storage.getExercises(), orderGenerator) ;
        return new LiftingWorkout(name, generator, storage) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public LiftingWorkout(String name, LiftingWorkoutGenerator generator, LiftingWorkoutStorage storage) {
        super(name, generator, storage) ;
    }

}
