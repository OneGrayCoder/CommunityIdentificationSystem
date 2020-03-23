package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.MessageDao;
import com.yuandagaoke.IdentificationSystem.pojo.Account;
import com.yuandagaoke.IdentificationSystem.pojo.MessageInfo;
import com.yuandagaoke.IdentificationSystem.pojo.MessageShow;
import com.yuandagaoke.IdentificationSystem.pojo.SendMessage;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/20 18:08
 */
public class MessageDaoImpl implements MessageDao {
    private BasicDaoUtil basic = new BasicDaoUtil();
    @Override
    public List<String> findCompany() {
        List<String> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select distinct company_name from company;";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, null);
            while(res != null&&res.next()){
                String company_name = res.getString("company_name");
                list.add(company_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return list;
    }

    @Override
    public List<String> findName() {
        List<String> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select distinct fullname from account;";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, null);
            while(res != null&&res.next()){
                String name = res.getString("fullname");
                list.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return list;
    }

    @Override
    public int findAccount(String name) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select account_number from account where loginName like '%"+name+"%'";
        con = DataBasePool.getConnection();
        int anInt = 0;
        try {
            pst = con.prepareStatement(sql);
            //
            res = pst.executeQuery();
            while(res != null&&res.next()){
                anInt = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
        }
        return anInt;
    }

    @Override
    public boolean addMessage(MessageInfo messageInfo, SendMessage sendMessage) {
        //添加数据的同时向另一个表中存储数据
        boolean b = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        PreparedStatement pst1 = null;
        ResultSet res1 = null;
        PreparedStatement pst3 = null;
        String sql1 = "insert into sendmessage values(?,?,?,?,?)";
        String sql = "insert into messageinfo values(?,?,?,?)";
        con = DataBasePool.getConnection();
        int anInt = 0;
        try {
            pst = con.prepareStatement(sql);
            b = basic.executeUpdate(pst, null, messageInfo.getMessageThem(), messageInfo.getMessageContent(), messageInfo.getMessageDate());
            if (b){
                //如果插入成功,同时也要向另外一个表中插入数据
                String sql3 = "select messageNumber from messageinfo where messageContent = ?";
                pst3 = con.prepareStatement(sql3);
                int account = 0;
                ResultSet resultSet = basic.executeQuery(pst3, messageInfo.getMessageContent());
                while(resultSet!=null&&resultSet.next()){
                    account = resultSet.getInt(1);
                }
                pst1 = con.prepareStatement(sql1);
                boolean b1 = basic.executeUpdate(pst1,account, messageInfo.getMessageNumber(), sendMessage.getSender(), sendMessage.getReceiver(), sendMessage.getStatu());
                if (b1){
                    System.out.println("同时添加成功");
                }else{
                }
            }
            System.out.println("失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basic.close(res,pst,con);
            basic.close(res1,pst1,null);
        }
        return b;
    }

    @Override
    public int findAccount_ByFName(String fullname) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int account = 0;
        String sql = "select account_number from account where fullname = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
             res = basic.executeQuery(pst, fullname);
             while(res != null&&res.next()){
                 account = res.getInt(1);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<MessageShow> findMessage() {
       List<MessageShow> list = new ArrayList<>();
        //将表中的信息封装到这两个类中返回
        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pstd = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        ResultSet rest = null;
        ResultSet resultSet = null;
        String fullname = "";
        String sql = "select * from messageinfo";
        String sql1 = "select * from sendMessage where  messageNumber = ?";
        con  = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pstd = con.prepareStatement(sql1);
            res = basic.executeQuery(pst);
            while(res != null&&res.next()){
                MessageShow messageShow = new MessageShow();
                int number = res.getInt("messageNumber");
                 rest = basic.executeQuery(pstd, number);
                 if (rest != null&&rest.next()){
                     //对于一个短消息,可能只有一个短消息编号,所以用if循环
                     int sender = rest.getInt("sender");
                     int statu = rest.getInt("statu");
                     messageShow.setStatu(statu);
                     //通过发送人找出此人的姓名
                     String sql3 = "select fullname from account,sendmessage where account.account_number = sendmessage.sender and sendmessage.sender = ?";
                     preparedStatement = con.prepareStatement(sql3);
                     resultSet = basic.executeQuery(preparedStatement, sender);
                     if (resultSet!= null&&resultSet.next()){
                         fullname = resultSet.getString("fullname");
                     }
                 }
                 messageShow.setMessageNumber(number);
                 messageShow.setMessageThem(res.getString("messageThem"));
                 messageShow.setMessageContent(res.getString("messageContent"));
                 messageShow.setSender(fullname);
                 messageShow.setMessageDate(res.getTimestamp("messageDate"));
                String sql4 = "insert into messageshow values(?,?,?,?,?,?)";
                pre = con.prepareStatement(sql4);
                boolean b = basic.executeUpdate(pre,null, messageShow.getMessageThem(),
                        messageShow.getMessageContent(), messageShow.getSender(), messageShow.getStatu()
                        , messageShow.getMessageDate());

                if (b){
                    System.out.println("添加成功");
                }else{
                    System.out.println("添加失败");
                }
                 list.add(messageShow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
            basic.close(rest,pstd,con);
            basic.close(resultSet,preparedStatement,con);
        }
        return list;
    }

    @Override
    public String findContent(int number) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String content = "";
        String sql = "select messageContent from messageinfo where messageNumber = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, number);
            while(res != null&&res.next()){
                content = res.getString("messageContent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public List<MessageShow> findBy_SenderStatu(String sender1, int statu) {
        //通过发送人和状态查找信息
        List<MessageShow> list = new ArrayList<>();
        //将表中的信息封装到这两个类中返回
        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pstd = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement pre= null;
        ResultSet res = null;
        ResultSet re = null;
        ResultSet rest = null;
        ResultSet resultSet = null;
        String fullname = "";
        int messageNumber = 0;
        int sender = 0;
        String sql = "select sender from sendmessage,account where sendmessage.sender = account.account and account.fullname = ?";
        String sql1 = "select number from sendMessage where  sender = ? and statu = ?";
        con  = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pstd = con.prepareStatement(sql1);
            res = basic.executeQuery(pst);
            while(res != null&&res.next()){
                MessageShow messageShow = new MessageShow();//获取发送消息编号
                sender = res.getInt("sender");
                rest = basic.executeQuery(pstd, sender,statu);
                if (rest != null&&rest.next()){
                    //对于一个短消息,可能只有一个短消息编号,所以用if循环
                    messageNumber = rest.getInt("messageNumber");
                    //通过发送人找出此人的姓名
                    String sql3 = "select * from messageinfo where  messageNumber= ?";
                    preparedStatement = con.prepareStatement(sql3);
                    resultSet = basic.executeQuery(preparedStatement,messageNumber);
                    if (resultSet!= null&&resultSet.next()){
                        messageShow.setMessageNumber(messageNumber);
                        messageShow.setMessageThem(resultSet.getString("messageThem"));
                        messageShow.setMessageContent(resultSet.getString("messageContent"));
                        messageShow.setMessageDate(res.getTimestamp("messageDate"));
                    }
                }
                messageShow.setSender(sender1);
                messageShow.setStatu(statu);
                list.add(messageShow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
            basic.close(rest,pstd,con);
            basic.close(resultSet,preparedStatement,con);
        }
        return list;
    }

    @Override
    public int totalRecords() {
        //查找总记录数
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int totalRecords= 0;
        String sql = "select count(*) from messageshow";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst);
            while(res != null&&res.next()){
               totalRecords  = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalRecords;
    }

    //分页查询
    @Override
    public List<MessageShow> changePage(int pageNow, int pageSize) {
        List<MessageShow> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select *from messageshow order by messageNumber limit ?,?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, (pageNow - 1) * pageSize, pageSize);
            while(res != null&&res.next()){
                MessageShow me = new MessageShow();
                me.setMessageNumber(res.getInt(1));
                me.setMessageThem(res.getString(2));
                me.setMessageContent(res.getString(3));
                me.setSender(res.getString(4));
                me.setStatu(res.getInt(5));
                me.setMessageDate(res.getTimestamp(6));
                list.add(me);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
