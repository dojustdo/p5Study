package com.study.design.principle.openclose;

/**
 * @author dxq
 * @title: OpenCloseTest
 * @projectName reflex
 * @description: 开闭原则
 * @date 2020/5/26 16:26
 */
public class OpenCloseTest {
    /**
     * demo实现课程的多样性，活动价格扩展
     * 并依旧能取得课程原价
     */
    public static void main(String[] args) {
        ICourse iCourse = new DiscountJavaCourse(1, "java课程", 1000D);
        DiscountJavaCourse discountJavaCourse = (DiscountJavaCourse) iCourse;
        System.out.println("课程：" + discountJavaCourse.getName());
        System.out.println("id:" + discountJavaCourse.getId());
        System.out.println("价格" + discountJavaCourse.getPrice());
        System.out.println("折后价" + discountJavaCourse.getDiscountPrice());
    }
}
