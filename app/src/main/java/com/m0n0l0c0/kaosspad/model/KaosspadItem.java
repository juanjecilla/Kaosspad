package com.m0n0l0c0.kaosspad.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;

/**
 * Created by juanje on 26/11/17.
 */

public class KaosspadItem extends RealmObject implements Parcelable {

    private String uid;
    private String name;
    private String filePath;

    public KaosspadItem(){
    }

    public KaosspadItem(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.name);
        dest.writeString(this.filePath);
    }

    protected KaosspadItem(Parcel in) {
        this.uid = in.readString();
        this.name = in.readString();
        this.filePath = in.readString();
    }

    public static final Creator<KaosspadItem> CREATOR = new Creator<KaosspadItem>() {
        @Override
        public KaosspadItem createFromParcel(Parcel source) {
            return new KaosspadItem(source);
        }

        @Override
        public KaosspadItem[] newArray(int size) {
            return new KaosspadItem[size];
        }
    };
}
