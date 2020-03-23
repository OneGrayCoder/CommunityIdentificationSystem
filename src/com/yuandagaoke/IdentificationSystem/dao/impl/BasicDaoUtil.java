package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.sun.istack.internal.NotNull;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/14 11:04
 */

//此类用来封装一些对database的常用方法
public class BasicDaoUtil {
   /* 对预编译对象中的问号传值,增删改可能传入多个值*/
    public boolean executeUpdate(@NotNull PreparedStatement pst,Object...obj) throws SQLException {
        //受影响的行数
        //****注意，在调用此方法之前,需用connection获取预编译对象并且传递sql语句!**
        boolean flag = false;
        int res = 0;
        if (obj != null&&obj.length>0){
            //底层异常不建议抛出
            for (int i = 0; i <obj.length; i++) {
                pst.setObject(i+1,obj[i]);
            }
        }
        res = pst.executeUpdate();
        //打印一下,方便观察,根据情况可删除
        System.out.println(res);
        //受影响的行数不止一行
        if (res != 0&&res>0){
            flag = true;
        }
        return flag;
    }

    //对预编译对象中的问号传值,只针对查询
    public ResultSet executeQuery(@NotNull PreparedStatement pst,Object...obj) throws SQLException {
        ResultSet res = null;
        //受影响的行数
        //****注意，在调用此方法之前,需用connection获取预编译对象并且传递sql语句!**
        if (obj != null){
            //底层异常不建议抛出
            for (int i = 0; i <obj.length; i++) {
                pst.setObject(i+1,obj[i]);
            }
            res = pst.executeQuery();
        }else{//不带条件的查询
            res = pst.executeQuery();
        }
        return res;
    }


    //关闭连接
    public  void close(ResultSet res, @NotNull PreparedStatement pst,@NotNull Connection con){
        try {
            if (res != null){
                res.close();
            }
            if (pst != null){
                pst.close();
            }
            if (con != null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
