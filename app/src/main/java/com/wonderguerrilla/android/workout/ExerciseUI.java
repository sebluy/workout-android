package com.wonderguerrilla.android.workout;

import android.view.View;
import android.widget.TextView;

import com.wonderguerrilla.android.workout.workout.Exercise;
import com.wonderguerrilla.android.workout.workout.calisthenic.CalisthenicExercise;
import com.wonderguerrilla.android.workout.workout.lifting.LiftingExercise;
import com.wonderguerrilla.android.workout.workout.staticcore.StaticCoreExercise;

/**
 * Created by sebluy on 1/19/15.
 */
public class ExerciseUI {

    public static ExerciseUI get(Exercise exercise) {
        if (exercise.getClass() == LiftingExercise.class) {
            return new LiftingExerciseUI(exercise);
        } else if (exercise.getClass() == StaticCoreExercise.class) {
            return new StaticCoreExerciseUI(exercise) ;
        } else if (exercise.getClass() == CalisthenicExercise.class) {
            return new CalisthenicExerciseUI(exercise) ;
        } else {
            return new ExerciseUI(exercise);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    private Exercise mExercise ;

    public ExerciseUI(Exercise exercise) {
        mExercise = exercise ;
    }

    public int getLayout() {
        return R.layout.fragment_exercise ;
    }

    public void fillLayout(View view) {
        TextView name = (TextView)view.findViewById(R.id.name) ;
        name.setText(mExercise.getName()) ;
    }

    public int getListItemLayout() {
        return R.layout.list_item_exercise ;
    }

    public void fillListItemLayout(View convertView) {
        fillLayout(convertView) ;
    }

}
