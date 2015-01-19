package com.wonderguerrilla.android.workout.workout;

import android.support.v4.app.Fragment ;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;

import org.json.JSONObject;

/**
 * Created by sebluy on 12/25/14.
 */

public class Exercise {

    private String mName ;

    public Exercise(String name) {
        mName = name ;
    }

    public String getName() {
        return mName ;
    }

}
