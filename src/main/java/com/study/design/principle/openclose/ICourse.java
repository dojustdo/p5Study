package com.study.design.principle.openclose;

/**
 * @author dxq
 * @title: ICourse
 * @projectName reflex
 * @description: 课程接口 抽象构建框架，实现扩展细节
 * @date 2020/5/26 16:30
 */
public interface ICourse {

    Integer getId();

    String getName();

    Double getPrice();

}
