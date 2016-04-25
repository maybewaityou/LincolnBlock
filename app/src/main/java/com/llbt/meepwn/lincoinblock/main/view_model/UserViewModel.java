package com.llbt.meepwn.lincoinblock.main.view_model;

import android.databinding.ObservableField;
import android.view.View;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.library.volley.Request;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.StringRequest;
import com.llbt.meepwn.lincoinblock.library.volley.toolbox.Volley;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;
import com.llbt.meepwn.lincoinblock.main.service.UserService;
import com.llbt.meepwn.lincoinblock.main.view.activity.OtherActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestFragmentActivity;

import java.util.HashMap;

import rx.Observable;
import rx.functions.Func1;

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
//            service.sendRequest("", new HashMap<>(), TestJsonModel.class).subscribe(new Action1<TestJsonModel>() {
//                @Override
//                public void call(TestJsonModel model) {
//                    System.out.println("== model ===>>>> " + model);
//                }
//            });
            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    "https://kyfw.12306.cn/otn/",
//                    "http://www.baidu.com/",
                    response -> System.out.println("==== response >>>> " + response),
                    error -> System.out.println("==== error >>>> " + error));
            Volley.newRequestQueue(service.getContext()).add(request);
        } else {
            service.sendRequest("", new HashMap<>(), UserModel.class).flatMap((Func1) user -> {
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
        return service.sendRequest("", new HashMap<>(), UserModel.class).doOnNext(o -> {
            System.out.println("==== getToken >>>> " + o);
        });
    }

}
