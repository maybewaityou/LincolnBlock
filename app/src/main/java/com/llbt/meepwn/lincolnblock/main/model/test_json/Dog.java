package com.llbt.meepwn.lincolnblock.main.model.test_json;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午4:16
 * desc:
 */
public class Dog extends Model {

    private String dogName;
    private String age;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "\"dogName\" : " + "\"" + dogName + "\"" +
                ", \"age\" : " + "\"" + age + "\"" +
                "}";
    }
}
