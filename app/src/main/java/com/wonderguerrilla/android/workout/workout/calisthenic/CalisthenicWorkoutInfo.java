package com.wonderguerrilla.android.workout.workout.calisthenic;

import com.wonderguerrilla.android.workout.storage.json.calisthenic.CalisthenicWorkoutJSONStorage;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkoutInfo {

    public static final String NAME = "Calisthenic" ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private CalisthenicWorkoutGenerator mGenerator ;
    private CalisthenicWorkoutStorage mStorage ;

    public CalisthenicWorkoutInfo() {
        mStorage = new CalisthenicWorkoutJSONStorage() ;
        mGenerator = new CalisthenicWorkoutGenerator(this) ;
    }

    public CalisthenicWorkoutStorage getStorage() {
        return mStorage ;
    }

    public CalisthenicWorkoutGenerator getGenerator() {
        return mGenerator ;
    }

    public String getName() {
        return NAME ;
    }

}
