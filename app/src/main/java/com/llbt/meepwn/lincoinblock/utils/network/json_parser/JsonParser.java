package com.llbt.meepwn.lincoinblock.utils.network.json_parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.json_parser
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午3:53
 * desc:
 */
@SuppressWarnings("unchecked")
public class JsonParser {

    public static <T extends BaseModel>T parse(String jsonString, Class clazz, ExtraProcessor processor) {
        T t = (T) JSON.parseObject(jsonString, clazz, processor);
        t.setupData();
        return t;
    }

    public static <T extends BaseModel>T parse(String jsonString, Class clazz) {
        return (T) parse(jsonString, clazz, new DefaultExtraProcessor<T>());
    }
}
