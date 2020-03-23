package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.WorkerDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.WorkerDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.*;
import com.yuandagaoke.IdentificationSystem.service.WorkerService;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:15
 */
public class WorkerSerciceImpl implements WorkerService {
    WorkerDao workerDao = new WorkerDaoImpl();

    @Override
    public int insertWorker(WorkerVO workerVO) {
        return workerDao.insertWorker(workerVO);
    }

    @Override
    public void updateWorker(WorkerVO workerVO) {
        workerDao.updateWorker(workerVO);
    }

    @Override
    public void insertFamilyMember(familyMemberVO vo) {
        workerDao.insertFamilyMember(vo);
    }

    @Override
    public void insertJob_trainingVO(job_trainingVO vo) {
        workerDao.insertJob_trainingVO(vo);
    }

    @Override
    public void insertWork_historyVO(work_historyVO vo) {
        workerDao.insertWork_historyVO(vo);
    }

    @Override
    public List<Worker> query(Worker worker) {
        return workerDao.query(worker);
    }

    @Override
    public List<FamilyMember> queryFamilyMember(Integer worker_number) {
        return workerDao.queryFamilyMember(worker_number);
    }

    @Override
    public List<Job_Training> queryJob_training(Integer worker_number) {
        return workerDao.queryJob_training(worker_number);
    }

    @Override
    public List<Work_History> queryWork_history(Integer worker_number) {
        return workerDao.queryWork_history(worker_number);
    }

    @Override
    public List<Company> queryCompany() {

        return workerDao.queryCompany();
    }

    @Override
    public List<Worker> queryByInfo(Worker worker,Worker w) {
        return workerDao.queryByInfo(worker,w);
    }

}
