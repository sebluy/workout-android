package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.storage.json.staticcore.StaticCoreWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutController;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkoutController implements WorkoutController {

    public static final String NAME = "Static Core" ;

    private StaticCoreWorkoutGenerator mGenerator ;
    private StaticCoreWorkoutStorage mStorage ;

    public StaticCoreWorkoutController() {
        mStorage = new StaticCoreWorkoutJSONStorage() ;
        mGenerator = new StaticCoreWorkoutGenerator(this) ;
    }

    @Override
    public Workout generate() {
        return mGenerator.generate() ;
    }

    @Override
    public void commit(Workout workout) {
    }

    public StaticCoreWorkoutStorage getStorage() {
        return mStorage ;
    }


    public String getName() {
        return NAME ;
    }

}
