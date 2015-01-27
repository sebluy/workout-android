package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.workout.BaseWorkout;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class RunWorkout extends BaseWorkout {

    public static final String NAME = "Run" ;

    private ArrayList<String> mOrder ;

    public RunWorkout(RunWorkoutController controller, ArrayList<String> order) {
        super(controller) ;
        mOrder = order ;
    }

    public ArrayList<String> getOrder() {
        return mOrder ;
    }

    @Override
    public String getName() {
        return NAME ;
    }

}
