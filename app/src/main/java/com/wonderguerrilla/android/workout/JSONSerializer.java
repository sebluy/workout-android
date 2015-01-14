package com.wonderguerrilla.android.workout;

import android.content.Context;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

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
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by sebluy on 12/22/14.
 */
public class JSONSerializer {

    private File mFile ;

    public JSONSerializer(Context context, String filename, int resourceId)  {
        mFile = new File(context.getFilesDir(), filename) ;
    }

    public JSONObject get() {
        StringBuilder jsonString = new StringBuilder() ;
        String line = null ;
        try {
            InputStream inputStream ;
            inputStream = new FileInputStream(mFile);
//          inputStream = mContext.getResources().openRawResource(mResourceId);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) ;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            return (JSONObject) new JSONTokener(jsonString.toString()).nextValue() ;
        } catch (Exception e) {
            return null ;
        }
    }

    public void put(JSONObject object) {
        try {
            OutputStream outputStream = new FileOutputStream(mFile) ;
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(object.toString());
            writer.close() ;
        } catch (IOException e) {}
    }

}

