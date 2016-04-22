package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/5 下午5:39
 * desc:
 */
class TestItemModel : BaseModel<TestItemModel>() {

    var text = ObservableField<String>()

    override fun initWithJsonString(jsonString: String?): TestItemModel? {
        return TestItemModel()
    }

    override fun toString(): String {
        return "{\"text\" : \"${text.get()}\"}"
    }

}
