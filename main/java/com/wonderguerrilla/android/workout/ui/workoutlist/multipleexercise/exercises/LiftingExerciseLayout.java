package com.wonderguerrilla.android.workout.ui.workoutlist.multipleexercise.exercises;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.R;
import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class LiftingExerciseLayout extends ExerciseLayout {

    private LiftingExercise mExercise ;
    private EditText mPerformedRepetitions ;

    public LiftingExerciseLayout(Exercise exercise) {
        super(exercise) ; mExercise = (LiftingExercise)exercise ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View view) {
       super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        weight.setText(mExercise.getWeight()) ;

        TextView goalRepetitions = (TextView)view.findViewById(R.id.repetition_goal) ;
        goalRepetitions.setText(String.valueOf(mExercise.getRepetitionGoal())) ;

        mPerformedRepetitions = (EditText)view.findViewById(R.id.edit_performed_repetitions) ;
        mPerformedRepetitions.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                String string = s.toString() ;
                if (!string.equals("")) {
                    mExercise.setPerformedRepetitions(Integer.parseInt(string));
                }
            }
        }) ;

        mPerformedRepetitions.setText(String.valueOf(mExercise.getPerformedRepetitions())) ;

    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_lifting_exercise ;
    }

    @Override
    public void fillListItemLayout(View view) {
        super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        weight.setText(mExercise.getWeight()) ;

        TextView repetitions = (TextView)view.findViewById(R.id.performed_repetitions) ;

        repetitions.setText(mExercise.getRepetitionGoal() + " -> " + mExercise.getPerformedRepetitions() +
                " Repetitions") ;
    }

}
