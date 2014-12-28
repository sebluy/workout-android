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
    private int mIndex ;
    private int mCurrentSet ;
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
        mIndex = 0 ;
        mCurrentSet = 1 ;
    }

    public Exercise getCurrentExercise() {
        return mExercises[mIndex] ;
    }

    public boolean isStarted() {
        return mIndex > 0 || mCurrentSet > 1 ;
    }

    public boolean isFinished() {
        return (mIndex == mExercises.length - 1) && (mCurrentSet == mMaxSets) ;
    }

    public void increment() {
        if (mIndex >= mExercises.length - 1) {
            if (mCurrentSet < mMaxSets) {
                mCurrentSet++;
                mIndex = 0;
            }
        } else {
            mIndex++ ;
        }
    }

    public void decrement() {
        if (mIndex <= 0)  {
            if (mCurrentSet > 1) {
                mCurrentSet-- ;
                mIndex = mExercises.length - 1 ;
            }
        } else {
            mIndex-- ;
        }
    }

    public String statusString() {
        return "Set " + mCurrentSet + '\n' + getCurrentExercise().toString() ;
    }

}
