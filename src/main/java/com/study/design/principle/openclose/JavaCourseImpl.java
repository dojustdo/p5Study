package com.study.design.principle.openclose;

/**
 * @author dxq
 * @title: JavaCourseImpl
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/26 16:40
 */
public class JavaCourseImpl implements ICourse {

    private Integer id;
    private String name;
    private Double price;

    public JavaCourseImpl(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

}
