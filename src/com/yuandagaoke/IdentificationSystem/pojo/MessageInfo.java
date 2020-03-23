package com.yuandagaoke.IdentificationSystem.pojo;

import java.sql.Timestamp;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:00
 */
//短消息表
public class MessageInfo {
    private Integer messageNumber;
    private String messageThem;
    private String messageContent;
    private Timestamp messageDate; //发送时间

    public MessageInfo() {}

    public MessageInfo(Integer messageNumber, String messageThem, String messageContent, Timestamp messageDate) {
        this.messageNumber = messageNumber;
        this.messageThem = messageThem;
        this.messageContent = messageContent;
        this.messageDate = messageDate;
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

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Timestamp messageDate) {
        this.messageDate = messageDate;
    }
}
