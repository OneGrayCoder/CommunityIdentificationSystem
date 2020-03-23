package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.InformDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.InformDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.Inform;
import com.yuandagaoke.IdentificationSystem.service.InformService;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/21 17:13
 */
public class InformServiceImpl implements InformService {
    private InformDao informDao = new InformDaoImpl();
    @Override
    public List<Inform> findAllInformation(int pageNow, int pageSize) {
        return informDao.findAllInformation(pageNow,pageSize);
    }

    @Override
    public int totalRecords() {
        return informDao.totalRecords();
    }

    @Override
    public List<Inform> queryByRange(int min, int max) {
        return informDao.queryByRange(min,max);
    }

    @Override
    public int findRangeCount(int min, int max) {
        return informDao.findRangeCount(min,max);
    }
}
