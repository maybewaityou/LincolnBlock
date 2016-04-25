package com.llbt.meepwn.lincoinblock.main;

/**
 * package: com.llbt.meepwn.lincoinblock.main
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/25 上午11:25
 * desc:
 */
public class Constant {
    // =============================== 证书相关 start =====================================
    // note: 下面两种属性互斥 或者 都为false
    /** 不验证书(接受所有证书) */
    public static final boolean NETWORK_ALLOW_ALL_CERTIFICATES = true;
    /** 接受自签名证书 */
    public static final boolean NETWORK_ALLOW_CUSTOM_CERTIFICATES = false;
    // ================================ 证书相关 end ====================================


    // =============================== 接口相关 start =====================================
    public static final String BASE_URL = "";
    // =============================== 接口相关 end =====================================
}
