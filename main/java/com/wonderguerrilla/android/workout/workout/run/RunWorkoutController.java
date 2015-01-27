package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.storage.json.run.RunWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

/**
 * Created by sebluy on 12/25/14.
 */
public class RunWorkoutController implements WorkoutController {

    public static final String NAME = "Run" ;

    private RunWorkoutStorage mStorage ;
    private RunWorkoutGenerator mGenerator ;

    public RunWorkoutController() {
        mStorage = new RunWorkoutJSONStorage() ;
        mGenerator = new RunWorkoutGenerator(this) ;
    }

    @Override
    public Workout generate() {
        return mGenerator.generate() ;
    }

    @Override
    public void commit(Workout workout) {}

    public RunWorkoutStorage getStorage() {
        return mStorage ;
    }

    public String getName() {
        return NAME ;
    }

}
