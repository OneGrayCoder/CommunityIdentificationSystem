package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.CompanyDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.CompanyDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.Company;
import com.yuandagaoke.IdentificationSystem.service.CompanyService;


/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 16:42
 */
public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao = new CompanyDaoImpl();
    @Override
    public boolean addCompany(Company company) {
        return companyDao.addCompany(company);
    }
}
