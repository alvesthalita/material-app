package com.example.myapplication.ui.fragment.generic;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;

/**
 * Created by Thalita on 06/06/19.
 */

public abstract class GenericFragment extends Fragment {

    private int layoutId;
    private int titleId;
    private View v;

    public GenericFragment(int layoutId, int titleId) {
        this.layoutId = layoutId;
        this.titleId = titleId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(layoutId, container, false);

        if (getActivity() != null) {
            getActivity().setTitle(getString(titleId));
        }

        startMethods();
        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void startMethods() {
        getObjects();
        ButterKnife.bind(this, v);
        setObjects();
    }

    public void inflateMenu(int layoutMenu, Menu menu) {
        if (getActivity() != null) {
            getActivity().getMenuInflater().inflate(layoutMenu, menu);
        }
    }

    public abstract void getObjects();

    public abstract void setObjects();

    public View getView() {
        return v;
    }
}
