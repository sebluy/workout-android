package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */
public class MultiSetWorkout implements Workout {

    private static final CalisthenicExercise[] CALISTHENIC_EXERCISES = {
            new CalisthenicExercise("Pushup", 5, "Slow"),
            new CalisthenicExercise("Squat", 10, "Slow"),
            new CalisthenicExercise("Crunch", 20, "Slow"),
            new CalisthenicExercise("Pullup", 3, "Slow"),
            new CalisthenicExercise("Lunge", 10, "Slow"),
    } ;

    private static final CoreExercise[] CORE_EXERCISES = {
            new CoreExercise("Bridge", 20, "Reps"),
            new CoreExercise("Plank", 30, "Seconds"),
            new CoreExercise("Side Plank", 30, "Seconds"),
            new CoreExercise("Bird Dog", 20, "Reps"),
            new CoreExercise("Superman", 10, "Reps"),
            new CoreExercise("Wiper", 20, "Reps"),
    } ;

    private Exercise[] mExercises ;
    private int mMaxSets ;

    public static MultiSetWorkout newCalisthenicWorkout() {
        return new MultiSetWorkout(CALISTHENIC_EXERCISES, 6) ;
    }

    public static MultiSetWorkout newCoreWorkout() {
        return new MultiSetWorkout(CORE_EXERCISES, 2) ;
    }

    public MultiSetWorkout(Exercise[] exercises, int maxSets) {
        mExercises = exercises ;
        mMaxSets = maxSets ;
    }

    public Exercise getExercise(int index) {
        return mExercises[index % mExercises.length] ;
    }

    public int size() {
        return mExercises.length * mMaxSets ;
    }

}
