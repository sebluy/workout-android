package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by sebluy on 12/22/14.
 */
public class CalisthenicExerciseTypeJSONSerializer {

    private Context mContext ;
    private File mFile ;
    private HashMap<String, CalisthenicExerciseType> mTypes ;

    public CalisthenicExerciseTypeJSONSerializer(Context c) {
        mFile = new File(c.getFilesDir(), "calisthenic_exercise_types.json");
        mContext = c ;
    }

    public HashMap<String, CalisthenicExerciseType> getTypes() throws JSONException, IOException {
        HashMap<String, CalisthenicExerciseType> types = new HashMap<String, CalisthenicExerciseType>() ;
        BufferedReader reader = null ;

        try {

            InputStream in = null ;
            if (mFile.exists()) {
                in = new FileInputStream(mFile);
            } else {
                in = mContext.getResources().openRawResource(R.raw.calisthenic_exercise_types) ;
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
                types.put(key, new CalisthenicExerciseType(object.getJSONObject(key))) ;
            }

        } catch (FileNotFoundException e) {
        } finally {
            if (reader != null) {
                reader.close() ;
            }
        }
        return types ;
    }

}

