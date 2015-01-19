package com.wonderguerrilla.android.workout.lifting;

import com.wonderguerrilla.android.workout.lifting.storage.LiftingWorkoutStorage;
import com.wonderguerrilla.android.workout.lifting.storage.json.LiftingWorkoutJSONStorage;

/**
 * Created by sebluy on 1/18/15.
 */
public class LiftingWorkoutInfo {

    public static final String UPPER_NAME = "Upper Lifting" ;
    public static final String LOWER_NAME = "Lower Lifting" ;

    public static LiftingWorkoutInfo newUpper() {
        return new LiftingWorkoutInfo(UPPER_NAME, LiftingWorkoutJSONStorage.newUpper()) ;
    }

    public static LiftingWorkoutInfo newLower() {
        return new LiftingWorkoutInfo(LOWER_NAME , LiftingWorkoutJSONStorage.newLower()) ;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private String mName;

    private LiftingWorkoutOrderGenerator mOrderGenerator ;
    private LiftingWorkoutGenerator mGenerator ;
    private LiftingWorkoutStorage mStorage ;

    public LiftingWorkoutInfo(String name, LiftingWorkoutJSONStorage storage) {
        mName = name ;
        mStorage = storage ;
        mOrderGenerator = new LiftingWorkoutOrderGenerator(storage) ;
        mGenerator = new LiftingWorkoutGenerator(this) ;
    }

    public LiftingWorkoutStorage getStorage() {
        return mStorage ;
    }

    public LiftingWorkoutGenerator getGenerator() {
        return mGenerator ;
    }

    public String getName() {
        return mName;
    }

    public LiftingWorkoutOrderGenerator getOrderGenerator() {
        return mOrderGenerator;
    }
}
