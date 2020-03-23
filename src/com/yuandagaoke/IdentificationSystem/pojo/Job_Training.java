package com.yuandagaoke.IdentificationSystem.pojo;

import java.util.Date;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:30
 */
//岗位培训
public class Job_Training {
    private int training_number;
    private int worker_number; //工人编号 引用工人表
    private String training_agency;//培训机构
    private String training_content;//培训内容
    private String training_situation;//培训情况
    private Date training_time;//培训时间

    public Job_Training() {
    }


    public int getTraining_number() {
        return training_number;
    }

    public void setTraining_number(int training_number) {
        this.training_number = training_number;
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public String getTraining_agency() {
        return training_agency;
    }

    public void setTraining_agency(String training_agency) {
        this.training_agency = training_agency;
    }

    public String getTraining_content() {
        return training_content;
    }

    public void setTraining_content(String training_content) {
        this.training_content = training_content;
    }

    public String getTraining_situation() {
        return training_situation;
    }

    public void setTraining_situation(String training_situation) {
        this.training_situation = training_situation;
    }

    public Date getTraining_time() {
        return training_time;
    }

    public void setTraining_time(Date training_time) {
        this.training_time = training_time;
    }
}
