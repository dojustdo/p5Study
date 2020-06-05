package com.study.design.pattern.singleton.registration;

/**
 * @author dxq
 * @title: EnumSingleton
 * @projectName reflex
 * @description: 注册式单列 枚举单列
 * @date 2020/6/5 9:57
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
