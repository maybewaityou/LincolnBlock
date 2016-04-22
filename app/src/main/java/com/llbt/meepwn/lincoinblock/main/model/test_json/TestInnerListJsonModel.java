package com.llbt.meepwn.lincoinblock.main.model.test_json;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincoinblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/23 上午6:15
 * desc:
 */
public class TestInnerListJsonModel extends BaseModel {

    private ObservableField<String> mBookName = new ObservableField<>();
    private ObservableField<String> mPrice = new ObservableField<>();

    public static TestInnerListJsonModel initWithJsonString(String jsonString) {
        return JsonParser.<TestInnerListJsonModel>parse(jsonString, TestInnerListJsonModel.class);
    }

    public ObservableField<String> getmBookName() {
        return mBookName;
    }

    public void setmBookName(ObservableField<String> mBookName) {
        this.mBookName = mBookName;
    }

    public ObservableField<String> getmPrice() {
        return mPrice;
    }

    public void setmPrice(ObservableField<String> mPrice) {
        this.mPrice = mPrice;
    }

    @Override
    public String toString() {
        return "{" +
                "\"mBookName\" : " + "\"" + mBookName.get() + "\"" +
                ", \"mPrice\" : " + "\"" + mPrice.get() + "\"" +
                "}";
    }
}
