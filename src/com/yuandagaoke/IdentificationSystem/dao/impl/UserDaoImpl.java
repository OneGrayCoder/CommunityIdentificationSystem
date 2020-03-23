package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.UserDao;
import com.yuandagaoke.IdentificationSystem.pojo.Account;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:03
 */
//
public class UserDaoImpl implements UserDao {
    private BasicDaoUtil basic = new BasicDaoUtil();

    @Override
    public boolean addNewUser(Account account) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "insert into account values(?,?,?,?,?,?,?,?,?,?)";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            boolean b = basic.executeUpdate(pst, null, account.getUsername(),
                    account.getFullname(), account.getEmail(), account.getPwd(),
                    account.getEnabled(), account.getCompanyLv(), account.getBelongCompany()
                    , account.getLoginName(),account.getSex());
            if (b){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(null,pst,con);
        }
        return flag;
    }

    //检查用户登录
    @Override
    public boolean userLogin(Account account){
        boolean b = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        con = DataBasePool.getConnection();
        String sql = "select count(*) from account where loginName = ? and pwd = ?";
        try {
            pst = con.prepareStatement(sql);
            System.out.println("查看是否是加密的密码"+account.getPwd());
            res = basic.executeQuery(pst, account.getLoginName(), account.getPwd());
            while (res.next()&&res.getInt(1)!= 0){
                System.out.println(res.getInt(1));
                b = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return b;
    }

    //查询总记录数
    @Override
    public int totalRecords(){
        int i = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select count(account_number) from  account";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst);
            while(res != null && res.next()){
                i = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return i;
    }

    @Override
    public List<Account> findAllUser(int pageNow, int pageSize) {
        //实现分页查询
        List<Account> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select *from account order by account_number limit ?,?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst,(pageNow-1)*pageSize,pageSize);
         while(res != null&&res.next()){
             Account account = new Account();
             account.setAccount_number(res.getInt("account_number"));
             account.setLoginName(res.getString("loginName"));
             account.setFullname(res.getString("fullname"));
             account.setEnabled(res.getString("enabled"));//账号状态
             account.setEmail(res.getString("email"));
             list.add(account);
         }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return list;
    }

    //根据用户名查找信息
    @Override
    public List<Account> findByName(String name,int pageNow,int pageSize){
        List<Account> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select * from account where fullname like '%"+name+"%' order by account_number limit ?,?";
        con = DataBasePool.getConnection();
        try {
            pst  = con.prepareStatement(sql);
            res = basic.executeQuery(pst,(pageNow-1)*pageSize,pageSize);
            while(res != null&&res.next()){
                Account account = new Account();
                account.setAccount_number(res.getInt("account_number"));
                account.setLoginName(res.getString("loginName"));
                account.setFullname(res.getString("fullname"));
                account.setEnabled(res.getString("enabled"));//账号状态
                account.setEmail(res.getString("email"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return list;
    }

    @Override
    public boolean deleteUser(int account){
        boolean b = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "delete from account where account_number = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            b = basic.executeUpdate(pst, account);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return b;
    }

    //将删除的记录添加到某张表中,并返回一个存储了删除数据的list集合
    @Override
    public boolean addDeleteUser(int account_number){
        boolean b = false;
        List<Account> list = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        PreparedStatement pstd = null;
        ResultSet resultSet = null;
        //删除某条记录的时候向某个表添加这条被删除的记录
        con = DataBasePool.getConnection();
        Account account = null;
        //先将查询出来的信息,封装到
        String sql1 = "select *from account where account_number = ?";
        try {

            pstd = con.prepareStatement(sql1);
            resultSet = basic.executeQuery(pstd,account_number);
            list = new ArrayList<>();
            while(resultSet != null&&resultSet.next()){
                account = new Account();
                account.setAccount_number(resultSet.getInt("account_number"));
                account.setLoginName(resultSet.getString("loginName"));
                account.setFullname(resultSet.getString("fullname"));
                account.setEnabled(resultSet.getString("enabled"));//账号状态
                account.setEmail(resultSet.getString("email"));
                account.setBelongCompany(resultSet.getInt("belongCompany"));
                account.setSex(resultSet.getString("sex"));
                account.setCompanyLv(resultSet.getString("CompanyLv"));
                account.setUsername(resultSet.getInt("username"));
                account.setPwd(resultSet.getString("pwd"));
                list.add(account);
            }
            String sql = "insert into account_del values(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            b = basic.executeUpdate(pst, account.getAccount_number(), account.getUsername(),
                    account.getFullname(), account.getEmail(), account.getPwd(),
                    account.getEnabled(), account.getCompanyLv(), account.getBelongCompany()
                    , account.getLoginName(),account.getSex());
            System.out.println("是否向删除表中添加成功"+b);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(resultSet,pstd,con);
            basic.close(res,pst,con);
        }//返回此集合方便使用
        return b;
    }

    @Override
    public List<Account> findDeleteUser() {
        List<Account> list = new ArrayList<>();
        boolean b = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select * from account_del ";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, null);
            while(res != null&&res.next()){
                Account account = new Account();
                account.setAccount_number(res.getInt("account_number"));
                account.setLoginName(res.getString("loginName"));
                account.setFullname(res.getString("fullname"));
                account.setEnabled(res.getString("enabled"));//账号状态
                account.setEmail(res.getString("email"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return list;
    }
}
