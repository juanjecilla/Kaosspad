package com.m0n0l0c0.kaosspad;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.m0n0l0c0.kaosspad.dagger.MainModule;
import com.m0n0l0c0.kaosspad.dagger.components.DaggerMainComponent;
import com.m0n0l0c0.kaosspad.dagger.components.MainComponent;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by juanje on 14/10/17.
 */

public class ApplicationClass extends Application {

    // The Dagger ObjectGraph
    private MainComponent mainComponent;

    private static ApplicationClass instance;

    @Override
    public void onCreate() {
        super.onCreate();

        new Picasso.Builder(this).downloader(new OkHttpDownloader(this, Integer.MAX_VALUE)).build();

        instance = this;

        mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build();

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(config);

//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Raleway-Regular.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build()
//        );
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public MainComponent getComponent() {
        return mainComponent;
    }
}
