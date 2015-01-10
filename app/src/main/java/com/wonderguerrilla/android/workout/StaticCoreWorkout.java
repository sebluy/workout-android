package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkout extends Workout {

    public static final String STATIC_CORE_NAME = "Static Core Workout" ;

    private static final StaticCoreExercise[] CORE_EXERCISES = {
            new StaticCoreExercise("Bridge", 30),
            new StaticCoreExercise("Plank", 30),
            new StaticCoreExercise("Side Plank", 30),
            new StaticCoreExercise("Bird Dog", 30),
            new StaticCoreExercise("Superman", 30),
            new StaticCoreExercise("Leg Lever", 30)
    } ;

    private int mMaxSets ;

    public static StaticCoreWorkout newStaticCoreWorkout() {
        return new StaticCoreWorkout(STATIC_CORE_NAME, CORE_EXERCISES, 2) ;
    }

    public StaticCoreWorkout(String name, Exercise[] exercises, int maxSets) {
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
