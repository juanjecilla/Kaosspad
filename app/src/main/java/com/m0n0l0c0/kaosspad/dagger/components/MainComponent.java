package com.m0n0l0c0.kaosspad.dagger.components;

import com.m0n0l0c0.kaosspad.ApplicationClass;
import com.m0n0l0c0.kaosspad.activities.MainActivity;
import com.m0n0l0c0.kaosspad.base.BaseActivity;
import com.m0n0l0c0.kaosspad.base.BaseFragment;
import com.m0n0l0c0.kaosspad.dagger.MainModule;
import com.m0n0l0c0.kaosspad.preferences.PreferencesManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by juanje on 26/11/17.
 */

@Singleton
@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(ApplicationClass app);

    void inject(MainActivity activity);

    void inject(BaseActivity base);
    void inject(BaseFragment base);

    void inject(PreferencesManager preferencesManager);
}
