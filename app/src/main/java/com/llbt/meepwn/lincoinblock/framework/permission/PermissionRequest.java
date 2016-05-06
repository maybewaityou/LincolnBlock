package com.llbt.meepwn.lincoinblock.framework.permission;

import com.tbruyelle.rxpermissions.Permission;

import rx.Observable;

/**
 * package: com.llbt.meepwn.lincoinblock.framework
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/25 下午1:10
 * desc: 权限请求
 */
public interface PermissionRequest {

    Observable<Boolean> requestPermission(String permission);

    Observable<Permission> requestMutablePermission(String ... permission);

}
