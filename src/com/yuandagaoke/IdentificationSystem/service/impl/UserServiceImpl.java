package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.UserDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.UserDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.Account;
import com.yuandagaoke.IdentificationSystem.service.UserService;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:14
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public boolean addUser(Account account) {
        return userDao.addNewUser(account);
    }

    @Override
    public boolean login(Account account) {
        return userDao.userLogin(account);
    }


    @Override
    public int totalRecords(){
        return userDao.totalRecords();
    }

    @Override
    public List<Account> findAllUser(int pageNow, int pageSize) {
        return userDao.findAllUser(pageNow,pageSize);
    }

    @Override
    public List<Account> findByName(String name,int pageNow,int pageSize) {
        return userDao.findByName(name,pageNow,pageSize);
    }

    @Override
    public boolean deleteUser(int account_number) {
        return userDao.deleteUser(account_number);
    }

    @Override
    public boolean  addDeleteUser(int account_number){
        return userDao.addDeleteUser(account_number);
    }

    @Override
    public List<Account> findDeleteUser() {
        return userDao.findDeleteUser();
    }

}
