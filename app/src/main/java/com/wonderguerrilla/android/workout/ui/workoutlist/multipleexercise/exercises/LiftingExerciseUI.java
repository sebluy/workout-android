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
public class LiftingExerciseUI extends ExerciseUI {

    private LiftingExercise mExercise ;

    public LiftingExerciseUI(Exercise exercise) {
        super(exercise) ;
        mExercise = (LiftingExercise)exercise ;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_lifting_exercise ;
    }

    @Override
    public void fillLayout(View view) {
       super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        EditText repetitions = (EditText)view.findViewById(R.id.edit_repetitions) ;
        repetitions.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String string = s.toString() ;
                if (!string.equals("")) {
                    mExercise.setRepetitions(Integer.parseInt(string)) ;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        weight.setText(mExercise.getWeight() + " " + mExercise.getUnit()) ;
        repetitions.setText(String.valueOf(mExercise.getRepetitions())) ;

    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_lifting_exercise ;
    }

    @Override
    public void fillListItemLayout(View view) {
        super.fillLayout(view) ;

        TextView weight = (TextView)view.findViewById(R.id.weight) ;
        weight.setText(String.valueOf(mExercise.getWeight() + " " + mExercise.getUnit())) ;

        TextView repetitions = (TextView)view.findViewById(R.id.repetitions) ;
        repetitions.setText(String.valueOf(mExercise.getRepetitions() + " Repetitions")) ;
    }

}
