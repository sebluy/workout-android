package com.wonderguerrilla.android.workout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by sebluy on 12/25/14.
 */
public class ExercisePagerActivity extends ActionBarActivity {

    public static final String EXTRA_WORKOUT_ID =
            "com.wonderguerrilla.android.workout.workout_id" ;

    private ViewPager mViewPager ;
    private Workout mWorkout ;

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        int workoutID = getIntent().getIntExtra(EXTRA_WORKOUT_ID, 0) ;
        mWorkout = WorkoutGenerator.fromID(workoutID) ;

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return ExerciseFragment.newInstance(i) ;
            }

            @Override
            public int getCount() {
                return mWorkout.size() ;
            }
        });
    }
}

