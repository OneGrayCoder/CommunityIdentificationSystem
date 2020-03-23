package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.*;

import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:05
 */
public interface WorkerService {
    public int insertWorker(WorkerVO workerVO);

    public void updateWorker(WorkerVO workerVO);

    public void insertFamilyMember(familyMemberVO vo);

    public void insertJob_trainingVO(job_trainingVO vo);

    public void insertWork_historyVO(work_historyVO vo);

    public List<Worker> query(Worker worker);

    public List<FamilyMember> queryFamilyMember(Integer worker_number);

    public List<Job_Training> queryJob_training(Integer worker_number);

    public List<Work_History> queryWork_history(Integer worker_number);

    public List<Company> queryCompany();

    List<Worker> queryByInfo(Worker worker,Worker w);
}
