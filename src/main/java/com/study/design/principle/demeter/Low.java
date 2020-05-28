package com.study.design.principle.demeter;

/**
 * @author dxq
 * @title: Low
 * @projectName reflex
 * @description: 迪米特法则demo
 * @date 2020/5/28 16:05
 */
public class Low {
    public static void main(String[] args) {
        // leader类不需要知道课程信息，符合Demeter法则最少知道原则
        TeamLeader teamLeader = new TeamLeader();
        teamLeader.commandCheckNumber(new Employee());
    }
}
