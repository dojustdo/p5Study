package com.study.design.principle.compositereuse;

/**
 * @author dxq
 * @title: OracleConnection
 * @projectName reflex
 * @description: TODO
 * @date 2020/5/29 13:34
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "oracle";
    }
}
