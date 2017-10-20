package com.m0n0l0c0.kaosspad.preferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by juanje on 14/10/17.
 */

public class PreferencesManager {
    public SharedPreferences settings;
    public SharedPreferences.Editor settings_editor;
    public final String PREFS_NAME = "SharedPreferences";

    @SuppressLint("CommitPrefEdits")
    public PreferencesManager(Context context) {
        // Initialize SharedPrefences and its editor
        settings = context.getSharedPreferences(PREFS_NAME, 0);
        settings_editor = settings.edit();
    }

    public void setUserToken(String userToken){
        settings_editor.putString("userToken", userToken);
        settings_editor.commit();
    }

    public String getUserToken(){
        return settings.getString("userToken", "");
    }

    public void setCountryId(int countryId){
        settings_editor.putInt("countryId", countryId);
        settings_editor.commit();
    }

    public int getCountryId(){
        return settings.getInt("countryId", 0);
    }
}

