package com.yuandagaoke.IdentificationSystem.service.impl;

import com.yuandagaoke.IdentificationSystem.dao.MessageDao;
import com.yuandagaoke.IdentificationSystem.dao.impl.MessageDaoImpl;
import com.yuandagaoke.IdentificationSystem.pojo.MessageInfo;
import com.yuandagaoke.IdentificationSystem.pojo.MessageShow;
import com.yuandagaoke.IdentificationSystem.pojo.SendMessage;
import com.yuandagaoke.IdentificationSystem.service.MessageService;

import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/20 18:08
 */
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao = new MessageDaoImpl();
    @Override
    public List<String> findCompany() {
        return messageDao.findCompany();
    }

    @Override
    public List<String> findName() {
        return messageDao.findName();
    }

    @Override
    public int findAccount(String name) {
        return messageDao.findAccount(name);
    }

    @Override
    public boolean addMessage(MessageInfo messageInfo, SendMessage sendMessage) {
        return messageDao.addMessage(messageInfo,sendMessage);
    }

    @Override
    public int findAccount_ByFName(String fullname) {
        return messageDao.findAccount_ByFName(fullname);
    }

    @Override
    public List<MessageShow> findMessage() {
        return messageDao.findMessage();
    }

    @Override
    public String findContent(int number) {
        return messageDao.findContent(number);
    }

    @Override
    public List<MessageShow> findBy_SenderStatu(String sender, int statu) {
        return messageDao.findBy_SenderStatu(sender,statu);
    }

    @Override
    public int totalRecords() {
        return messageDao.totalRecords();
    }

    @Override
    public List<MessageShow> changePage(int pageNow, int pageSize) {
        return messageDao.changePage(pageNow,pageSize);
    }
}
