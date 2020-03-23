package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:19
 */
//充值记录表
//每充值一次,充值记录就增加一次
public class Recharge_Record {
    private int recharge_record_number;
    private int recharge_record_CompanyNumber; //充值记录之公司编号
    private int rechargeMoney;
    private int  operator; //操作人
    private Timestamp recharge_time;
    private String postScript;

    public Recharge_Record() {
    }

    public Recharge_Record(int recharge_record_number, int recharge_record_CompanyNumber, int rechargeMoney, int operator, Timestamp recharge_time, String postScript) {
        this.recharge_record_number = recharge_record_number;
        this.recharge_record_CompanyNumber = recharge_record_CompanyNumber;
        this.rechargeMoney = rechargeMoney;
        this.operator = operator;
        this.recharge_time = recharge_time;
        this.postScript = postScript;
    }

    public int getRecharge_record_number() {
        return recharge_record_number;
    }

    public void setRecharge_record_number(int recharge_record_number) {
        this.recharge_record_number = recharge_record_number;
    }

    public int getRecharge_record_CompanyNumber() {
        return recharge_record_CompanyNumber;
    }

    public void setRecharge_record_CompanyNumber(int recharge_record_CompanyNumber) {
        this.recharge_record_CompanyNumber = recharge_record_CompanyNumber;
    }

    public int getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(int rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public Timestamp getRecharge_time() {
        return recharge_time;
    }

    public void setRecharge_time(Timestamp recharge_time) {
        this.recharge_time = recharge_time;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
    }
}
