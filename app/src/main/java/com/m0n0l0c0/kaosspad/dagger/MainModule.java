package com.m0n0l0c0.kaosspad.dagger;

import android.app.Application;
import android.content.Context;

import com.m0n0l0c0.kaosspad.preferences.PreferencesManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by juanje on 26/11/17.
 */

@Module
public class MainModule {
    private Application applicationClass;

    public MainModule(Application applicationClass) {
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

    @Provides
    @Singleton
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

//    @Provides
//    @Singleton
//    LocalDatabaseUtils provideLocalDatabaseUtils(Context context){
//        return new LocalDatabaseUtils(context);
//    }
}
