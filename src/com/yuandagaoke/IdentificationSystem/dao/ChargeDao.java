package com.yuandagaoke.IdentificationSystem.dao;

import com.yuandagaoke.IdentificationSystem.pojo.ChargeView;

import java.sql.Timestamp;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 13:03
 */
public interface ChargeDao {
    List<ChargeView> findChargeRecords();

    String findLoginName(int company);

    String findCompanyName(int companyNumber);

    //获取备注
    String getPointScript(int companyNumber);

    Timestamp getChargeTime(int companyNumber);

    boolean charge(String companyName,String ps,int chargeMoney);

    int getCompanyNumber(String companyName);
}
