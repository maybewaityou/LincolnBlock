package com.llbt.meepwn.lincoinblock.main.model;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午3:41
 * desc:
 */
public class TestItemModel extends BaseModel {

	private ObservableField<String> text = new ObservableField<>();

	public static TestItemModel initWithJsonString(String jsonString) {
		return JsonParser.parse(jsonString, TestItemModel.class);
	}

	public ObservableField<String> getText() {
		return text;
	}

	public void setText(ObservableField<String> text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "{" +
				"\"text\" : " + "\"" + text.get() + "\"" +
				"}";
	}
}
