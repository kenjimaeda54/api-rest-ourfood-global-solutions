package com.uorfood;

import oracle.jdbc.datasource.impl.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Config {
    public static final String keyUser = "";
    public static final String keyPwd = "";
    public static final String baseUrl = "";
    //RAFAEL
    //RM86981
    //250303

    //ajustar os id
    //JOAO
    //RM87894
    //160502

    //esta api precisa verificar alguams coisas
    //kenji
    //RM87925
    //080689



    //karen
    //RM88429
    //090402


    public Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL(Config.baseUrl);
        ods.setUser(Config.keyUser);
        ods.setPassword(Config.keyPwd);
        Connection conn = ods.getConnection();
        return conn;
    }

    ;

}