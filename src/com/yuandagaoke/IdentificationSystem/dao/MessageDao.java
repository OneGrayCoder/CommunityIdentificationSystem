package com.yuandagaoke.IdentificationSystem.dao;

import com.yuandagaoke.IdentificationSystem.pojo.MessageInfo;
import com.yuandagaoke.IdentificationSystem.pojo.MessageShow;
import com.yuandagaoke.IdentificationSystem.pojo.SendMessage;

import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/20 18:08
 */
public interface MessageDao {
//寻找所有的公司名称
    List<String> findCompany();

    //寻找所有的用户名
    List<String> findName();

    //根据session中存储的用户名查找其账号
    int findAccount(String name);

    //添加短消息信息
    boolean addMessage(MessageInfo messageInfo, SendMessage sendMessage);

    //通过full查找用户
    int findAccount_ByFName(String fullname);


    List<MessageShow> findMessage();


    //通过编号查找内容
    String findContent(int number);


    List<MessageShow> findBy_SenderStatu(String sender,int statu);


    int totalRecords();

    List<MessageShow> changePage(int pageNow,int pageSize);
}
