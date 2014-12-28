package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkout implements Workout {

    private static final CalisthenicExercise[] CALISTHENIC_EXERCISES = {
            new CalisthenicExercise("Pushup", 5, "Slow"),
            new CalisthenicExercise("Squat", 10, "Slow"),
            new CalisthenicExercise("Crunch", 20, "Slow"),
            new CalisthenicExercise("Pullup", 3, "Slow"),
            new CalisthenicExercise("Lunge", 10, "Slow"),
    } ;

    private static final int MAX_SETS = 6 ;

    private CalisthenicExercise[] mExercises ;
    private int mIndex ;
    private int mCurrentSet ;

    public CalisthenicWorkout() {
        mExercises = CALISTHENIC_EXERCISES ;
        mIndex = 0 ;
        mCurrentSet = 1 ;
    }

    public CalisthenicExercise getCurrentExercise() {
        return mExercises[mIndex] ;
    }

    public void increment() {
        if (mIndex >= mExercises.length - 1) {
            if (mCurrentSet < MAX_SETS) {
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
