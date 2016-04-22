package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午8:37
 * desc:
 */
class TestFragmentModel : BaseModel<TestFragmentModel>() {
    var name = ObservableField<String>()
    var age = ObservableField<String>()

    override fun initWithJsonString(jsonString: String?): TestFragmentModel? {
        return TestFragmentModel()
    }

    override fun toString(): String {
        return "{\"name\" : \"${name.get()}\", \"age\" : \"${age.get()}\"}"
    }
}
