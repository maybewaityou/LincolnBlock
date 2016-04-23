package com.llbt.meepwn.lincoinblock.utils.network.json_parser;

import android.databinding.ObservableField;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.json_parser
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午3:53
 * desc: Json解析工具类
 */
@SuppressWarnings("unchecked")
public class JsonParser {

    public static <T extends BaseModel> T parse(String jsonString, Class clazz, ExtraProcessor processor) {
        T t = (T) JSON.parseObject(jsonString, clazz, processor);
        t.setupData();
        return t;
    }

    public static <T extends BaseModel> T parse(String jsonString, Class clazz) {
        return (T) parse(jsonString, clazz, new DefaultExtraProcessor<T>());
    }

    public static <T extends BaseModel> List<ObservableField<T>> parseArray(String jsonArrayString, Class clazz) {
        List<org.json.JSONObject> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsonArrayString);
            for (int i=0; i<jsonArray.length(); i++) {
                list.add(jsonArray.optJSONObject(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<ObservableField<T>> models = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            T model= JsonParser.<T>parse(list.get(i).toString(), clazz);
            models.add(new ObservableField(model));
        }
        return models;
    }


}
