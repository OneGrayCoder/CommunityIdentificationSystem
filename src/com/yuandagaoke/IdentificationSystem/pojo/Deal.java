package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:12
 */
//交易表
public class Deal {
    private int deal_number;
    private int company_number;// 引用公司编号
    private int employer_number;// 引用雇主编号
    private int worker_number;  //引用工人编号
    private int agent_number;//经办人编号
    private Timestamp record_time_deal;//登记时间
    private Timestamp transactionValidity; //交易有效期
    private String statu; //状态
    private int salary; //工资
    private String employ_type;//雇佣类型
    private int referral_fee;//介绍费
    private Timestamp fixture_date;//成交日期

    public Deal() {
    }

    public Deal(int deal_number, int company_number, int employer_number, int worker_number, int agent_number, Timestamp record_time_deal, Timestamp transactionValidity, String statu, int salary, String employ_type, int referral_fee, Timestamp fixture_date) {
        this.deal_number = deal_number;
        this.company_number = company_number;
        this.employer_number = employer_number;
        this.worker_number = worker_number;
        this.agent_number = agent_number;
        this.record_time_deal = record_time_deal;
        this.transactionValidity = transactionValidity;
        this.statu = statu;
        this.salary = salary;
        this.employ_type = employ_type;
        this.referral_fee = referral_fee;
        this.fixture_date = fixture_date;
    }

    public int getDeal_number() {
        return deal_number;
    }

    public void setDeal_number(int deal_number) {
        this.deal_number = deal_number;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public int getEmployer_number() {
        return employer_number;
    }

    public void setEmployer_number(int employer_number) {
        this.employer_number = employer_number;
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public int getAgent_number() {
        return agent_number;
    }

    public void setAgent_number(int agent_number) {
        this.agent_number = agent_number;
    }

    public Timestamp getRecord_time_deal() {
        return record_time_deal;
    }

    public void setRecord_time_deal(Timestamp record_time_deal) {
        this.record_time_deal = record_time_deal;
    }

    public Timestamp getTransactionValidity() {
        return transactionValidity;
    }

    public void setTransactionValidity(Timestamp transactionValidity) {
        this.transactionValidity = transactionValidity;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmploy_type() {
        return employ_type;
    }

    public void setEmploy_type(String employ_type) {
        this.employ_type = employ_type;
    }

    public int getReferral_fee() {
        return referral_fee;
    }

    public void setReferral_fee(int referral_fee) {
        this.referral_fee = referral_fee;
    }

    public Timestamp getFixture_date() {
        return fixture_date;
    }

    public void setFixture_date(Timestamp fixture_date) {
        this.fixture_date = fixture_date;
    }
}
