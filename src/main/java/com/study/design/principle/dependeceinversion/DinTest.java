package com.study.design.principle.dependeceinversion;

/**
 * @author dxq
 * @title: DinTest
 * @projectName reflex
 * @description: 依赖倒转原则demo
 * @date 2020/5/27 14:43
 */
public class DinTest {
    // 设计原则先设计高层抽象，再具体实现
    // demo业务一个人学习多个课程
    public static void main(String[] args) {
        // 实现方式
        /* ===== v1 ======
        Dxq dxq = new Dxq();
        dxq.studyJavaCourse();
        dxq.studyPythonCourse();
        */

        /* ===== v2 ======
        Dxq dxq = new Dxq();
        dxq.study(new StudyJavaCourse());
        dxq.study(new StudyPythonCourse());
         */

        /* ===== v3 ======
        Dxq dxq = new Dxq(new StudyJavaCourse());
        dxq.study();
         */

        // ===== v4 ======
        Dxq dxq = new Dxq();
        dxq.setiCourse(new StudyJavaCourse());
        dxq.study();

    }
}
