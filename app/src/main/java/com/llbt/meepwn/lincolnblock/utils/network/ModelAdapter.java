package com.llbt.meepwn.lincolnblock.utils.network;

import com.llbt.meepwn.lincolnblock.framework.base.Model;
import com.llbt.meepwn.lincolnblock.main.model.test_json.Book;
import com.llbt.meepwn.lincolnblock.main.model.test_json.Dog;
import com.llbt.meepwn.lincolnblock.main.model.test_json.TestJsonModel;
import com.llbt.meepwn.lincolnblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincolnblock.utils.network
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/24 下午12:03
 * desc: 模型适配器
 */
@SuppressWarnings("unchecked")
public class ModelAdapter {

    public static <T extends Model> T modelWithJsonString(String jsonString, Class clazz) {
        if (clazz == TestJsonModel.class) {
            TestJsonModel model = JsonParser.<TestJsonModel>parse(jsonString, TestJsonModel.class);
            Dog innerModel = JsonParser.<Dog>parse(model.getmDog().get().toString(), Dog.class);
            model.getDogModel().set(innerModel);
            model.setBookModels(JsonParser.<Book>parseArray(model.getmBooks().get().toString(), Book.class));
            return (T) model;
        } else {
            return JsonParser.<T>parse(jsonString, clazz);
        }
    }

}
