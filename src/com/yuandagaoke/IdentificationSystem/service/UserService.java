package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.Account;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:04
 */
public interface UserService {
    //添加用户
   boolean addUser(Account account);

   //判断用户登录
    boolean login(Account account);

    //查出总记录数
    int totalRecords();

    //查出所有用户,按照分页查询
    List<Account> findAllUser(int pageNow,int pageSize);

    //根据用户名查找信息
    List<Account> findByName(String name,int pageNow,int pageSize);

    //删除用户
    boolean deleteUser(int account_number);

    //删除用户的同时向表中添加被删除的数据
    boolean addDeleteUser(int account_number);

    //查找被删除的用户
    List<Account> findDeleteUser();
}
