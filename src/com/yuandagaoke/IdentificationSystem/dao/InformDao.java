package com.yuandagaoke.IdentificationSystem.dao;

import com.yuandagaoke.IdentificationSystem.pojo.Inform;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/21 17:14
 */
public interface InformDao {
    List<Inform> findAllInformation(int pageNow,int pageSize);

    int totalRecords();

    List<Inform> queryByRange(int min,int max);

    int findRangeCount(int min,int max);
}
