package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/21 1:23
 */
//将要展示的信息封装到这个pojo类中
public class MessageShow {
    private Integer messageNumber;
    private String messageThem;
    private String sender;
    private int statu;
    private Timestamp messageDate;
    private String messageContent;

    public MessageShow() {
    }

    public MessageShow(Integer messageNumber, String messageThem, String sender, int statu, Timestamp messageDate, String messageContent) {
        this.messageNumber = messageNumber;
        this.messageThem = messageThem;
        this.sender = sender;
        this.statu = statu;
        this.messageDate = messageDate;
        this.messageContent = messageContent;
    }

    public Integer getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Integer messageNumber) {
        this.messageNumber = messageNumber;
    }

    public String getMessageThem() {
        return messageThem;
    }

    public void setMessageThem(String messageThem) {
        this.messageThem = messageThem;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
