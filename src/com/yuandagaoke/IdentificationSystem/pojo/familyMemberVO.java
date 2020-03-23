package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:21
 */
//家庭成员表
public class familyMemberVO {
    private int worker_number;
    private String[] relation; //关系
    private String[] member_name;
    private int[] age;
    private String[] telephone;
    private String[] work_place;

    public familyMemberVO() {
    }

    public int getWorker_number() {
        return worker_number;
    }

    public void setWorker_number(int worker_number) {
        this.worker_number = worker_number;
    }

    public String[] getRelation() {
        return relation;
    }

    public void setRelation(String[] relation) {
        this.relation = relation;
    }

    public String[] getMember_name() {
        return member_name;
    }

    public void setMember_name(String[] member_name) {
        this.member_name = member_name;
    }

    public int[] getAge() {
        return age;
    }

    public void setAge(int[] age) {
        this.age = age;
    }

    public String[] getTelephone() {
        return telephone;
    }

    public void setTelephone(String[] telephone) {
        this.telephone = telephone;
    }

    public String[] getWork_place() {
        return work_place;
    }

    public void setWork_place(String[] work_place) {
        this.work_place = work_place;
    }
}
