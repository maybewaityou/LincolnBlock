package com.llbt.meepwn.lincoinblock.main.model

import android.databinding.ObservableField
import android.text.Editable
import android.text.TextWatcher
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 上午10:28
 * desc:
 */
class UserModel : BaseModel() {
    var lastName = ObservableField<String>("李四")
    var name: String? = "张三"
    var imageUrl = "http://attach.bbs.miui.com/forum/201501/13/141755xbccajc97cbub1tb.png"
    var watcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

        }

        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            if (lastName.get() != charSequence.toString()) {
                lastName.set(charSequence.toString())
            }
        }

        override fun afterTextChanged(editable: Editable) {

        }
    }

    companion object {
        fun create(): UserModel {
            return UserModel()
        }
    }

    override fun toString(): String {
        return "UserModel(lastName=${lastName.get()}, name=$name, imageUrl='$imageUrl', watcher=$watcher)"
    }

}
