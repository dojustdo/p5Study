package com.study.design.principle.dependeceinversion;

/**
 * @author dxq
 * @title: Dxq
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/27 14:45
 */
public class Dxq {

    /* ========== v1 =========
    public void studyJavaCourse() {
        System.out.println("study java");
    }

    public void studyPythonCourse() {
        System.out.println("study python");
    }*/

    /* ========== v2 =========
        public void study(ICourse iCourse) {
        iCourse.study();
    }
     */

    /* ========== v3 =========
       private ICourse iCourse;
    public Dxq(ICourse iCourse) {
        this.iCourse = iCourse;
    }
    public void study() {
        iCourse.study();
    }
     */

    // ========== v4 =========
    private ICourse iCourse;

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void study() {
        iCourse.study();
    }


}
