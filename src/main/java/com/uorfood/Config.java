package com.uorfood;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Config {
    public  static  final  String keyUser = "RM87925";
    public  static  final  String keyPwd = "080689";
    public static final String baseUrl =  "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    //JOAO
    //RM87894
    //160502
    //kenji
    //RM87925
    //080689
    //karen
    //RM 88429
    //090402


    public Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(Config.baseUrl);
        ods.setUser(Config.keyUser);
        ods.setPassword(Config.keyPwd);
        Connection conn = ods.getConnection();
        return  conn;
    };

}