package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:25
 */
//工作经历
public class Work_History {
    private int history_number;
    private int worker_number;//引用工人表的工人编号
    private String unit;//-- 单位
    private String work_type;// 工种
    private String duty;//-- 职务
    private Date work_time;//工作时间

    public Work_History() {}
    public Work_History(int history_number, int worker_number, String unit, String work_type, String duty, Timestamp work_time) {
        this.history_number = history_number;
        this.worker_number = worker_number;
        this.unit = unit;
        this.work_type = work_type;
        this.duty = duty;
        this.work_time = work_time;
    }

    public int getHistory_number() {
        return history_number;
    }

    public void setHistory_number(int history_number) {
        this.history_number = history_number;
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Date getWork_time() {
        return work_time;
    }

    public void setWork_time(Date work_time) {
        this.work_time = work_time;
    }
}
