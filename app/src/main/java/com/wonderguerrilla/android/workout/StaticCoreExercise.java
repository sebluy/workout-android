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

public class StaticCoreExercise extends Exercise {

    int mDuration;
    TextView mDurationView;

    public StaticCoreExercise(String name, JSONObject object) {
        super(name);
        try {
            mDuration = object.getInt("Duration");
        } catch (Exception e) {
        }
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
                new CountDownTimer(30000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mDurationView.setText(String.format("%.1f Seconds", millisUntilFinished / 1000.0));
                    }

                    @Override
                    public void onFinish() {
                        ((Vibrator)mDurationView.getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500) ;
                        mDurationView.setText("Done");
                    }
                }.start();
            }
        });

        mDurationView.setText(mDuration + " Seconds");
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_static_core_exercise;
    }

}
