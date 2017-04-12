package com.androidinterviewsdk.model.bean;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * 一级分类
 */
public class StairCategory extends RealmObject implements Serializable {
    private int id;
    private String name;
    private String extraData;

    public String getExtraData() {
        return extraData;
    }

    public void setExtraData(String extraData) {
        this.extraData = extraData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
