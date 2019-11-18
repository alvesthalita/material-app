package com.example.myapplication.ui.activity.generic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.R;

public abstract class GenericActivity extends AppCompatActivity {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startMethods();
    }

    protected void startMethods() {
        fm = getSupportFragmentManager();
        setLayout();
        configActionBar();
        getObjects();
        setObjects();
    }

    private void configActionBar() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setElevation(0);
        }
    }

    public void configBackButton() {
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void startActivity(Class<?> activityType, Bundle bundle) {
        Intent intent = new Intent(getApplicationContext(), activityType);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        if (bundle != null) {
            intent.putExtras(bundle);
        }

        startActivity(intent);
    }

    public void hideTop(boolean fullScreen) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if(fullScreen) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void replaceFragment(Fragment fragment) {
        fm.popBackStackImmediate();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
        ft.replace(R.id.main_contentframe, fragment);
        ft.commit();
    }


    public void replaceFragment(Fragment fragment, int layout) {
        fm.popBackStackImmediate();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.enter_anim, R.anim.exit_anim);
        ft.replace(layout, fragment);
        ft.commit();
    }

    public void setHomeAsUp() {
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void setKeyboardVisibility(EditText editText, boolean visible) {
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null) {
            if (visible) {
                editText.requestFocus();
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            } else {
                editText.clearFocus();
                editText.setText("");
                imm.hideSoftInputFromWindow(editText.getRootView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    public abstract void setLayout();

    public abstract void getObjects();

    public abstract void setObjects();
}
