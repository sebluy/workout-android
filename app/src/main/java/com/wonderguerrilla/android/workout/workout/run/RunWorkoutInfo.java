package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.storage.json.run.RunWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.storage.json.staticcore.StaticCoreWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutInfo;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutGenerator;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutStorage;

/**
 * Created by sebluy on 12/25/14.
 */
public class RunWorkoutInfo implements WorkoutInfo {

    public static final String NAME = "Run" ;

    private RunWorkoutStorage mStorage ;
    private RunWorkoutGenerator mGenerator ;

    public RunWorkoutInfo() {
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
