package com.wonderguerrilla.android.workout.workout.run;

import com.wonderguerrilla.android.workout.storage.json.run.RunWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.storage.json.staticcore.StaticCoreWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutGenerator;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreWorkoutStorage;

/**
 * Created by sebluy on 12/25/14.
 */
public class RunWorkoutInfo {

    public static final String NAME = "Run" ;

    private RunWorkoutStorage mStorage ;

    public RunWorkoutInfo() {
        mStorage = new RunWorkoutJSONStorage() ;
    }

    public String getName() {
        return NAME ;
    }

}
