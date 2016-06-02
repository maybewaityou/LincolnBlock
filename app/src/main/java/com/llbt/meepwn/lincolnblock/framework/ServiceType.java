package com.llbt.meepwn.lincolnblock.framework;

import android.content.Context;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午11:13
 * desc:
 */
public interface ServiceType<DM extends DataModelType> extends NetworkService {

    Context getContext();

    void pushActivityWithDataModel(DM dataModel, Class clazz);

}
