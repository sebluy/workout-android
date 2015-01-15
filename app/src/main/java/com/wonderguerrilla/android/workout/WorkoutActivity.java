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
        return new WorkoutFragment() ;
    }

    @Override
    protected void initialize() {
        mWorkout = WorkoutHolder.get() ;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu) ;
        getMenuInflater().inflate(R.menu.menu_exercise_list, menu) ;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.workout_menu_item_commit:
                mWorkout.save() ;
                Toast.makeText(this, "Much success!", Toast.LENGTH_SHORT).show() ;
                return true ;
            default:
                return super.onOptionsItemSelected(item) ;
        }
    }
}
