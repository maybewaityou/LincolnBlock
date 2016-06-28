package com.llbt.meepwn.lincolnblock.main.model.test_json;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/23 上午6:15
 * desc:
 */
public class Book extends Model {

    private String bookName;
    private String price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"bookName\" : " + "\"" + bookName + "\"" +
                ", \"price\" : " + "\"" + price + "\"" +
                "}";
    }
}
