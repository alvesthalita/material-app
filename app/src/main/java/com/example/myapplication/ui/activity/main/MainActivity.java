package com.example.myapplication.ui.activity.main;

import com.example.myapplication.R;
import com.example.myapplication.ui.activity.generic.GenericActivity;
import com.example.myapplication.ui.fragment.materiallist.MaterialListFragment;

import butterknife.ButterKnife;

public class MainActivity extends GenericActivity {

    @Override
    public void setLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void getObjects() {

    }

    @Override
    public void setObjects() {
        replaceFragment(new MaterialListFragment());
    }
}
