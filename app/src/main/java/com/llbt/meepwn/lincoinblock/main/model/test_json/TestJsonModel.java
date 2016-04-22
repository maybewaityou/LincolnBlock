package com.llbt.meepwn.lincoinblock.main.model.test_json;

import android.databinding.ObservableField;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser;

import java.util.ArrayList;
import java.util.List;

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
    private ObservableField<JSONObject> mDog = new ObservableField<>();
    private ObservableField<TestInnerJsonModel> dogModel = new ObservableField<>();
    private ObservableField<JSONArray> mBooks = new ObservableField<>();
    private List<ObservableField<TestInnerListJsonModel>> bookModels = new ArrayList<>();

    public static TestJsonModel initWithJsonString(String jsonString) {
        TestJsonModel model = JsonParser.<TestJsonModel>parse(jsonString, TestJsonModel.class);
        TestInnerJsonModel innerModel = TestInnerJsonModel.initWithJsonString(model.getmDog().get().toString());
        model.getDogModel().set(innerModel);
        model.bookModels = JsonParser.<TestInnerListJsonModel>parseArray(model.getmBooks().get().toString(), TestInnerListJsonModel.class);
        return model;
    }

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

    public ObservableField<TestInnerJsonModel> getDogModel() {
        return dogModel;
    }

    public void setDogModel(ObservableField<TestInnerJsonModel> dogModel) {
        this.dogModel = dogModel;
    }

    public ObservableField<JSONArray> getmBooks() {
        return mBooks;
    }

    public void setmBooks(ObservableField<JSONArray> mBooks) {
        this.mBooks = mBooks;
    }

    public List<ObservableField<TestInnerListJsonModel>> getBookModels() {
        return bookModels;
    }

    public void setBookModels(List<ObservableField<TestInnerListJsonModel>> bookModels) {
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
