package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser

/**
 * package: com.llbt.meepwn.lincoinblock
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/5 下午5:39
 * desc:
 */
class TestItemModel : BaseModel() {

    var text = ObservableField<String>()

    companion object {
        fun initWithJsonString(jsonString: String?): TestItemModel? {
            return JsonParser.parse<TestItemModel>(jsonString, TestItemModel::class.java)
        }
    }

    override fun toString(): String {
        return "{\"text\" : \"${text.get()}\"}"
    }

}
