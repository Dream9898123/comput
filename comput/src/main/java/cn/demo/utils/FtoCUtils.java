package cn.demo.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FtoCUtils {
    public Object fatherToChild(Object father, Object child) {
        if (!(child.getClass().getSuperclass() == father.getClass())) {
            try {
                throw new Exception(child + "不是" + father + "的子类");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Class fatherClass = father.getClass();
        Field[] fatherClassDeclaredFields = fatherClass.getDeclaredFields();
        for (Field tmpField : fatherClassDeclaredFields) {
            tmpField.setAccessible(true);
            Method method = null;
            try {
                method = fatherClass.getMethod("get" + upperHeadChar(tmpField.getName()));
                Object invoke = method.invoke(father);
                tmpField.set(child, invoke);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return child;
    }

    private String upperHeadChar(String name) {
        String head = name.substring(0, 1);
        return head.toUpperCase() + name.substring(1, name.length());
    }

}
