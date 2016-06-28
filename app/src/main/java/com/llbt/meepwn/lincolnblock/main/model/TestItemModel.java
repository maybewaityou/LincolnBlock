package com.llbt.meepwn.lincolnblock.main.model;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.main.model
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/29 下午3:41
 * desc:
 */
public class TestItemModel extends Model {

	private ObservableField<String> text = new ObservableField<>();

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
