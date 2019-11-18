package com.example.myapplication.core.web.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.core.web.entities.MaterialResult;
import com.example.myapplication.interfaces.OnValidateUserEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;

public class ServiceMaterial {

    private Context context;
    private RequestQueue queue;
    private OnValidateUserEventListener validateUserListener;
    private MaterialResult[] materialResults;

    public ServiceMaterial(Context context){
        this.context = context;
    }

    public void loadOnline(){
        queue = Volley.newRequestQueue(context);
        String url = "https://raw.githubusercontent.com/myfreecomm/desafio-mobile-android/master/api/data.json";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new com.android.volley.Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            String data = response.toString();
                            materialResults = new Gson().fromJson(data, MaterialResult[].class);
                            validateUserListener.onValidateRequestSuccess(materialResults);
                        } catch(Exception error){
                            error.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR RESPONSE: ", error.getMessage());
                        validateUserListener.onValidateRequestFail(error.getMessage());
                    }
                });

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES+1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(jsonObjectRequest);
    }

    public void setOnValidateRequestEventListener(OnValidateUserEventListener listener){
        validateUserListener = listener;
    }
}
