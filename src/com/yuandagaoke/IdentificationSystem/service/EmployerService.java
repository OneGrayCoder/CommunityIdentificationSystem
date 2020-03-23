package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.Employer;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:14
 */
//
public interface EmployerService {
    //通过经办人编号获取公司编号
    int findCompanyNumber(int agent);

    //添加雇主
    boolean addEmployer(Employer employer);

    Map<Employer,String> findEmployerList(int pageNow, int pageSize);

    int findEmployerCount();

    List<Employer> findThisEmployer(int employer_number);

    List<Employer> selectEmployer(Employer em,String statu);

    boolean changeEmployer(Employer employer);
}
