package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sebluy on 1/19/15.
 */
public class TimerView extends TextView {

    private boolean mIsReady = true ;
    private double mDuration ;
    private String mTimeLeft ;

    private String formatDuration(double duration) {
        return String.format("%.1f Seconds", duration) ;
    }

    public TimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet) ;
        setOnClickListener(new TimerOnClickListener()) ;
    }

    public void setDuration(double duration) {
        mDuration = duration ;
        setText(formatDuration(duration)) ;
    }

    class TimerOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (mIsReady) {
                mIsReady = false ;
                new CountDownTimer((long)mDuration * 1000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        double timeLeft = millisUntilFinished/1000.0 ;
                        mTimeLeft = formatDuration(timeLeft) ;
                        TimerView.this.setText(mTimeLeft) ;
                    }

                    @Override
                    public void onFinish() {
                        ((Vibrator)getContext().getSystemService(Context.VIBRATOR_SERVICE)).vibrate(500);
                        mTimeLeft = "Done" ;
                        TimerView.this.setText(mTimeLeft) ;
                    }
                }.start() ;
            }
        }
    }
}
