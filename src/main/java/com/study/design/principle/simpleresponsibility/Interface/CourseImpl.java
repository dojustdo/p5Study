package com.study.design.principle.simpleresponsibility.Interface;

/**
 * @author dxq
 * @title: CourseImpl
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/28 15:08
 */
public class CourseImpl implements CourseInfo, CourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVoice() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
