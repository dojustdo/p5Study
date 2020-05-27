package com.study.design.principle.openclose;

/**
 * @author dxq
 * @title: DiscountJavaCourse
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/26 16:45
 */
public class DiscountJavaCourse extends JavaCourseImpl {
    public DiscountJavaCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }
}
