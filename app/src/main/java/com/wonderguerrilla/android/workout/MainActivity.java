package com.wonderguerrilla.android.workout;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends ActionBarActivity {

    private Button mStartLowerLiftingWorkout ;
    private Button mStartUpperLiftingWorkout ;
    private Button mStartCalisthenicWorkout ;
    private Button mStartCoreWorkout ;

    private void startNewWorkoutActivity(int workoutID) {
        Intent intent = new Intent(MainActivity.this, WorkoutActivity.class) ;
        intent.putExtra(WorkoutActivity.EXTRA_WORKOUT_ID,
            workoutID) ;
        startActivity(intent) ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartLowerLiftingWorkout = (Button)findViewById(R.id.start_lower_lifting_workout_button) ;
        mStartLowerLiftingWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewWorkoutActivity(WorkoutGenerator.LOWER_LIFTING_WORKOUT_ID);
            }
        });

        mStartUpperLiftingWorkout = (Button)findViewById(R.id.start_upper_lifting_workout_button) ;
        mStartUpperLiftingWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewWorkoutActivity(WorkoutGenerator.UPPER_LIFTING_WORKOUT_ID) ;
            }
        });

        mStartCalisthenicWorkout = (Button)findViewById(R.id.start_calisthenic_workout_button) ;
        mStartCalisthenicWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewWorkoutActivity(WorkoutGenerator.CALISTHENIC_WORKOUT_ID) ;
            }

        });

        mStartCoreWorkout = (Button)findViewById(R.id.start_core_workout_button) ;
        mStartCoreWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewWorkoutActivity(WorkoutGenerator.CORE_WORKOUT_ID);
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
