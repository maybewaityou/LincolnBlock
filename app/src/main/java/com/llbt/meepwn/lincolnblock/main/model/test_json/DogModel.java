package com.llbt.meepwn.lincolnblock.main.model.test_json;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/6/28 下午1:34
 * desc:
 */
public class DogModel extends Model {

    private ObservableField<String> dogName = new ObservableField<>();
    private ObservableField<String> age = new ObservableField<>();

    public ObservableField<String> getDogName() {
        return dogName;
    }

    public void setDogName(ObservableField<String> dogName) {
        this.dogName = dogName;
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
                "\"dogName\" : " + "\"" + dogName.get() + "\"" +
                ", \"age\" : " + "\"" + age.get() + "\"" +
                "}";
    }
}
