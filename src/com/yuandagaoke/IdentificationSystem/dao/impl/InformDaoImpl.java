package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.InformDao;
import com.yuandagaoke.IdentificationSystem.pojo.Inform;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/21 17:14
 */
public class InformDaoImpl implements InformDao {
    private BasicDaoUtil basicDaoUtil = new BasicDaoUtil();
    @Override
    public List<Inform> findAllInformation(int pageNow, int pageSize) {
        List<Inform> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select *from inform order by inform_number limit ?,?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst, (pageNow - 1) * pageSize, pageSize);
            while(res!=null&&res.next()){
                Inform in = new Inform();
                in.setInform_number(res.getInt(1));
                in.setInform_content(res.getString(2));
                in.setInform_date(res.getTimestamp(3));
                list.add(in);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return list;
    }

    @Override
    public int totalRecords() {
        //查找通知表的所有记录
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int totalRecords = 0;
        String sql = "select count(*) from inform";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,null);
            while (res!=null&&res.next()){
                totalRecords = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return totalRecords;
    }

    @Override
    public List<Inform> queryByRange(int min, int max) {
        //根据范围来查找数据
        List<Inform> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select *from inform where inform_number>= ? and inform_number<= ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst, min, max);
            while(res!=null&&res.next()){
                Inform in = new Inform();
                in.setInform_number(res.getInt(1));
                in.setInform_content(res.getString(2));
                in.setInform_date(res.getTimestamp(3));
                list.add(in);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return list;
    }

    @Override
    public int findRangeCount(int min, int max) {
        int count = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select count(*) from(select * from  inform where inform_number>= ? and inform_number<= ?)c";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst, min, max);
            while(res!=null&&res.next()){
                count = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return count;
    }
}
