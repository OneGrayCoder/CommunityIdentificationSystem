package com.yuandagaoke.IdentificationSystem.pojo;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 15:07
 */
//短消息发送情况
public class SendMessage {
    private Integer number;
    private int messageNumber;
    private int sender;
    private int receiver;
    private int statu;//0:未读 1:已读

    public SendMessage() {
    }

    public SendMessage(Integer number, int messageNumber, int sender, int receiver, int statu) {
        this.number = number;
        this.messageNumber = messageNumber;
        this.sender = sender;
        this.receiver = receiver;
        this.statu = statu;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }
}
