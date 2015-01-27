package com.wonderguerrilla.android.workout.storage.json.run;

import com.wonderguerrilla.android.workout.workout.lifting.LiftingExerciseInfo;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingWorkoutStorage;
import com.wonderguerrilla.android.workout.workout.run.CHIRunWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.run.INTRunWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.run.LSDRunWorkoutInfo;
import com.wonderguerrilla.android.workout.workout.run.RunWorkoutStorage;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sebluy on 1/18/15.
 */
public class RunWorkoutJSONStorage implements RunWorkoutStorage {

    private INTRunWorkoutInfoJSONStorage mINTStorage ;
    private CHIRunWorkoutInfoJSONStorage mCHIStorage ;
    private LSDRunWorkoutInfoJSONStorage mLSDStorage ;
    private RunWorkoutOrderJSONStorage mOrderStorage ;

    public RunWorkoutJSONStorage() {
        mINTStorage = new INTRunWorkoutInfoJSONStorage() ;
        mCHIStorage = new CHIRunWorkoutInfoJSONStorage() ;
        mLSDStorage = new LSDRunWorkoutInfoJSONStorage() ;
        mOrderStorage = new RunWorkoutOrderJSONStorage() ;
    }

    @Override
    public CHIRunWorkoutInfo getCHIInfo() {
        return mCHIStorage.getCHIInfo() ;
    }

    @Override
    public INTRunWorkoutInfo getINTInfo() {
        return mINTStorage.getINTInfo() ;
    }

    @Override
    public LSDRunWorkoutInfo getLSDInfo() {
        return mLSDStorage.getLSDInfo() ;
    }

    @Override
    public ArrayList<String> getOrder() {
        return mOrderStorage.getOrder() ;
    }
}

