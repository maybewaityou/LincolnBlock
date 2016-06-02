package com.llbt.meepwn.lincolnblock.main.service;

import android.content.Context;
import android.content.Intent;

import com.llbt.meepwn.lincolnblock.framework.Service;
import com.llbt.meepwn.lincolnblock.main.data_model.UserDataModel;

/**
 * package: com.llbt.meepwn.lincolnblock.main.service
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/13 下午1:02
 * desc:
 */
public class UserService extends Service<UserDataModel> {

    public UserService(Context context) {
        super(context);
    }

    @Override
    public void pushActivityWithDataModel(UserDataModel dataModel, Class clazz) {
        Intent intent = new Intent(context.get(), clazz);
        context.get().startActivity(intent);
    }
}
