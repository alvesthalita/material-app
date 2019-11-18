package com.example.myapplication.ui.activity.splash;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.myapplication.R;
import com.example.myapplication.ui.activity.main.MainActivity;
import com.example.myapplication.ui.activity.generic.GenericActivity;

public class SplashActivity extends GenericActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setLayout() {
        hideTop(true);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public void getObjects() {
        // Do nothing
    }

    @Override
    public void setObjects() {
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startApp();
            }
        }.start();
    }

    private void startApp() {
        startActivity(MainActivity.class, null);
        finish();
    }
}
