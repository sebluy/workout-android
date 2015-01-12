package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader; import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by sebluy on 12/22/14.
 * Refactor with other JSON serializer
 */
public class LiftingExerciseJSONSerializer {

    private Context mContext ;
    private File mFile ;
    private HashMap<String, CalisthenicExerciseType> mTypes ;

    public LiftingExerciseJSONSerializer(Context c) {
        mFile = new File(c.getFilesDir(), "upper_lifting_exercises.json");
        mContext = c ;
    }

    public HashMap<String, LiftingExercise> getTypes() throws JSONException, IOException {
        HashMap<String, LiftingExercise> exercises = new HashMap<String, LiftingExercise>() ;
        BufferedReader reader = null ;

        try {

            InputStream in = null ;
            if (mFile.exists()) {
                in = new FileInputStream(mFile);
            } else {
                in = mContext.getResources().openRawResource(R.raw.upper_lifting_exercises) ;
            }
            reader = new BufferedReader(new InputStreamReader(in)) ;
            StringBuilder jsonString = new StringBuilder() ;
            String line = null ;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line) ;
            }
            JSONObject object = (JSONObject) new JSONTokener(jsonString.toString()).nextValue() ;
            Iterator<String> keyIterator = object.keys() ;
            while (keyIterator.hasNext()) {
                String key = keyIterator.next() ;
                exercises.put(key, new LiftingExercise(key, object.getJSONObject(key))) ;
            }

        } catch (FileNotFoundException e) {
        } finally {
            if (reader != null) {
                reader.close() ;
            }
        }
        return exercises ;
    }

}

