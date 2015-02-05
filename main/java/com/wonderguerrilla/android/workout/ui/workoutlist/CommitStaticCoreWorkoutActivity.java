package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.wonderguerrilla.android.workout.R;
import workout.staticcore.StaticCoreWorkout;
import workout.staticcore.StaticCoreWorkoutFeedback;

/**
 * Created by sebluy on 12/25/14.
 */
public class CommitStaticCoreWorkoutActivity extends ActionBarActivity {

    private ViewPager mViewPager ;
    private StaticCoreWorkoutFeedback mFeedback ;
    private StaticCoreWorkout mWorkout ;

    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);

        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

        mWorkout = (StaticCoreWorkout)WorkoutHolder.getCurrent() ;
        setTitle(mWorkout.getName());

        mFeedback = mWorkout.getFeedback() ;

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                return StaticCoreExerciseFeedbackFragment.newInstance(i) ;
            }

            @Override
            public int getCount() {
                return mFeedback.getFeedbackList().size() ;
            }
        });
    }

    @Override
    public void finish() {
        mWorkout.commit() ;
        super.finish() ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu) ;
        getMenuInflater().inflate(R.menu.menu_commit_static_core_workout, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.finish:
                finish() ;
                return true ;
            default:
                return super.onOptionsItemSelected(item) ;
        }
    }

}

