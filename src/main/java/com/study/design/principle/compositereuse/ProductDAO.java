package com.study.design.principle.compositereuse;

/**
 * @author dxq
 * @title: ProductDAO
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/29 13:35
 */
public class ProductDAO {
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct() {

    }

}
