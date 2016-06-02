package com.llbt.meepwn.lincolnblock.main.model;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.base.Model;
import com.llbt.meepwn.lincolnblock.utils.binding.EditTextWatcher;
import com.llbt.meepwn.lincolnblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午3:05
 * desc:
 */
public class UserModel extends Model {

	private ObservableField<String> lastName = new ObservableField<>("李四");
	private String name = "张三";
	private String imageUrl = "http://attach.bbs.miui.com/forum/201501/13/141755xbccajc97cbub1tb.png";
	private EditTextWatcher watcher = new EditTextWatcher() {
		@Override
		public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
			if (lastName.get().equals(charSequence.toString())) {
				lastName.set(charSequence.toString());
			}
		}
	};

	public static UserModel initWithJsonString(String jsonString) {
		return JsonParser.parse(jsonString, UserModel.class);
	}

	public ObservableField<String> getLastName() {
		return lastName;
	}

	public void setLastName(ObservableField<String> lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public EditTextWatcher getWatcher() {
		return watcher;
	}

	public void setWatcher(EditTextWatcher watcher) {
		this.watcher = watcher;
	}

	@Override
	public String toString() {
		return "{" +
				"\"lastName\" : " + "\"" + lastName.get() + "\"" +
				", \"name\" : " + "\"" + name + "\"" +
				", \"imageUrl\" : " + "\"" + imageUrl + "\"" +
				", \"watcher\" : " + "\"" + watcher + "\"" +
				"}";
	}
}
