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

    private String mWeight ;
    private int mRepetitions ;

    public LiftingExercise(String name, String weight, int repetitions) {
        super(name) ;
        mWeight = weight ;
        mRepetitions = repetitions ;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public int getRepetitions() {
        return mRepetitions;
    }

    public void setRepetitions(int repetitions) {
        mRepetitions = repetitions;
    }
}
