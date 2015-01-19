package com.wonderguerrilla.android.workout.workout.staticcore;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.R;

import org.json.JSONObject;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExercise extends Exercise implements Cloneable {

    private double mDuration;

    public StaticCoreExercise(String name, double duration) {
        super(name) ;
        mDuration = duration ;
    }

    public double getDuration() {
        return mDuration;
    }
}
