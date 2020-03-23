package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:26
 */
//公司类
public class Company {
    //数据类型和database保持一致
    private int company_number;
    private String company_account;
    private String company_name;
    private String description;
    /*create table company(
company_number  int primary key auto_increment,
company_account varchar(30)  not null, -- 公司账号
company_name varchar(30) not null,
description varchar(50) not null
)
*/

    public Company() {
    }

    public Company(int company_number, String company_account, String company_name, String description) {
        this.company_number = company_number;
        this.company_account = company_account;
        this.company_name = company_name;
        this.description = description;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getCompany_account() {
        return company_account;
    }

    public void setCompany_account(String company_account) {
        this.company_account = company_account;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
