package com.llbt.meepwn.lincolnblock.framework;

import android.databinding.ObservableField;

import com.llbt.meepwn.lincolnblock.framework.types.ModelType;

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
        Field[] selfFields = clazz.getDeclaredFields(); // 获取调用者的属性列表
        Field[] targetFields = targetClazz.getDeclaredFields(); // 目标类的属性列表
        Model targetModel = null; // 返回目标类
        try {
            targetModel = (Model) targetClazz.newInstance(); // 初始化
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Field aField : selfFields) {
            String aName = aField.getName(); // 调用者的属性

            // 自动生成的属性
            if ("$change".equals(aName)) continue;

            for (Field bField : targetFields) {
                String bName = bField.getName(); // 目标类的属性

                // 自动生成的属性
                if ("$change".equals(bName)) continue;

                if (!aName.equals(bName)) continue;

                //将key的首字符大写，方便构造get，set方法
                String fieldKey = bName.substring(0, 1).toUpperCase() + bName.substring(1);

                try {
                    Method m = clazz.getMethod("get" + fieldKey); // 获取get方法
                    Object o = m.invoke(this); // 调用get方法,获得返回值,用来判断
                    if (o instanceof Model) { // 包含Model
                        String className = "com.llbt.meepwn.lincolnblock.main.model.test_json." + aField.getName().substring(0,1).toUpperCase() + aField.getName().substring(1) + "Model";
                        Model subModel = ((Model) o).mapToTargetModel(aField.getType(), Class.forName(className)); // 递归

                        Method tm = targetClazz.getMethod("set" + fieldKey, ObservableField.class); // 获取set方法
                        tm.invoke(targetModel, new ObservableField(subModel)); // 调用set方法
                    } else if (o instanceof List) { // 包含List<Model>
                        List subModels = new ArrayList<>();
                        List selfModelList = (ArrayList) o;
                        String className = aField.getName().substring(0,1).toUpperCase() + aField.getName().substring(1); // 属性名叫books -> Books
                        className = className.substring(0, className.length()-1); // Books -> Book
                        String AllClassName = "com.llbt.meepwn.lincolnblock.main.model.test_json." + className + "Model"; // BookModel的全路径
                        for (int i=0; i<selfModelList.size(); i++) {
                            Model subModel = ((Model) selfModelList.get(i)).mapToTargetModel(selfModelList.get(i).getClass(), Class.forName(AllClassName)); // 递归
                            subModels.add(subModel);
                        }
                        Method tm = targetClazz.getMethod("set" + fieldKey, List.class); // 获取set方法
                        tm.invoke(targetModel, subModels); // 调用set方法
                    } else { // 包含的String
                        Method tm = targetClazz.getMethod("set" + fieldKey, ObservableField.class); // 获取set方法
                        tm.invoke(targetModel, new ObservableField(o)); // 调用set方法
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return targetModel;
    }

}
