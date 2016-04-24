package com.llbt.meepwn.lincoinblock.utils.network;

import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;
import com.llbt.meepwn.lincoinblock.main.model.test_json.Book;
import com.llbt.meepwn.lincoinblock.main.model.test_json.Dog;
import com.llbt.meepwn.lincoinblock.main.model.test_json.TestJsonModel;
import com.llbt.meepwn.lincoinblock.utils.network.json_parser.JsonParser;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/24 下午12:03
 * desc:
 */
@SuppressWarnings("unchecked")
public class ModelAdapter {

    public static <T extends BaseModel> T modelWithJsonString(String jsonString, Class clazz) {
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
