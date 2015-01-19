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
public class StaticCoreExerciseUI extends ExerciseUI {

    private StaticCoreExercise mExercise ;
    private TextView mDurationView;
    private String mTimeLeft ;

    private String formatDuration(double duration) {
        return String.format("%.1f Seconds", duration) ;
    }

    public StaticCoreExerciseUI(Exercise exercise) {
        super(exercise) ;
        mExercise = (StaticCoreExercise)exercise ;
        mTimeLeft = formatDuration(mExercise.getTimeLeft()) ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_static_core_exercise;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;

        mDurationView = (TextView) view.findViewById(R.id.duration);

        mDurationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mExercise.isReady()) {
                    new CountDownTimer((long)mExercise.getTimeLeft() * 1000, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            double timeLeft = millisUntilFinished/1000.0 ;
                            mExercise.setTimeLeft(timeLeft) ;
                            mTimeLeft = formatDuration(timeLeft) ;
                            mDurationView.setText(mTimeLeft) ;
                        }

                        @Override
                        public void onFinish() {
                            ((Vibrator)mDurationView.getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500);
                            mExercise.setTimeLeft(0) ;
                            mTimeLeft = "Done" ;
                            mDurationView.setText(mTimeLeft) ;
                        }
                    }.start();
                }
            }
        });

        mDurationView.setText(mTimeLeft);
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_static_core_exercise;
    }

}
