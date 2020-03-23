package com.yuandagaoke.IdentificationSystem.pojo;

import sun.management.resources.agent;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 11:36
 */
//雇主类
    //所有存储的日期类型都用Timestamp类型
public class Employer {
    private Integer employer_number;
    private int company_number;
    private String employer_name;
    private String employer_sex;
    private int employer_age;
    private String employer_nation;
    private String employer_jiguan; //籍贯
    private String employer_education;
    private String IDCardNumber;
    private String work_unit;//工作单位
    private String job; //职业
    private String contract_number;     //合同号
    private Timestamp contract_term; //合同期限
    private String telephone;
    private String mobile;
    private String house;  //住宅
    private String place_of_domicile; //户口所在地
    private String service_location;//服务处(工人去服务的地方)
    private String familyInfo_liveAddress;//家庭资料之居住地地址
    private String familyInfo_peopleCount;
    private String employ_requirement;  //雇佣要求
    private String familyInfo_serviceContent;
    private String familyInfo_houseArea; //房屋面积
    private String familyInfo_dietaryHabit;//饮食习惯
    private String familyInfo_other; //其他
    private int agent; //经办人
    private Timestamp add_time; //登记时间
    private String highest_salary_received; //能接收的最高工资
    private String lowest_salary_received;//.........最低工资
    private Timestamp birthDay;

    public Employer() {
    }

    public Employer(Integer employer_number, int company_number, String employer_name, String employer_sex, int employer_age, String employer_nation, String employer_jiguan, String employer_education, String IDCardNumber, String work_unit, String job, String contract_number, Timestamp contract_term, String telephone, String mobile, String house, String place_of_domicile, String service_location, String familyInfo_liveAddress, String familyInfo_peopleCount, String employ_requirement, String familyInfo_serviceContent, String familyInfo_houseArea, String familyInfo_dietaryHabit, String familyInfo_other, int agent, Timestamp add_time, String highest_salary_received, String lowest_salary_received, Timestamp birthDay) {
        this.employer_number = employer_number;
        this.company_number = company_number;
        this.employer_name = employer_name;
        this.employer_sex = employer_sex;
        this.employer_age = employer_age;
        this.employer_nation = employer_nation;
        this.employer_jiguan = employer_jiguan;
        this.employer_education = employer_education;
        this.IDCardNumber = IDCardNumber;
        this.work_unit = work_unit;
        this.job = job;
        this.contract_number = contract_number;
        this.contract_term = contract_term;
        this.telephone = telephone;
        this.mobile = mobile;
        this.house = house;
        this.place_of_domicile = place_of_domicile;
        this.service_location = service_location;
        this.familyInfo_liveAddress = familyInfo_liveAddress;
        this.familyInfo_peopleCount = familyInfo_peopleCount;
        this.employ_requirement = employ_requirement;
        this.familyInfo_serviceContent = familyInfo_serviceContent;
        this.familyInfo_houseArea = familyInfo_houseArea;
        this.familyInfo_dietaryHabit = familyInfo_dietaryHabit;
        this.familyInfo_other = familyInfo_other;
        this.agent = agent;
        this.add_time = add_time;
        this.highest_salary_received = highest_salary_received;
        this.lowest_salary_received = lowest_salary_received;
        this.birthDay = birthDay;
    }


    public int getEmployer_number() {
        return employer_number;
    }

    public void setEmployer_number(Integer employer_number) {
        this.employer_number = employer_number;
    }

    public int getCompany_number() {
        return company_number;
    }

    public void setCompany_number(int company_number) {
        this.company_number = company_number;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getEmployer_sex() {
        return employer_sex;
    }

    public void setEmployer_sex(String employer_sex) {
        this.employer_sex = employer_sex;
    }

    public int getEmployer_age() {
        return employer_age;
    }

    public void setEmployer_age(int employer_age) {
        this.employer_age = employer_age;
    }

    public String getEmployer_nation() {
        return employer_nation;
    }

    public void setEmployer_nation(String employer_nation) {
        this.employer_nation = employer_nation;
    }

    public String getEmployer_jiguan() {
        return employer_jiguan;
    }

    public void setEmployer_jiguan(String employer_jiguan) {
        this.employer_jiguan = employer_jiguan;
    }

    public String getEmployer_education() {
        return employer_education;
    }

    public void setEmployer_education(String employer_education) {
        this.employer_education = employer_education;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public String getWork_unit() {
        return work_unit;
    }

    public void setWork_unit(String work_unit) {
        this.work_unit = work_unit;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getContract_number() {
        return contract_number;
    }

    public void setContract_number(String contract_number) {
        this.contract_number = contract_number;
    }

    public Timestamp getContract_term() {
        return contract_term;
    }

    public void setContract_term(Timestamp contract_term) {
        this.contract_term = contract_term;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPlace_of_domicile() {
        return place_of_domicile;
    }

    public void setPlace_of_domicile(String place_of_domicile) {
        this.place_of_domicile = place_of_domicile;
    }

    public String getService_location() {
        return service_location;
    }

    public void setService_location(String service_location) {
        this.service_location = service_location;
    }

    public String getFamilyInfo_liveAddress() {
        return familyInfo_liveAddress;
    }

    public void setFamilyInfo_liveAddress(String familyInfo_liveAddress) {
        this.familyInfo_liveAddress = familyInfo_liveAddress;
    }

    public String getFamilyInfo_peopleCount() {
        return familyInfo_peopleCount;
    }

    public void setFamilyInfo_peopleCount(String familyInfo_peopleCount) {
        this.familyInfo_peopleCount = familyInfo_peopleCount;
    }

    public String getEmploy_requirement() {
        return employ_requirement;
    }

    public void setEmploy_requirement(String employ_requirement) {
        this.employ_requirement = employ_requirement;
    }

    public String getFamilyInfo_serviceContent() {
        return familyInfo_serviceContent;
    }

    public void setFamilyInfo_serviceContent(String familyInfo_serviceContent) {
        this.familyInfo_serviceContent = familyInfo_serviceContent;
    }

    public String getFamilyInfo_houseArea() {
        return familyInfo_houseArea;
    }

    public void setFamilyInfo_houseArea(String familyInfo_houseArea) {
        this.familyInfo_houseArea = familyInfo_houseArea;
    }

    public String getFamilyInfo_dietaryHabit() {
        return familyInfo_dietaryHabit;
    }

    public void setFamilyInfo_dietaryHabit(String familyInfo_dietaryHabit) {
        this.familyInfo_dietaryHabit = familyInfo_dietaryHabit;
    }

    public String getFamilyInfo_other() {
        return familyInfo_other;
    }

    public void setFamilyInfo_other(String familyInfo_other) {
        this.familyInfo_other = familyInfo_other;
    }

    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }

    public Timestamp getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Timestamp add_time) {
        this.add_time = add_time;
    }

    public String getHighest_salary_received() {
        return highest_salary_received;
    }

    public void setHighest_salary_received(String highest_salary_received) {
        this.highest_salary_received = highest_salary_received;
    }

    public String getLowest_salary_received() {
        return lowest_salary_received;
    }

    public void setLowest_salary_received(String lowest_salary_received) {
        this.lowest_salary_received = lowest_salary_received;
    }

    public Timestamp getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Timestamp birthDay) {
        this.birthDay = birthDay;
    }

}
