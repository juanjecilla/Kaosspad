package com.m0n0l0c0.kaosspad.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.m0n0l0c0.kaosspad.ApplicationClass;

/**
 * Created by juanje on 14/10/17.
 */

public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationClass.injectMember(this);
    }
}
