package com.llbt.meepwn.lincolnblock.main.model.test_json;

import com.llbt.meepwn.lincolnblock.framework.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model.test_json
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/6/28 下午12:56
 * desc:
 */
public class JsonModel extends Model {

    private String name;
    private String age;
    private String lastName;
    private Dog dog;
    private List<Book> books = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\" : " + "\"" + name + "\"" +
                ", \"age\" : " + "\"" + age + "\"" +
                ", \"lastName\" : " + "\"" + lastName + "\"" +
                ", \"dog\" : " + "\"" + dog + "\"" +
                ", \"books\" : " + "\"" + books + "\"" +
                "}";
    }
}
