package com.llbt.meepwn.lincoinblock.main.model;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午1:25
 * desc:
 */
public class TestJsonModel extends BaseModel {

    private ObservableField<String> mName = new ObservableField<>();
    private ObservableField<String> mAge = new ObservableField<>();
    private ObservableField<String> mLastName = new ObservableField<>();

    public ObservableField<String> getmName() {
        return mName;
    }

    public void setmName(ObservableField<String> mName) {
        this.mName = mName;
    }

    public ObservableField<String> getmAge() {
        return mAge;
    }

    public void setmAge(ObservableField<String> mAge) {
        this.mAge = mAge;
    }

    public ObservableField<String> getmLastName() {
        return mLastName;
    }

    public void setmLastName(ObservableField<String> mLastName) {
        this.mLastName = mLastName;
    }

    @Override
    public String toString() {
        return "{" +
                "\"mName\" : " + "\"" + mName.get() + "\"" +
                ", \"mAge\" : " + "\"" + mAge.get() + "\"" +
                ", \"mLastName\" : " + "\"" + mLastName.get() + "\"" +
                "}";
    }
}
