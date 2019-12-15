package com.study.generic;

public class MethodGeneric<T> {

    private T temp;

    public T justDoIt(T t) {
        return (T) null;
    }

    // 实列方法，既可使用类的泛型，也可使用自定义泛型
    public <Z> Z justDoItDo(Z z) {
        return (Z) null;
    }

/*
    // 静态方法不可使用泛型类定义的泛型
    public static justDoItDozz(T t){
        return (T)null;
    }*/

    // 静态方法可自定义泛型
    public static <F> F justDoItDozz(F f) {
        return (F) null;
    }

    // Class<F> 为F类型对应的类
    public static <F> F justDoItDozz(Class<F> f) throws Exception {
        F f1 = f.newInstance();
        return (F) null;
    }
}
