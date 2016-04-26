package com.llbt.meepwn.lincoinblock.main.view_model;

import android.Manifest;
import android.databinding.ObservableField;
import android.view.View;

import com.llbt.meepwn.lincoinblock.R;
import com.llbt.meepwn.lincoinblock.framework.base.BaseViewModel;
import com.llbt.meepwn.lincoinblock.main.model.GitModel;
import com.llbt.meepwn.lincoinblock.main.model.UserModel;
import com.llbt.meepwn.lincoinblock.main.model.test_json.TestJsonModel;
import com.llbt.meepwn.lincoinblock.main.service.UserService;
import com.llbt.meepwn.lincoinblock.main.view.activity.OtherActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestActivity;
import com.llbt.meepwn.lincoinblock.main.view.activity.TestFragmentActivity;
import com.llbt.meepwn.lincoinblock.utils.network.Just;

import java.util.HashMap;

import rx.Observable;
import rx.functions.Action1;
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
            service.sendRequest("", Just.Method.GET, new HashMap<>(), TestJsonModel.class).subscribe(new Action1<TestJsonModel>() {
                @Override
                public void call(TestJsonModel model) {
                    System.out.println("== model ===>>>> " + model);
                }
            });
        } else if (view.getId() == R.id.networkButton) {
            // "https://kyfw.12306.cn/otn/",
            service.sendRequest("https://api.github.com", Just.Method.GET, new HashMap<>(), GitModel.class)
                .subscribe((Action1<GitModel>) gitModel -> {
                    System.out.println("=====>>>>> " + gitModel.getmCode_search_url());
                }, (Action1<Throwable>) throwable -> {
                    System.out.println("=====>>>>> " + throwable.getMessage());
                });
        } else if (view.getId() == R.id.permissionButton) {
            service.requestPermission(Manifest.permission.CAMERA)
                .subscribe(aBoolean -> {
                    System.out.println("=====>>>>> " + aBoolean);
            });
        } else {
            service.sendRequest("", Just.Method.GET, new HashMap<>(), UserModel.class).flatMap((Func1) user -> {
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
        return service.sendRequest("", Just.Method.GET, new HashMap<>(), UserModel.class).doOnNext(o -> {
            System.out.println("==== getToken >>>> " + o);
        });
    }

}
