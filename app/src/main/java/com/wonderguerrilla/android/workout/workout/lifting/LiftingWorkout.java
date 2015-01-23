package com.wonderguerrilla.android.workout.workout.lifting;

import com.wonderguerrilla.android.workout.workout.BaseExerciseWorkout;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.WorkoutController;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutFeedback;

import java.util.ArrayList;

/**
 * Created by sebluy on 12/25/14.
 */

public class LiftingWorkout extends BaseExerciseWorkout {

    public static final String UPPER_NAME = "Upper Lifting" ;
    public static final String LOWER_NAME = "Lower Lifting" ;

    private String mName;

    public LiftingWorkout(LiftingWorkoutController controller, ArrayList<Exercise> exercises) {
        super(controller, exercises) ;
        mName = controller.getName() ;
    }

    @Override
    public String getName() {
        return mName ;
    }

}
