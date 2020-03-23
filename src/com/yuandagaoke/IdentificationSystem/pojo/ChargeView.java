package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 12:54
 */
public class ChargeView {
    //用来封装页面展示数据
    private Integer  recharge_cardNumber;//序号,可以和公司表序号相同
    private String company_name;//公司名称
    private int creditCard_Number; //刷卡次数
    private int  charge_Standard; //收费标准
    private int  amtall;   //总金额
    private int  balance;//余额
    private String username;//账户名
    private String opeator;//操作人,统一为管理员
    private String postScript;
    private Timestamp recharge_time;//引用充值表的录入日期

    public ChargeView() {
    }

    public ChargeView(Integer recharge_cardNumber, String company_name, int creditCard_Number, int charge_Standard, int amtall, int balance, String username, String opeator, String postScript, Timestamp recharge_time) {
        this.recharge_cardNumber = recharge_cardNumber;
        this.company_name = company_name;
        this.creditCard_Number = creditCard_Number;
        this.charge_Standard = charge_Standard;
        this.amtall = amtall;
        this.balance = balance;
        this.username = username;
        this.opeator = opeator;
        this.postScript = postScript;
        this.recharge_time = recharge_time;
    }

    public Integer getRecharge_cardNumber() {
        return recharge_cardNumber;
    }

    public void setRecharge_cardNumber(Integer recharge_cardNumber) {
        this.recharge_cardNumber = recharge_cardNumber;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getCreditCard_Number() {
        return creditCard_Number;
    }

    public void setCreditCard_Number(int creditCard_Number) {
        this.creditCard_Number = creditCard_Number;
    }

    public int getCharge_Standard() {
        return charge_Standard;
    }

    public void setCharge_Standard(int charge_Standard) {
        this.charge_Standard = charge_Standard;
    }

    public int getAmtall() {
        return amtall;
    }

    public void setAmtall(int amtall) {
        this.amtall = amtall;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOpeator() {
        return opeator;
    }

    public void setOpeator(String opeator) {
        this.opeator = opeator;
    }

    public String getPostScript() {
        return postScript;
    }

    public void setPostScript(String postScript) {
        this.postScript = postScript;
    }

    public Timestamp getRecharge_time() {
        return recharge_time;
    }

    public void setRecharge_time(Timestamp recharge_time) {
        this.recharge_time = recharge_time;
    }
}
