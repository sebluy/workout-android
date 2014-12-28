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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStartLowerLiftingWorkout = (Button)findViewById(R.id.start_lower_lifting_workout_button) ;
        mStartLowerLiftingWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiftingWorkoutActivity.class) ;
                intent.putExtra(LiftingWorkoutActivity.EXTRA_LIFTING_WORKOUT_ID,
                        LiftingWorkout.LOWER_LIFTING_WORKOUT_ID) ;
                startActivity(intent) ;
            }
        });

        mStartUpperLiftingWorkout = (Button)findViewById(R.id.start_upper_lifting_workout_button) ;
        mStartUpperLiftingWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiftingWorkoutActivity.class) ;
                intent.putExtra(LiftingWorkoutActivity.EXTRA_LIFTING_WORKOUT_ID,
                        LiftingWorkout.UPPER_LIFTING_WORKOUT_ID) ;
                startActivity(intent) ;
            }
        });

        mStartCalisthenicWorkout = (Button)findViewById(R.id.start_calisthenic_workout_button) ;
        mStartCalisthenicWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalisthenicWorkoutActivity.class) ;
                startActivity(intent) ;
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
