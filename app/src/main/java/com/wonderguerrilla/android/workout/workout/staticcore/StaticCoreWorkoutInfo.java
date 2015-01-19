package com.wonderguerrilla.android.workout.workout.staticcore;

import com.wonderguerrilla.android.workout.storage.json.staticcore.StaticCoreWorkoutJSONStorage;

/**
 * Created by sebluy on 12/25/14.
 */
public class StaticCoreWorkoutInfo {

    public static final String NAME = "Static Core" ;

    private StaticCoreWorkoutGenerator mGenerator ;
    private StaticCoreWorkoutStorage mStorage ;

    public StaticCoreWorkoutInfo() {
        mStorage = new StaticCoreWorkoutJSONStorage() ;
        mGenerator = new StaticCoreWorkoutGenerator(this) ;
    }

    public StaticCoreWorkoutStorage getStorage() {
        return mStorage ;
    }

    public StaticCoreWorkoutGenerator getGenerator() {
        return mGenerator ;
    }

    public String getName() {
        return NAME ;
    }

}
