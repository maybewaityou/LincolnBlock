package com.llbt.meepwn.lincolnblock.main.model.test_json;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.base.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/23 上午6:15
 * desc:
 */
public class Book extends Model {

    private ObservableField<String> mBookName = new ObservableField<>();
    private ObservableField<String> mPrice = new ObservableField<>();

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
