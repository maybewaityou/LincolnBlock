package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/21 上午8:37
 * desc:
 */
class TestFragmentModel : BaseModel() {
    var name = ObservableField<String>()
    var age = ObservableField<String>()

    companion object {
        fun initWithJsonString(jsonString: String?): TestFragmentModel? {
            return JsonParser.parse<TestFragmentModel>(jsonString, TestFragmentModel::class.java)
        }
    }

    override fun toString(): String {
        return "{\"name\" : \"${name.get()}\", \"age\" : \"${age.get()}\"}"
    }
}
