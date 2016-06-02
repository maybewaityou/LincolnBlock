package com.llbt.meepwn.lincolnblock.main.model.test_json;

import android.databinding.ObservableField;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.llbt.meepwn.lincolnblock.framework.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午1:25
 * desc:
 */
public class TestJsonModel extends Model {

    private ObservableField<String> mName = new ObservableField<>();
    private ObservableField<String> mAge = new ObservableField<>();
    private ObservableField<String> mLastName = new ObservableField<>();
    private ObservableField<JSONObject> mDog = new ObservableField<>();
    private ObservableField<Dog> dogModel = new ObservableField<>();
    private ObservableField<JSONArray> mBooks = new ObservableField<>();
    private List<ObservableField<Book>> bookModels = new ArrayList<>();

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

    public ObservableField<JSONObject> getmDog() {
        return mDog;
    }

    public void setmDog(ObservableField<JSONObject> mDog) {
        this.mDog = mDog;
    }

    public ObservableField<Dog> getDogModel() {
        return dogModel;
    }

    public void setDogModel(ObservableField<Dog> dogModel) {
        this.dogModel = dogModel;
    }

    public ObservableField<JSONArray> getmBooks() {
        return mBooks;
    }

    public void setmBooks(ObservableField<JSONArray> mBooks) {
        this.mBooks = mBooks;
    }

    public List<ObservableField<Book>> getBookModels() {
        return bookModels;
    }

    public void setBookModels(List<ObservableField<Book>> bookModels) {
        this.bookModels = bookModels;
    }

    @Override
    public String toString() {
        return "{" +
                "\"mName\" : " + "\"" + mName.get() + "\"" +
                ", \"mAge\" : " + "\"" + mAge.get() + "\"" +
                ", \"mLastName\" : " + "\"" + mLastName.get() + "\"" +
                ", \"mDog\" : " + "\"" + mDog.get() + "\"" +
                ", \"dogModel\" : " + "\"" + dogModel.get() + "\"" +
                ", \"mBooks\" : " + "\"" + mBooks.get() + "\"" +
                ", \"bookModels\" : " + "\"" + bookModels + "\"" +
                "}";
    }
}
