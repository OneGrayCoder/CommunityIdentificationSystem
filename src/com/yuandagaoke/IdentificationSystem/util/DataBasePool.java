package com.yuandagaoke.IdentificationSystem.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/14 9:55
 */

//用来获取连接等常用方法
public class DataBasePool {
    private static Connection con =null;
    private static DataSource ds = null;

    //类初始化时,就获取数据源
    static{
        ds = new ComboPooledDataSource();
    }

    public static Connection  getConnection(){
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
