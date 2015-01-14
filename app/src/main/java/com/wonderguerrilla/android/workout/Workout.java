package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.Button;

/**
 * Created by sebluy on 12/25/14.
 */

public class Workout {

    private String mName ;
    protected Exercise[] mExercises ;

    public Workout(String name, Exercise[] exercises) {
        mName = name ;
        mExercises = exercises ;
    }

    public int getLayout() {
        return R.layout.fragment_workout ;
    }

    public void fillLayout(View view, final WorkoutFragment fragment) {
        Button start = (Button)view.findViewById(R.id.start_workout_button) ;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.startNewExercisePagerActivity(mName) ;
            }
        });

    }

    public void save() {}

    public String getName() {
        return mName ;
    }

    public Exercise getExercise(int index) {
        return mExercises[index] ;
    }

    public int size() {
        return mExercises.length ;
    }

}
