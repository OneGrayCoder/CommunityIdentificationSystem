package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:36
 */
//基础数据表
//可用作数据字典
public class BasicData {
    private int basicData_number;
    private String dataName;//基础数据名
    private String data_ps;//备注
    private int dataType;//基础数据类型
    /*
    * 关于数据类型
    * 1:教育程度
    *2:爱好
    *3:语言
    *4:证照状况
    * 5:体检状况
    * 6:个人技能
    * 7:雇佣类型
    * */
    public BasicData() {
    }

    public BasicData(int basicData_number, String dataName, String data_ps, int dataType) {
        this.basicData_number = basicData_number;
        this.dataName = dataName;
        this.data_ps = data_ps;
        this.dataType = dataType;
    }

    public int getBasicData_number() {
        return basicData_number;
    }

    public void setBasicData_number(int basicData_number) {
        this.basicData_number = basicData_number;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getData_ps() {
        return data_ps;
    }

    public void setData_ps(String data_ps) {
        this.data_ps = data_ps;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
