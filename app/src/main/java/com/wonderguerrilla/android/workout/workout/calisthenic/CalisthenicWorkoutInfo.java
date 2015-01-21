package com.wonderguerrilla.android.workout.workout.calisthenic;

import com.wonderguerrilla.android.workout.storage.json.calisthenic.CalisthenicWorkoutJSONStorage;
import com.wonderguerrilla.android.workout.workout.Workout;
import com.wonderguerrilla.android.workout.workout.WorkoutInfo;

/**
 * Created by sebluy on 12/25/14.
 */
public class CalisthenicWorkoutInfo implements WorkoutInfo {

    public static final String NAME = "Calisthenic" ;

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private CalisthenicWorkoutGenerator mGenerator ;
    private CalisthenicWorkoutStorage mStorage ;

    public CalisthenicWorkoutInfo() {
        mStorage = new CalisthenicWorkoutJSONStorage() ;
        mGenerator = new CalisthenicWorkoutGenerator(this) ;
    }

    @Override
    public void commit(Workout workout) {}

    @Override
    public Workout generate() {
        return mGenerator.generate() ;
    }

    public CalisthenicWorkoutStorage getStorage() {
        return mStorage ;
    }

    public String getName() {
        return NAME ;
    }

}
