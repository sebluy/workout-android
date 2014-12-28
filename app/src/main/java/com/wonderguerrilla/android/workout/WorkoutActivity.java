package com.wonderguerrilla.android.workout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sebluy on 12/25/14.
 */
public class WorkoutActivity extends ActionBarActivity {

    public static final String EXTRA_WORKOUT_ID =
        "com.wonderguerrilla.android.workout.workout_id" ;

    private TextView mExerciseView ;
    private Button mNextButton ;
    private Button mPreviousButton ;
    private Workout mWorkout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        int workoutID = getIntent().getIntExtra(EXTRA_WORKOUT_ID, 0) ;

        mWorkout = WorkoutGenerator.fromID(workoutID) ;

        mExerciseView = (TextView)findViewById(R.id.workout_text_view) ;
        mExerciseView.setText(mWorkout.statusString()) ;

        mNextButton = (Button)findViewById(R.id.next_button) ;
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWorkout.increment() ;
                mExerciseView.setText(mWorkout.statusString());
            }
        });

        mPreviousButton = (Button)findViewById(R.id.previous_button) ;
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWorkout.decrement() ;
                mExerciseView.setText(mWorkout.statusString()) ;
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
