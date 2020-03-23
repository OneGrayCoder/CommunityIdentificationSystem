package com.yuandagaoke.IdentificationSystem.dao;

import com.yuandagaoke.IdentificationSystem.pojo.Employer;

import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:01
 */
//和雇主有关的方法在此添加
public interface EmployerDao {

    int findCompanyNumber(int agent);

    boolean addEmployer(Employer employer);

    Map<Employer,String> findEmployerList(int pageNow, int pageSize);

    //这是单独的方法,在查找雇主信息时,根据agent查找交易状态
    String findStatuByAgent(int agent);

    int findEmployerCount();


    List<Employer> findThisEmployer(int employer_number);


    List<Employer> selectEmployer(Employer em,String statu);

    int findAgentByStatu(String statu);

    boolean changeEmployer(Employer employer);
}
