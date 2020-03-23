package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.EmployerDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.EmployerDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.Employer;
import com.yuandagaoke.IdentificationSystem.service.EmployerService;

import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:19
 */
public class EmployerServiceImpl implements EmployerService {
    private EmployerDao employerDao = new EmployerDaoImpl();
    @Override
    public int findCompanyNumber(int agent) {
        return employerDao.findCompanyNumber(agent);
    }

    @Override
    public boolean addEmployer(Employer employer) {
        return employerDao.addEmployer(employer);
    }

    @Override
    public Map<Employer,String> findEmployerList(int pageNow, int pageSize) {
        return employerDao.findEmployerList(pageNow,pageSize);
    }

    @Override
    public int findEmployerCount() {
        return employerDao.findEmployerCount();
    }

    @Override
    public List<Employer> findThisEmployer(int employer_number) {
        return employerDao.findThisEmployer(employer_number);
    }

    @Override
    public List<Employer> selectEmployer(Employer em, String statu) {
        return employerDao.selectEmployer(em,statu);
    }

    @Override
    public boolean changeEmployer(Employer employer) {
        return employerDao.changeEmployer(employer);
    }
}
