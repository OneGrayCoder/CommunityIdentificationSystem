package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 16:10
 */
//通知表
public class Inform {
    private int inform_number;
    private String inform_content;
    private Timestamp inform_date;

    public Inform() {
    }

    public Inform(int inform_number, String inform_content, Timestamp inform_date) {
        this.inform_number = inform_number;
        this.inform_content = inform_content;
        this.inform_date = inform_date;
    }

    public int getInform_number() {
        return inform_number;
    }

    public void setInform_number(int inform_number) {
        this.inform_number = inform_number;
    }

    public String getInform_content() {
        return inform_content;
    }

    public void setInform_content(String inform_content) {
        this.inform_content = inform_content;
    }

    public Timestamp getInform_date() {
        return inform_date;
    }

    public void setInform_date(Timestamp inform_date) {
        this.inform_date = inform_date;
    }
}
