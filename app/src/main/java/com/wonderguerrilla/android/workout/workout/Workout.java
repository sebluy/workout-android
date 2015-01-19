package com.wonderguerrilla.android.workout.workout;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.WorkoutFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;

    public Workout(String name) {
        mName = name ;
    }

    public String getName() {
        return mName ;
    }

    public void commit() {}

    public void recreate() {}

}
