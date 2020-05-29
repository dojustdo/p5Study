package com.study.design.principle.compositereuse;

/**
 * @author dxq
 * @title: MySQLConnection
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/29 13:33
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "mysql";
    }
}
