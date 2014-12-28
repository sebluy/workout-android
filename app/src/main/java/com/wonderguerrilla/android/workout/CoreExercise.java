package com.wonderguerrilla.android.workout;
 /**
 * Created by sebluy on 12/25/14.
 */

public class CoreExercise implements Exercise {

    private String mName ;
    int mQuantity ;
    String mUnit ; /* perhaps use enum for unit ("Seconds" or "Reps") */

    public CoreExercise(String name, int quantity, String unit) {
        mName = name ;
        mQuantity = quantity ;
        mUnit = unit ;
    }

    public String toString() {
        return mName + '\n' + mQuantity + '\n' + mUnit ;
    }
}
