package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.workout.BaseExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreWorkout extends BaseExerciseWorkout {

    public static final String NAME = "Static Core" ;

    private StaticCoreWorkoutFeedback mFeedback ;

    public StaticCoreWorkout(WorkoutController controller, ArrayList<Exercise> exercises) {
        super(controller, exercises) ;
        mFeedback = new StaticCoreWorkoutFeedback(this) ;
    }

    public StaticCoreWorkoutFeedback getFeedback() {
        return mFeedback ;
    }

    @Override
    public String getName() {
        return NAME ;
    }

}
