package com.llbt.meepwn.lincoinblock.main.model;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincoinblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午3:37
 * desc:
 */
public class TestFragmentModel extends BaseModel {

	private ObservableField<String> name = new ObservableField<>();
	private ObservableField<String> age = new ObservableField<>();

	public static TestFragmentModel initWithJsonString(String jsonString) {
		return JsonParser.parse(jsonString, TestFragmentModel.class);
	}

	public ObservableField<String> getName() {
		return name;
	}

	public void setName(ObservableField<String> name) {
		this.name = name;
	}

	public ObservableField<String> getAge() {
		return age;
	}

	public void setAge(ObservableField<String> age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "{" +
				"\"name\" : " + "\"" + name.get() + "\"" +
				", \"age\" : " + "\"" + age.get() + "\"" +
				"}";
	}
}
