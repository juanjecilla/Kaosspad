package com.m0n0l0c0.kaosspad.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.m0n0l0c0.kaosspad.R;
import com.m0n0l0c0.kaosspad.base.BaseActivity;

import butterknife.ButterKnife;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

}
