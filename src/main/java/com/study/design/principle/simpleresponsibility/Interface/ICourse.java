package com.study.design.principle.simpleresponsibility.Interface;

/**
 * @author dxq
 * @title: ICourse
 * @projectName reflex
 * @description: 单一职责原则接口demo
 * @date 2020/5/28 15:02
 */
public interface ICourse {

    String getCourseName();

    byte[] getCourseVoice();

    void studyCourse();

    void refundCourse();

}
