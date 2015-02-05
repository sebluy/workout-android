package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.ExerciseListFragment;

import workout.Workout;
import workout.staticcore.StaticCoreWorkout;

public class WorkoutActivity extends SingleFragmentActivity {

    private static final int COMMIT_WORKOUT_REQUEST = 0 ;
    private Workout mWorkout ;

    @Override
    public Fragment newFragment() {
        return WorkoutFragment.get(mWorkout) ;
    }

    @Override
    public void setTitle() {
        setTitle(mWorkout.getName()) ;
    }

    @Override
    protected void initialize() {
        mWorkout = WorkoutHolder.getCurrent() ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu) ;
        getMenuInflater().inflate(R.menu.menu_workout, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_workout_item_commit:
                commit() ;
                return true ;
            case R.id.menu_workout_item_new:
                WorkoutHolder.setCurrent(mWorkout.generate()) ;
                ((ExerciseListFragment)getFragment()).update() ;
                return true ;
            default:
                return super.onOptionsItemSelected(item) ;
        }
    }

    private void commit() {
        if (mWorkout instanceof StaticCoreWorkout) {
            Intent intent ;
            intent = new Intent(this, CommitStaticCoreWorkoutActivity.class) ;
            startActivityForResult(intent, COMMIT_WORKOUT_REQUEST) ;
        } else {
            mWorkout.commit() ;
            finish() ;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == COMMIT_WORKOUT_REQUEST) {
            finish() ;
        }
    }
}
