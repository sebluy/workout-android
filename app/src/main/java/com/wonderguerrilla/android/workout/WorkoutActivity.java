package com.wonderguerrilla.android.workout;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class WorkoutActivity extends SingleFragmentActivity {

    Workout mWorkout ;

    @Override
    protected void setTitle() {
        setTitle(mWorkout.getName()) ;
    }

    @Override
    protected Fragment newFragment() {
        return mWorkout.newFragment() ;
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
                mWorkout.save() ;
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
