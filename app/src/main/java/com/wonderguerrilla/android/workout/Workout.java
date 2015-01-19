package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

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

    public Fragment newFragment() {
        return new WorkoutFragment() ;
    }

    public int getLayout() {
        return R.layout.fragment_workout ;
    }

    public void fillLayout(View view) {
        TextView title = (TextView)view.findViewById(R.id.name) ;
        title.setText(mName) ;
    }

}
