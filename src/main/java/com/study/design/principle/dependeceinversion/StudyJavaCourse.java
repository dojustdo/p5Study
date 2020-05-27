package com.study.design.principle.dependeceinversion;

/**
 * @author dxq
 * @title: StudyJavaCoures
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/27 14:47
 */
public class StudyJavaCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("study java");
    }
}
