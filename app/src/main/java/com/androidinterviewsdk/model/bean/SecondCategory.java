package com.androidinterviewsdk.model.bean;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * 二级分类
 */
public class SecondCategory extends RealmObject implements Serializable {
    private int id;
    private int stariId;
    private String name;
    private String extraData;

    public int getStariId() {
        return stariId;
    }

    public void setStariId(int stariId) {
        this.stariId = stariId;
    }


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
