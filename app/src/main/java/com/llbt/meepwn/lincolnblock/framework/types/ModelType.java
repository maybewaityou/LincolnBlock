package com.llbt.meepwn.lincolnblock.framework.types;

/**
 * package: com.llbt.meepwn.lincolnblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午6:56
 * desc:
 */
public interface ModelType {

    // 解析Json之后,生成attrs字典,将attrs字典赋值给Model的属性
    void setupData();
}
