package com.llbt.meepwn.lincolnblock.main.model.test_json;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/6/28 下午1:35
 * desc:
 */
public class BookModel extends Model {

    private ObservableField<String> bookName = new ObservableField<>();
    private ObservableField<String> price = new ObservableField<>();

    public ObservableField<String> getBookName() {
        return bookName;
    }

    public void setBookName(ObservableField<String> bookName) {
        this.bookName = bookName;
    }

    public ObservableField<String> getPrice() {
        return price;
    }

    public void setPrice(ObservableField<String> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"bookName\" : " + "\"" + bookName.get() + "\"" +
                ", \"price\" : " + "\"" + price.get() + "\"" +
                "}";
    }
}
