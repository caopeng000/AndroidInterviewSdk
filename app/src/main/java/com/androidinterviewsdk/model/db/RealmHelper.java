package com.androidinterviewsdk.model.db;


import com.androidinterviewsdk.model.bean.SecondCategory;
import com.androidinterviewsdk.model.bean.StairCategory;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Description: RealmHelper
 * Creator: yxc
 * date: 2016/9/21 17:46
 */

public class RealmHelper {

    public static final String DB_NAME = "interview.realm";
    private Realm mRealm;
    private static RealmHelper instance;

    private RealmHelper() {
    }

    public static RealmHelper getInstance() {
        if (instance == null) {
            synchronized (RealmHelper.class) {
                if (instance == null)
                    instance = new RealmHelper();
            }
        }
        return instance;
    }


    protected Realm getRealm() {
        if (mRealm == null || mRealm.isClosed())
            mRealm = Realm.getDefaultInstance();
        return mRealm;
    }
    //--------------------------------------------------一级分类相关----------------------------------------------------

    public void insertStairCategory(StairCategory bean) {
        getRealm().beginTransaction();
        getRealm().copyToRealm(bean);
        getRealm().commitTransaction();
    }

    public boolean queryStairCategoryId(int id) {
        RealmResults<StairCategory> results = getRealm().where(StairCategory.class).findAll();
        for (StairCategory item : results) {
            if (item.getId() == (id)) {
                return true;
            }
        }
        return false;
    }

    public List<StairCategory> getStairCategoryList() {
        //使用findAllSort ,先findAll再result.sort排序
        RealmResults<StairCategory> results = getRealm().where(StairCategory.class).findAll();
        return getRealm().copyFromRealm(results);
    }


    public void deleteStairCategory(int id) {
        StairCategory data = getRealm().where(StairCategory.class).equalTo("id", id).findFirst();
        getRealm().beginTransaction();
        data.deleteFromRealm();
        getRealm().commitTransaction();
    }

    public void deleteAllStairCategory() {
        getRealm().beginTransaction();
        getRealm().delete(StairCategory.class);
        getRealm().commitTransaction();
    }

    //--------------------------------------------------二级分类相关----------------------------------------------------

    public void insertSecondCategory(SecondCategory bean) {
        getRealm().beginTransaction();
        getRealm().copyToRealm(bean);
        getRealm().commitTransaction();
    }


    public boolean querySecondCategoryId(int id) {
        RealmResults<SecondCategory> results = getRealm().where(SecondCategory.class).findAll();
        for (SecondCategory item : results) {
            if (item.getId() == (id)) {
                return true;
            }
        }
        return false;
    }


    public List<SecondCategory> getSecondCategoryList() {
        //使用findAllSort ,先findAll再result.sort排序
        RealmResults<SecondCategory> results = getRealm().where(SecondCategory.class).findAll();
        return getRealm().copyFromRealm(results);
    }

    public void deleteSecondCategory(int id) {
        SecondCategory data = getRealm().where(SecondCategory.class).equalTo("id", String.valueOf(id)).findFirst();
        getRealm().beginTransaction();
        data.deleteFromRealm();
        getRealm().commitTransaction();
    }


}
