package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.ChargeView;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 13:02
 */
//和充值有关的方法在此执行
public interface ChargeService {

    List<ChargeView> findChargeRecords();
    /*
    * 充值*/
    boolean charge(String companyName,String ps,int chargeMoney);
}
