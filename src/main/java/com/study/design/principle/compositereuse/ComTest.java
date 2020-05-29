package com.study.design.principle.compositereuse;

/**
 * @author dxq
 * @title: ComTest
 * @projectName reflex
 * @description: 合成复用原则
 * @date 2020/5/29 13:39
 */
public class ComTest {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.setDbConnection(new MySQLConnection());
        dao.addProduct();
    }
}
