package com.yuandagaoke.IdentificationSystem.service;

import com.yuandagaoke.IdentificationSystem.pojo.MessageInfo;
import com.yuandagaoke.IdentificationSystem.pojo.MessageShow;
import com.yuandagaoke.IdentificationSystem.pojo.SendMessage;

import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/20 18:07
 */
public interface MessageService {

    //当用户点击发送短消息时,查询出所有的公司和对应的账号的姓名
    List<String> findCompany();

    //查找所有姓名
    List<String> findName();

    //查找姓名
    int findAccount(String name);

    //添加短消息
    boolean addMessage(MessageInfo messageInfo, SendMessage sendMessage);


    //通过full查找编号
    int findAccount_ByFName(String fullname);


    //将列表所要展示的一对一的封装到这两个对象中
    List<MessageShow> findMessage();

    //通过编号查找内容
    String findContent(int number);

    //通过statu和sender查找
    List<MessageShow> findBy_SenderStatu(String sender,int statu);


    //总页数
    int totalRecords();

    //分页
    List<MessageShow> changePage(int pageNow,int pageSize);
}
