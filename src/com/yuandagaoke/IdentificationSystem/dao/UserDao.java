package com.yuandagaoke.IdentificationSystem.dao;

import com.yuandagaoke.IdentificationSystem.pojo.Account;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:03
 */

//有关登录用户的方法在此添加
public interface UserDao {
    //添加新用户
    boolean addNewUser(Account account);

    //用户登录检查
    boolean userLogin(Account account);

    //查询总记录数
    int totalRecords();

    //查找所有用户
    List<Account> findAllUser(int pageNow,int pageSize);

    //根据用户名查找用户
    List<Account> findByName(String name,int pageNow,int pageSize);

    //删除用户
    boolean deleteUser(int account_number);

    //删除表的同时向表中添加被删除的用户
    boolean addDeleteUser(int account_number);

    List<Account> findDeleteUser();
}
