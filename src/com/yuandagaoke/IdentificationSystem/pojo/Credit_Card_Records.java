package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:11
 */
//刷卡记录表
public class Credit_Card_Records {
    private int record_card_Number;
    private int record_CompanyNumber; //刷卡记录之公司编号
    private double money;               //收费金额
    private Timestamp charge_time; //刷卡时间
    private int charge_Type;        //收费类型 1:录入雇主 2.录入工人

    public Credit_Card_Records() {
    }

    public Credit_Card_Records(int record_card_Number, int record_CompanyNumber, double money, Timestamp charge_time, int charge_Type) {
        this.record_card_Number = record_card_Number;
        this.record_CompanyNumber = record_CompanyNumber;
        this.money = money;
        this.charge_time = charge_time;
        this.charge_Type = charge_Type;
    }

    public int getRecord_card_Number() {
        return record_card_Number;
    }

    public void setRecord_card_Number(int record_card_Number) {
        this.record_card_Number = record_card_Number;
    }

    public int getRecord_CompanyNumber() {
        return record_CompanyNumber;
    }

    public void setRecord_CompanyNumber(int record_CompanyNumber) {
        this.record_CompanyNumber = record_CompanyNumber;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Timestamp getCharge_time() {
        return charge_time;
    }

    public void setCharge_time(Timestamp charge_time) {
        this.charge_time = charge_time;
    }

    public int getCharge_Type() {
        return charge_Type;
    }

    public void setCharge_Type(int charge_Type) {
        this.charge_Type = charge_Type;
    }
}
