package com.study.design.principle.dependeceinversion;

/**
 * @author dxq
 * @title: StudyPythonCourse
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/27 15:00
 */
public class StudyPythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("study python");
    }
}
