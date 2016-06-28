package com.llbt.meepwn.lincolnblock.framework.types;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午6:56
 * desc:
 */
public interface ModelType {

    // 解析Json之后,clazz -> targetClazz
    Model mapToTargetModel(Class clazz, Class targetClazz);
}
