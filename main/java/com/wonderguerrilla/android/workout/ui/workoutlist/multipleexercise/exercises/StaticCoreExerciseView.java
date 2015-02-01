package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class StaticCoreExerciseView extends ExerciseView {

    private StaticCoreExercise mExercise ;

    public StaticCoreExerciseView(Exercise exercise) {
        super(exercise) ;
        mExercise = (StaticCoreExercise)exercise ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_static_core_exercise;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;

        TimerView durationView = (TimerView)view.findViewById(R.id.duration);
        durationView.setDuration(mExercise.getDuration()) ;
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_static_core_exercise;
    }

    @Override
    public void fillListItemLayout(View view) {
        super.fillLayout(view) ;
        TextView durationView = (TextView)view.findViewById(R.id.duration);
        durationView.setText(String.valueOf(mExercise.getDuration())) ;
    }

}
