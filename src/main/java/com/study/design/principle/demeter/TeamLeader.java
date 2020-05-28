package com.study.design.principle.demeter;

import java.util.List;

/**
 * @author dxq
 * @title: TeamLeader
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/28 15:59
 */
public class TeamLeader {
    public void commandCheckNumber(Employee employee) {
        employee.checkNumberOfCourse();
    }
}
