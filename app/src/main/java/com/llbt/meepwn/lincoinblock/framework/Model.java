package com.llbt.meepwn.lincoinblock.framework;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午6:56
 * desc:
 */
public interface Model {

    // 解析Json之后,生成attrs字典,将attrs字典赋值给Model的属性
    void setupData();
}
