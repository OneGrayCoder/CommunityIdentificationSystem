package com.yuandagaoke.IdentificationSystem.pojo;


import java.util.Date;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 11:36
 */
//工人类
public class WorkerVO {
    private int worker_number;
    private int company_number;
    private String worker_name;
    private String worker_sex;
    private String worker_IDNumber;
    private Date worker_birth;
    private int worker_age;
    private int worker_height;
    private String worker_mobile;
    private String worker_telephone;
    private String typeOfWork;//工种
    private Date worker_time; //从业时间
    private String defect;
    private String album;
    private String permanent_address;
    private String address_Now;
    private String bankCardNumber;
    private String policyNo;
    private String[] language;
    private String worker_statu;
    private String marriage_status;
    private String[] certification_status;
    private String[] health_examination;
    private Date healExamTime;
    private String[] skills;
    private String introduce;
    private String timeRequire;
    private String moneyRequire;
    private String live;
    private String eatDrink;
    private String input_time;

    public WorkerVO() {
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getWorker_name() {
        return worker_name;
    }

    public void setWorker_name(String worker_name) {
        this.worker_name = worker_name;
    }

    public String getWorker_sex() {
        return worker_sex;
    }

    public void setWorker_sex(String worker_sex) {
        this.worker_sex = worker_sex;
    }

    public String getWorker_IDNumber() {
        return worker_IDNumber;
    }

    public void setWorker_IDNumber(String worker_IDNumber) {
        this.worker_IDNumber = worker_IDNumber;
    }

    public Date getWorker_birth() {
        return worker_birth;
    }

    public void setWorker_birth(Date worker_birth) {
        this.worker_birth = worker_birth;
    }

    public int getWorker_age() {
        return worker_age;
    }

    public void setWorker_age(int worker_age) {
        this.worker_age = worker_age;
    }

    public int getWorker_height() {
        return worker_height;
    }

    public void setWorker_height(int worker_height) {
        this.worker_height = worker_height;
    }

    public String getWorker_mobile() {
        return worker_mobile;
    }

    public void setWorker_mobile(String worker_mobile) {
        this.worker_mobile = worker_mobile;
    }

    public String getWorker_telephone() {
        return worker_telephone;
    }

    public void setWorker_telephone(String worker_telephone) {
        this.worker_telephone = worker_telephone;
    }

    public String getTypeOfWork() {
        return typeOfWork;
    }

    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }

    public Date getWorker_time() {
        return worker_time;
    }

    public void setWorker_time(Date worker_time) {
        this.worker_time = worker_time;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getPermanent_address() {
        return permanent_address;
    }

    public void setPermanent_address(String permanent_address) {
        this.permanent_address = permanent_address;
    }

    public String getAddress_Now() {
        return address_Now;
    }

    public void setAddress_Now(String address_Now) {
        this.address_Now = address_Now;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }


    public String getWorker_statu() {
        return worker_statu;
    }

    public void setWorker_statu(String worker_statu) {
        this.worker_statu = worker_statu;
    }

    public String getMarriage_status() {
        return marriage_status;
    }

    public void setMarriage_status(String marriage_status) {
        this.marriage_status = marriage_status;
    }

    public String[] getCertification_status() {
        return certification_status;
    }

    public void setCertification_status(String[] certification_status) {
        this.certification_status = certification_status;
    }

    public String[] getHealth_examination() {
        return health_examination;
    }

    public void setHealth_examination(String[] health_examination) {
        this.health_examination = health_examination;
    }

    public Date getHealExamTime() {
        return healExamTime;
    }

    public void setHealExamTime(Date healExamTime) {
        this.healExamTime = healExamTime;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getTimeRequire() {
        return timeRequire;
    }

    public void setTimeRequire(String timeRequire) {
        this.timeRequire = timeRequire;
    }

    public String getMoneyRequire() {
        return moneyRequire;
    }

    public void setMoneyRequire(String moneyRequire) {
        this.moneyRequire = moneyRequire;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getEatDrink() {
        return eatDrink;
    }

    public void setEatDrink(String eatDrink) {
        this.eatDrink = eatDrink;
    }

    public String getInput_time() {
        return input_time;
    }

    public void setInput_time(String input_time) {
        this.input_time = input_time;
    }

    public String[] getLanguage() {
        return language;
    }

    public void setLanguage(String[] language) {
        this.language = language;
    }
}
