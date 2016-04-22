package com.llbt.meepwn.lincoinblock.utils.network.json_parser;

import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.llbt.meepwn.lincoinblock.framework.base.BaseModel;

/**
 * package: com.llbt.meepwn.lincoinblock.utils.network.json_parser
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/22 下午4:03
 * desc:
 */
@SuppressWarnings("unchecked")
public class DefaultExtraProcessor<T extends BaseModel> implements ExtraProcessor {

    @Override
    public void processExtra(Object object, String key, Object value) {
        T jsonModel = (T) object;
        jsonModel.getAttrs().put(key, (String)value);
    }
}
