package com.wonderguerrilla.android.workout;

import android.content.Context;

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
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by sebluy on 12/22/14.
 */
public class JSONReader {

    private InputStream mInputStream ;

    public JSONReader(String filename)  {
        File file = new File(WorkoutApplication.getContext().getFilesDir(), filename) ;
        try {
            mInputStream = new FileInputStream(file) ;
        } catch (Exception e) {}
    }

    public JSONReader(int resourceID)  {
        mInputStream = WorkoutApplication.getContext().getResources().openRawResource(resourceID) ;
    }

    public JSONObject get() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(mInputStream)) ;
        StringBuilder jsonString = new StringBuilder() ;
        String line = null ;
        try {
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            return (JSONObject) new JSONTokener(jsonString.toString()).nextValue() ;
        } catch (Exception e) {
            return null ;
        }
    }

}

