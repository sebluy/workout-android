package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.ExerciseListFragment;
import com.wonderguerrilla.android.workout.workout.Workout;

public class WorkoutActivity extends SingleFragmentActivity {

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
                ((WorkoutFragment)getFragment()).commit() ;
                return true ;
            case R.id.menu_workout_item_new:
                WorkoutHolder.setCurrent(mWorkout.generate()) ;
                ((ExerciseListFragment)getFragment()).update() ;
                return true ;
            default:
                return super.onOptionsItemSelected(item) ;
        }
    }
}
