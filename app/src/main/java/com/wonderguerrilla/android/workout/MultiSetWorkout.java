package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */
public class MultiSetWorkout extends Workout {

    private static final CalisthenicExercise[] CALISTHENIC_EXERCISES = {
            new CalisthenicExercise("Pushup", 5, "Slow"),
            new CalisthenicExercise("Squat", 10, "Slow"),
            new CalisthenicExercise("Crunch", 20, "Slow"),
            new CalisthenicExercise("Pullup", 3, "Slow"),
            new CalisthenicExercise("Lunge", 10, "Slow"),
    } ;

    private static final CoreExercise[] CORE_EXERCISES = {
            new CoreExercise("Bridge", 30),
            new CoreExercise("Plank", 30),
            new CoreExercise("Side Plank", 30),
            new CoreExercise("Bird Dog", 30),
            new CoreExercise("Superman", 30),
            new CoreExercise("Leg Lever", 30)
    } ;

    private int mMaxSets ;

    public static MultiSetWorkout newCalisthenicWorkout() {
        return new MultiSetWorkout("Calisthenic Workout", CALISTHENIC_EXERCISES, 6) ;
    }

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
