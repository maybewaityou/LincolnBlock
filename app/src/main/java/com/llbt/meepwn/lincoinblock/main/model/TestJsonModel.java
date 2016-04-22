package com.llbt.meepwn.lincoinblock.main.model;

import android.databinding.ObservableField;

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午1:25
 * desc:

 */
public class TestJsonModel {

    private ObservableField<String> name;
    private ObservableField<String> age;

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }

    public ObservableField<String> getAge() {
        return age;
    }

    public void setAge(ObservableField<String> age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\" : " + "\"" + name + "\"" +
                ", \"age\" : " + "\"" + age + "\"" +
                "}";
    }
}
