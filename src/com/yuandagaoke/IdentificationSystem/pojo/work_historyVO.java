package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:25
 */
//工作经历
public class  work_historyVO {

    private int worker_number;
    private String[] unit;//-- 单位
    private String[] work_type;// 工种
    private String[] duty;//-- 职务
    private Date[] work_time;//工作时间

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public String[] getUnit() {
        return unit;
    }

    public void setUnit(String[] unit) {
        this.unit = unit;
    }

    public String[] getWork_type() {
        return work_type;
    }

    public void setWork_type(String[] work_type) {
        this.work_type = work_type;
    }

    public String[] getDuty() {
        return duty;
    }

    public void setDuty(String[] duty) {
        this.duty = duty;
    }

    public Date[] getWork_time() {
        return work_time;
    }

    public void setWork_time(Date[] work_time) {
        this.work_time = work_time;
    }
}
