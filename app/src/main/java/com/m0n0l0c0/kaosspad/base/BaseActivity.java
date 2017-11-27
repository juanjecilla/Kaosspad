package com.m0n0l0c0.kaosspad.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.m0n0l0c0.kaosspad.ApplicationClass;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by juanje on 14/10/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ApplicationClass)getApplication()).getComponent().inject(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
