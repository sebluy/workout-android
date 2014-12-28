package com.wonderguerrilla.android.workout;

/**
 * Created by sebluy on 12/19/14.
 */
public interface Workout {

    void increment() ;

    void decrement() ;

    boolean isStarted() ;

    boolean isFinished() ;

    String statusString() ;

}

