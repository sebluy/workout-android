package com.wonderguerrilla.android.workout;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicExercise;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class CalisthenicExerciseUI extends ExerciseUI {

    private CalisthenicExercise mExercise ;

    public CalisthenicExerciseUI(Exercise exercise) {
        super(exercise) ;
        mExercise = (CalisthenicExercise)exercise ;
    }
    @Override
    public int getLayout() {
        return R.layout.fragment_calisthenic_exercise ;
    }

    @Override
    public void fillLayout(View view) {
        super.fillLayout(view) ;
        TextView repetitions = (TextView)view.findViewById(R.id.repetitions) ;
        repetitions.setText(mExercise.getRepetitions() + " Repetitions") ;
    }

    @Override
    public int getListItemLayout() {
        return R.layout.list_item_calisthenic_exercise ;
    }

    @Override
    public void fillListItemLayout(View view) {
        fillLayout(view) ;
    }

}
