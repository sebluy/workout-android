package com.wonderguerrilla.android.workout.ui.workoutlist;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 1/19/15.
 */
public class StretchView extends TextView {

    private CountDownTimer mCountDownTimer ;
    private double mTimeLeft ;
    private double mDuration ;
    private boolean mStretching ;

    private String formatDuration(double duration) {
        return String.format("%.1f Seconds", duration) ;
    }

    public CountDownTimer getTimer() {
        return mCountDownTimer ;
    }

    public StretchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet) ;
        setOnClickListener(new TimerOnClickListener()) ;
    }

    class TimerOnClickListener implements OnClickListener {
        @Override
        public void onClick(View view) {
            mDuration = 15.0 ;
            mStretching = false ;
            if (mCountDownTimer != null) {
                mCountDownTimer.cancel();
            }
            mCountDownTimer = new VibrateTimer((long) (mDuration * 1000), 100) ;
            mCountDownTimer.start();
        }

        class VibrateTimer extends CountDownTimer {

            VibrateTimer(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval) ;
            }

            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeft = millisUntilFinished / 1000.0;
                StretchView.this.setText(formatDuration(mTimeLeft));
            }

            @Override
            public void onFinish() {
                StretchView.this.setText("Done");
                if (mStretching) {
                    long[] pattern = { 0, 500, 500, 500 } ;
                    ((Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(pattern, -1) ;
                    mDuration = 15.0 ;
                    mStretching = false ;
                } else {
                    ((Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500) ;
                    mDuration = 60.0 ;
                    mStretching = true ;
                }
                mCountDownTimer = new VibrateTimer((long) (mDuration * 1000), 100) ;
                mCountDownTimer.start() ;
            }

        }
    }
}
