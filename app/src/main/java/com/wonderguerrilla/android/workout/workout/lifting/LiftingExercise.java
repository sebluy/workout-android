package com.wonderguerrilla.android.workout.workout.lifting;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.R;

/**
 * Created by sebluy on 12/20/14.
 */
public class LiftingExercise extends Exercise {

    private double mWeight ;
    private String mUnit ;
    private int mRepetitions ;

    public LiftingExercise(String name, double weight, String unit, int repetitions) {
        super(name) ;
        mWeight = weight ;
        mUnit = unit ;
        mRepetitions = repetitions ;
    }

    public double getWeight() {
        return mWeight;
    }

    public int getRepetitions() {
        return mRepetitions;
    }

    public void setRepetitions(int repetitions) {
        mRepetitions = repetitions;
    }

    public String getUnit() {
        return mUnit;
    }
}
