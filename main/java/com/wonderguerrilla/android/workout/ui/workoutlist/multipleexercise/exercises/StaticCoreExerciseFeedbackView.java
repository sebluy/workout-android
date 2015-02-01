package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExercise;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExerciseFeedback;

/**
 * Created by sebluy on 1/19/15.
 */
public class StaticCoreExerciseFeedbackView {

    private int mPosition;
    private StaticCoreExercise mExercise ;
    private StaticCoreExerciseFeedback mFeedback ;

    public StaticCoreExerciseFeedbackView(StaticCoreExerciseFeedback feedback) {
        mFeedback = feedback ;
        mExercise = feedback.getExercise() ;
    }

    public int getLayout() {
        return R.layout.fragment_static_core_exercise_feedback ;
    }

    public void fillLayout(View view) {
        TextView name = (TextView)view.findViewById(R.id.name) ;
        name.setText(mExercise.getName()) ;

        TextView duration = (TextView)view.findViewById(R.id.duration) ;
        duration.setText(String.valueOf(mExercise.getDuration())) ;

        EditText difficulty = (EditText)view.findViewById(R.id.edit_difficulty) ;
        difficulty.setText(String.valueOf(mFeedback.getDifficulty())) ;
        difficulty.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString();
                if (!string.equals("")) {
                    mFeedback.setDifficulty(Integer.parseInt(string));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        }) ;
    }

}
