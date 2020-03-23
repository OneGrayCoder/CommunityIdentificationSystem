package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.ChargeDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.ChargeDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.ChargeView;
import com.yuandagaoke.IdentificationSystem.service.ChargeService;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 13:02
 */
public class ChargeServiceImpl implements ChargeService {
    private ChargeDao chargeDao = new ChargeDaoImpl();
    @Override
    public List<ChargeView> findChargeRecords() {
        return chargeDao.findChargeRecords();
    }

    @Override
    public boolean charge(String companyName, String ps, int chargeMoney) {
        return chargeDao.charge(companyName,ps,chargeMoney);
    }
}
