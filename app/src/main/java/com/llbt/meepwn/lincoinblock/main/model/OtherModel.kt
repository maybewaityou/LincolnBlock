package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/6 下午5:02
 * desc:
 */
class OtherModel : BaseModel() {

    var name = ObservableField<String>()
    var age = ObservableField<String>()

    override fun toString(): String {
        return "{\"name\" : \"${name.get()}\", \"age\" : \"${age.get()}\"}"
    }
}
