package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.CompanyDao;
import com.yuandagaoke.IdentificationSystem.pojo.Company;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 16:43
 */
public class CompanyDaoImpl implements CompanyDao {
    private BasicDaoUtil basic  = new BasicDaoUtil();
    @Override
    public boolean addCompany(Company company) {
        boolean flag = false;
        int result = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "insert into company values(null,?,?,?,?)";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);//刷卡标准,5元每次
            flag = basic.executeUpdate(pst,company.getCompany_account(),company.getCompany_name(),company.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return flag;
    }
}
