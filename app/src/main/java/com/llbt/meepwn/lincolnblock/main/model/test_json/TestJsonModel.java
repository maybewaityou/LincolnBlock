package com.llbt.meepwn.lincolnblock.main.model.test_json;

import android.databinding.ObservableField;

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

    private ObservableField<String> name = new ObservableField<>();
    private ObservableField<String> age = new ObservableField<>();
    private ObservableField<String> lastName = new ObservableField<>();
    private ObservableField<Dog> dogModel = new ObservableField<>();
    private List<ObservableField<Book>> bookModels = new ArrayList<>();

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

    public ObservableField<String> getLastName() {
        return lastName;
    }

    public void setLastName(ObservableField<String> lastName) {
        this.lastName = lastName;
    }

    public ObservableField<Dog> getDogModel() {
        return dogModel;
    }

    public void setDogModel(ObservableField<Dog> dogModel) {
        this.dogModel = dogModel;
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
                "\"name\" : " + "\"" + name + "\"" +
                ", \"age\" : " + "\"" + age + "\"" +
                ", \"lastName\" : " + "\"" + lastName + "\"" +
                ", \"dogModel\" : " + "\"" + dogModel + "\"" +
                ", \"bookModels\" : " + "\"" + bookModels + "\"" +
                "}";
    }
}
