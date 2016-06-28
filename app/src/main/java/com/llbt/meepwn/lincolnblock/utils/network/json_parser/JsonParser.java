package com.llbt.meepwn.lincolnblock.utils.network.json_parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.llbt.meepwn.lincolnblock.framework.Model;

/**
 * package: com.llbt.meepwn.lincolnblock.utils.network.json_parser
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午3:53
 * desc: Json解析器
 */
@SuppressWarnings("unchecked")
public class JsonParser {

    public static <T extends Model, TT extends Model> TT parse(String jsonString, Class clazz, Class targetClass, ExtraProcessor processor) {
        T t = (T) JSON.parseObject(jsonString, clazz, processor);
        return (TT) t.mapToTargetModel(t.getClass(), targetClass);
    }

    public static <T extends Model> T parse(String jsonString, Class clazz, Class targetClass) {
        return (T) parse(jsonString, clazz, targetClass, new DefaultExtraProcessor<T>());
    }

}
