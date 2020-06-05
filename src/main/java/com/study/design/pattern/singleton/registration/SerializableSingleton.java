package com.study.design.pattern.singleton.registration;

import java.io.Serializable;

/**
 * @author dxq
 * @title: SerializableSingleton
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/5 10:48
 */
public class SerializableSingleton implements Serializable {
    private final static SerializableSingleton serializableSingleton = new SerializableSingleton();

    private SerializableSingleton() {

    }

    public static SerializableSingleton getInstance() {
        return serializableSingleton;
    }

    private Object readResolve() {
        return serializableSingleton;
    }
}
