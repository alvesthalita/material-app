package com.example.myapplication.core.web.servicesoffline;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class LoadOffline {

    private Context context;

    public LoadOffline(Context context){
        this.context = context;
    }

    public String loadJSONFromAsset() {
        String json = null;

        try {
            InputStream is = Objects.requireNonNull(context).getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
