package com.wonderguerrilla.android.workout.storage.json.run;

import workout.run.CHIRunWorkoutInfo;
import workout.run.INTRunWorkoutInfo;
import workout.run.LSDRunWorkoutInfo;
import workout.run.RunWorkoutStorage;

import java.util.ArrayList;

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

