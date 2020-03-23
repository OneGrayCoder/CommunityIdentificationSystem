package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.Inform;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/21 17:13
 */
public interface InformService {
    //查找所有inform,并且分页显示

    List<Inform> findAllInformation(int pageNow,int pageSize);

    int totalRecords();

    List<Inform> queryByRange(int min,int max);

    int findRangeCount(int min,int max);
}
