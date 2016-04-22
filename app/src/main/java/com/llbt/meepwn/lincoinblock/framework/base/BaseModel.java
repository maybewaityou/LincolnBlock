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
public abstract class BaseModel<M extends Model> implements Model<M> {

    protected Map<String, Object> attrs;

    @Override
    public void setupData() {
        Field[] fields = getClass().getDeclaredFields();
        for (Field aField : fields) {
            String name = aField.getName();

            // 自动生成的属性
            if ("$change".equals(name)) continue;

            for (String key : attrs.keySet()) {
                //将key的首字符大写，方便构造get，set方法
                String fieldKey = "m" + key.substring(0, 1).toUpperCase() + key.substring(1);

                if (!fieldKey.equals(name)) continue;

                try {
                    Method m = getClass().getMethod("get"+name);
                    ObservableField field = (ObservableField) m.invoke(this);
                    Object value = attrs.get(key);
                    field.set(value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String, Object> getAttrs() {
        if (attrs == null) {
            attrs = new HashMap<>();
        }
        return attrs;
    }

}
