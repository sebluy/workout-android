package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import java.awt.font.TextAttribute;

/**
 * Created by sebluy on 12/25/14.
 */

public class Exercise {

    private String mName ;

    public Exercise(String name) {
        mName = name ;
    }

    public int getLayout() {
        return R.layout.fragment_exercise ;
    }

    public void fillLayout(View v) {
        TextView name = (TextView)v.findViewById(R.id.exercise_name) ;
        name.setText(mName);
    }

}
