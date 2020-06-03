package com.study.design.pattern.factory.simplefactory;

/**
 * @author dxq
 * @title: CourseFactory
 * @projectName reflex
 * @description: TODO
 * @date 2020/6/2 10:54
 */
public class CourseFactory {
    public ICourse create(Class<? extends ICourse> clazz) {
        try {
            if (clazz != null) {
                ICourse iCourse = clazz.newInstance();
                return iCourse;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
