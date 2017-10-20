package com.m0n0l0c0.kaosspad.dagger;

import android.content.Context;

import com.m0n0l0c0.kaosspad.ApplicationClass;
import com.m0n0l0c0.kaosspad.activities.MainActivity;
import com.m0n0l0c0.kaosspad.base.BaseActivity;
import com.m0n0l0c0.kaosspad.base.BaseFragment;
import com.m0n0l0c0.kaosspad.preferences.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by juanje on 14/10/17.
 */

@Module(
        injects =
                {
                        // Activities
                        MainActivity.class,
                        // Fragments

                        // Base
                        BaseActivity.class,
                        BaseFragment.class,
                },
        library = true,
        complete = false
)
public class DaggerModule {

    private ApplicationClass applicationClass;

    public DaggerModule(ApplicationClass applicationClass) {
        this.applicationClass = applicationClass;
    }

    /**
     * Allow the application context to be injected.
     */
    @Provides
    @Singleton
    Context provideApplicationContext() {
        return applicationClass;
    }

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(Context context) {
        return new PreferencesManager(context);
    }
}
