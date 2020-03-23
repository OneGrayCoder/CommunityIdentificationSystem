package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:29
 */
//账号表
public class Account {
    private Integer account_number;//编号
    private int username;      //用户名
    private String fullname;  //姓名
    private String email;
    private String pwd;
    private String enabled; //是否可用
    private String companyLv;//公司级别 1: 总公司,2:分公司
    private int belongCompany; //账号所属公司
    private String loginName;//登录系统的用户名
    private String sex;
    public Account() {
    }

    public Account(Integer account_number, int username, String fullname, String email, String pwd, String enabled, String companyLv, int belongCompany, String loginName, String sex) {
        this.account_number = account_number;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.pwd = pwd;
        this.enabled = enabled;
        this.companyLv = companyLv;
        this.belongCompany = belongCompany;
        this.loginName = loginName;
        this.sex = sex;
    }

    public Integer getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Integer account_number) {
        this.account_number = account_number;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getCompanyLv() {
        return companyLv;
    }

    public void setCompanyLv(String companyLv) {
        this.companyLv = companyLv;
    }

    public int getBelongCompany() {
        return belongCompany;
    }

    public void setBelongCompany(int belongCompany) {
        this.belongCompany = belongCompany;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
