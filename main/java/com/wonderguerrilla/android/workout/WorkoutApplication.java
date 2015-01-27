package com.wonderguerrilla.android.workout;

import android.app.Application;
import android.content.Context;

/**
 * Created by sebluy on 1/18/15.
 */
public class WorkoutApplication extends Application {

    private static WorkoutApplication instance ;

    public static Context getContext() {
        return instance.getApplicationContext() ;
    }

    @Override
    public void onCreate() {
        super.onCreate() ;
        instance = this ;
    }

}
