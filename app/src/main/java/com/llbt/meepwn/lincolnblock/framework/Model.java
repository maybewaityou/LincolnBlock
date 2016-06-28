package com.llbt.meepwn.lincolnblock.framework;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.types.ModelType;
import com.llbt.meepwn.lincolnblock.main.model.test_json.BookModel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * package: com.llbt.meepwn.lincolnblock.framework.base
 * author: MeePwn
 * email: maybewaityou@gmail.com
 * github: https://github.com/maybewaityou
 * date: 16/4/12 下午12:51
 * desc: 业务模型类
 */
@SuppressWarnings("unchecked")
public abstract class Model implements ModelType {

    @Override
    public Model mapToTargetModel(Class clazz, Class targetClazz) {
        Field[] selfFields = clazz.getDeclaredFields();
        Field[] targetFields = targetClazz.getDeclaredFields();
        Model targetModel = null;
        try {
            targetModel = (Model) targetClazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Field aField : selfFields) {
            String aName = aField.getName();

            // 自动生成的属性
            if ("$change".equals(aName)) continue;

            for (Field bField : targetFields) {
                String bName = bField.getName();

                // 自动生成的属性
                if ("$change".equals(bName)) continue;

                if (!aName.equals(bName)) continue;

                //将key的首字符大写，方便构造get，set方法
                String fieldKey = bName.substring(0, 1).toUpperCase() + bName.substring(1);

                try {
                    Method m = clazz.getMethod("get" + fieldKey);
                    Object o = m.invoke(this);
                    if (o instanceof Model) {
                        String className = "com.llbt.meepwn.lincolnblock.main.model.test_json." + aField.getName().substring(0,1).toUpperCase() + aField.getName().substring(1) + "Model";
                        Model subModel = ((Model) o).mapToTargetModel(aField.getType(), Class.forName(className));

                        Method tm = targetClazz.getMethod("set" + fieldKey, ObservableField.class);
                        tm.invoke(targetModel, new ObservableField(subModel));
                    } else if (o instanceof List) {
                        List subModels = new ArrayList<>();
                        List selfModelList = (ArrayList) o;
                        String className = aField.getName().substring(0,1).toUpperCase() + aField.getName().substring(1);
                        className = className.substring(0, className.length()-1);
                        String AllClassName = "com.llbt.meepwn.lincolnblock.main.model.test_json." + className + "Model";
                        for (int i=0; i<selfModelList.size(); i++) {
                            Model subModel = ((Model) selfModelList.get(i)).mapToTargetModel(selfModelList.get(i).getClass(), Class.forName(AllClassName));
                            subModels.add(subModel);
                        }
                        Method tm = targetClazz.getMethod("set" + fieldKey, List.class);
                        tm.invoke(targetModel, subModels);
                    } else {
                        Method tm = targetClazz.getMethod("set" + fieldKey, ObservableField.class);
                        if (targetClazz == BookModel.class) {
                        }
                        tm.invoke(targetModel, new ObservableField(o));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return targetModel;
    }

}
