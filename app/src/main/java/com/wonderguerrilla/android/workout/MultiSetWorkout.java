package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */
public class MultiSetWorkout extends Workout {

    private static final StaticCoreExercise[] CORE_EXERCISES = {
            new StaticCoreExercise("Bridge", 30),
            new StaticCoreExercise("Plank", 30),
            new StaticCoreExercise("Side Plank", 30),
            new StaticCoreExercise("Bird Dog", 30),
            new StaticCoreExercise("Superman", 30),
            new StaticCoreExercise("Leg Lever", 30)
    } ;

    private int mMaxSets ;

    public static MultiSetWorkout newCoreWorkout() {
        return new MultiSetWorkout("Core Workout", CORE_EXERCISES, 2) ;
    }

    public MultiSetWorkout(String name, Exercise[] exercises, int maxSets) {
        super(name, exercises) ;
        mMaxSets = maxSets ;
    }

    @Override
    public Exercise getExercise(int index) {
        return mExercises[index % mExercises.length] ;
    }

    @Override
    public int size() {
        return mExercises.length * mMaxSets ;
    }

}
