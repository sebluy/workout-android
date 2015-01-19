package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.Workout;

public class WorkoutActivity extends SingleFragmentActivity {

    private Workout mWorkout ;
    private WorkoutActivityUI mWorkoutUI;

    @Override
    protected void setTitle() {
        setTitle(mWorkoutUI.getTitle()) ;
    }

    @Override
    protected Fragment newFragment() {
        return mWorkoutUI.newFragment() ;
    }

    @Override
    protected void initialize() {
        mWorkout = WorkoutHolder.getCurrent() ;
        mWorkoutUI = WorkoutActivityUI.get(mWorkout) ;
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
                mWorkout.commit() ;
                Toast.makeText(this, "Much success!", Toast.LENGTH_SHORT).show() ;
                return true ;
            case R.id.menu_workout_item_new:
                mWorkout.recreate() ;
                ((ExerciseListFragment)getFragment()).update() ;
                return true ;
            default:
                return super.onOptionsItemSelected(item) ;
        }
    }
}
