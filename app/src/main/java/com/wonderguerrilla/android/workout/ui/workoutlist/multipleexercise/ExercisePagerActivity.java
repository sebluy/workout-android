package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.WorkoutHolder;
import com.wonderguerrilla.android.workout.workout.ExerciseWorkout;

/**
 * Created by sebluy on 12/25/14.
 */
public class ExercisePagerActivity extends ActionBarActivity {

    private ViewPager mViewPager ;
    private ExerciseWorkout mWorkout ;

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON) ;

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        int exerciseNumber = getIntent().getIntExtra(ExerciseFragment.EXTRA_EXERCISE_NUMBER, 0) ;
        setContentView(mViewPager);

        mWorkout = (ExerciseWorkout) WorkoutHolder.getCurrent() ;
        setTitle(mWorkout.getName());

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

        mViewPager.setCurrentItem(exerciseNumber) ;
    }

}

