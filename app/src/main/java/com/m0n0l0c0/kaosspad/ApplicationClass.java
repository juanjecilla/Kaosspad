package com.m0n0l0c0.kaosspad;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.m0n0l0c0.kaosspad.dagger.DaggerModule;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by juanje on 14/10/17.
 */

public class ApplicationClass extends Application {

    // The Dagger ObjectGraph
    private ObjectGraph objectGraph;

    private static ApplicationClass instance;

    @Override
    public void onCreate() {
        super.onCreate();

        new Picasso.Builder(this).downloader(new OkHttpDownloader(this, Integer.MAX_VALUE)).build();

        instance = this;

        // Configure the graph for dagger
        objectGraph = ObjectGraph.create(getModules().toArray());

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

    protected List<DaggerModule> getModules() {
        return Arrays.asList(
                new DaggerModule(this)
        );
    }

    public static void injectMember(Object object) {
        instance.objectGraph.inject(object);
    }
}
