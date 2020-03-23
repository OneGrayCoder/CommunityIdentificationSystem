package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:28
 */

//充值卡
public class Recharge_Card {
    private int  recharge_cardNumber;
    private int creditCard_Number; //刷卡次数
    private int  charge_Standard; //收费标准
    private int  amtall;   //总金额
    private int  balance;//余额
    private  int recharge_CompanyNumber;//充值之公司编号

    public Recharge_Card() {
    }

    public Recharge_Card(int recharge_cardNumber, int creditCard_Number, int charge_Standard, int amtall, int balance, int recharge_CompanyNumber) {
        this.recharge_cardNumber = recharge_cardNumber;
        this.creditCard_Number = creditCard_Number;
        this.charge_Standard = charge_Standard;
        this.amtall = amtall;
        this.balance = balance;
        this.recharge_CompanyNumber = recharge_CompanyNumber;
    }

    public int getRecharge_cardNumber() {
        return recharge_cardNumber;
    }

    public void setRecharge_cardNumber(int recharge_cardNumber) {
        this.recharge_cardNumber = recharge_cardNumber;
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

    public int getRecharge_CompanyNumber() {
        return recharge_CompanyNumber;
    }

    public void setRecharge_CompanyNumber(int recharge_CompanyNumber) {
        this.recharge_CompanyNumber = recharge_CompanyNumber;
    }
}
