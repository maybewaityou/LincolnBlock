package com.llbt.meepwn.lincoinblock.framework.base;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincoinblock.framework.Model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * package: com.llbt.meepwn.lincoinblock.framework.base
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 下午12:51
 * desc: 业务模型类
 */
@SuppressWarnings("unchecked")
public class BaseModel implements Model {

    protected Map<String, String> attrs;

    @Override
    public void setupData() {
        Field[] fields = getClass().getDeclaredFields();        //获取实体类的所有属性，返回Field数组
        for (Field aField : fields) {   //遍历所有属性
            String name = aField.getName();     //获取属性的名字

            // 自动生成
            if ("$change".equals(name)) continue;

            for (String key : attrs.keySet()) {
                String fieldKey = "m" + key.substring(0, 1).toUpperCase() + key.substring(1); //将key的首字符大写，方便构造get，set方法

                if (!fieldKey.equals(name)) continue;

                try {
                    Method m = getClass().getMethod("get"+name);
                    ObservableField<String> field = (ObservableField<String>) m.invoke(this);    //调用getter方法获取属性值
                    field.set(attrs.get(key));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String, String> getAttrs() {
        if (attrs == null) {
            attrs = new HashMap<>();
        }
        return attrs;
    }

}
