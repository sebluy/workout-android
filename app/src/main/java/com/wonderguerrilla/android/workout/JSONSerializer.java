package com.wonderguerrilla.android.workout;

import android.content.Context;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
    private JSONObject mObject ;

    public JSONSerializer(Context context, String filename)  {
        mFile = new File(context.getFilesDir(), filename) ;
    }

    public JSONSerializer(Context context, String filename, int rawId)  {
        mFile = new File(context.getFilesDir(), filename) ;
        if (mFile.length() == 0) {
            JSONReader reader = new JSONReader(context, rawId) ;
            put(reader.get()) ;
        }
    }

    public JSONObject get() {
        if (mObject == null) {
            mObject = read();
        }
        return mObject ;
    }

    public void put(JSONObject object) {
        mObject = object ;
        write(object) ;
    }

    public JSONObject read() {
        StringBuilder jsonString = new StringBuilder() ;
        String line ;
        try {
            InputStream inputStream ;
            inputStream = new FileInputStream(mFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) ;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            return (JSONObject) new JSONTokener(jsonString.toString()).nextValue() ;
        } catch (Exception e) {
            return null ;
        }
    }

    public void write(JSONObject object) {
        try {
            OutputStream outputStream = new FileOutputStream(mFile) ;
            Writer writer = new OutputStreamWriter(outputStream);
            writer.write(object.toString());
            writer.close() ;
        } catch (IOException e) {}
    }

}

