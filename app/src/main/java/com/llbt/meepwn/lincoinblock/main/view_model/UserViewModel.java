package com.llbt.meepwn.lincoinblock.main.view_model;

import android.databinding.ObservableField;
import android.view.View;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;
import com.llbt.meepwn.lincoinblock.main.model.test_json.TestJsonModel;
import com.llbt.meepwn.lincoinblock.main.service.UserService;
import com.llbt.meepwn.lincoinblock.main.view.activity.OtherActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestFragmentActivity;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * package: com.llbt.meepwn.lincoinblock.main.view_model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午10:29
 * desc:
 */
@SuppressWarnings("unchecked")
public class UserViewModel extends BaseViewModel<UserModel, UserService> {

    public UserViewModel(UserService service, ObservableField<UserModel> model) {
        super(service, model);
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.otherButton) {
            service.pushActivityWithDataModel(null, OtherActivity.class);
        } else if (view.getId() == R.id.testButton) {
            service.pushActivityWithDataModel(null, TestActivity.class);
        } else if (view.getId() == R.id.fragmentButton) {
            service.pushActivityWithDataModel(null, TestFragmentActivity.class);
        } else if (view.getId() == R.id.jsonToModel) {
            String jsonString = "{\n" +
                    "    \"name\": \"MeePwn\",\n" +
                    "    \"age\": \"2333333\",\n" +
                    "    \"lastName\": \"Chunnan\",\n" +
                    "    \"dog\": {\n" +
                    "        \"dogName\": \"doge\",\n" +
                    "        \"age\": \"11\"\n" +
                    "    },\n" +
                    "    \"books\": [\n" +
                    "        {\n" +
                    "            \"bookName\": \"Swift\",\n" +
                    "            \"price\": \"¥65\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bookName\": \"Objective C\",\n" +
                    "            \"price\": \"¥45\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"bookName\": \"iOS\",\n" +
                    "            \"price\": \"¥85\"\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            TestJsonModel m = TestJsonModel.initWithJsonString(jsonString);
            System.out.println("====>>>> " + m);
        } else {
            service.sendRequest().flatMap((Func1) user -> {
                 // TODO 类型转换
                return getToken((UserModel) user);
            }).subscribe(userModel -> {
                 // TODO 解析JSON生成对象
                UserModel user = new UserModel();
                user.getLastName().set("王五===>>> ");
                model.set(user);
                 // TODO 类型转换
                System.out.println("==== subscribe >>>> " + userModel);
            });
        }
    }

    private Observable getToken(UserModel userModel) {
        service.sendRequest().subscribeOn(Schedulers.newThread());
        return service.sendRequest().doOnNext(o -> {
            System.out.println("==== getToken >>>> " + o);
        });
    }

}
