package com.wonderguerrilla.android.workout;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class StaticCoreExerciseUI extends ExerciseUI {

    private StaticCoreExercise mExercise ;
    private boolean mStarted ;
    private TextView mDurationView;
    private String mTimeLeft ;

    private String formatDuration(double duration) {
        return String.format("%.1f Seconds", duration) ;
    }

    public StaticCoreExerciseUI(Exercise exercise) {
        super(exercise) ;
        mExercise = (StaticCoreExercise)exercise ;
        mTimeLeft = formatDuration(mExercise.getDuration()) ;
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
                if (!mStarted) {
                    new CountDownTimer((long)mExercise.getDuration() * 1000, 100) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            mTimeLeft = formatDuration(millisUntilFinished / 1000.0);
                            mDurationView.setText(mTimeLeft) ;
                        }

                        @Override
                        public void onFinish() {
                            ((Vibrator)mDurationView.getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500);
                            mTimeLeft = "Done" ;
                            mDurationView.setText(mTimeLeft) ;
                        }
                    }.start();
                    mStarted = true ;
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
