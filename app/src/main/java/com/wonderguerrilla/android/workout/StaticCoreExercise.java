package com.wonderguerrilla.android.workout;

import android.content.Context;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import org.json.JSONObject;

/**
 * Created by sebluy on 12/25/14.
 */

public class StaticCoreExercise extends Exercise implements Cloneable {

    private double mDuration;
    private boolean mStarted ;
    private TextView mDurationView;
    private String mTimeLeft ;

    private String formatDuration(double duration) {
        return String.format("%.1f Seconds", duration) ;
    }

    public StaticCoreExercise(String name, JSONObject object) {
        super(name);
        try {
            mDuration = object.getInt("Duration");
        } catch (Exception e) {
        }
        mTimeLeft = formatDuration(mDuration) ;
    }

    public StaticCoreExercise(String name, double duration) {
        super(name) ;
        mDuration = duration ;
        mTimeLeft = formatDuration(mDuration) ;
    }

    public void levelUp() {
        mDuration *= 1.05 ;
    }

    public StaticCoreExercise clone() {
        return new StaticCoreExercise(getName(), mDuration) ;
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
                    new CountDownTimer((long)mDuration * 1000, 100) {
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
