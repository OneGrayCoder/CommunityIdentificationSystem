package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.ChargeDao;
import com.yuandagaoke.IdentificationSystem.pojo.ChargeView;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/23 13:03
 */
public class ChargeDaoImpl implements ChargeDao {
    private BasicDaoUtil basicDaoUtil = new BasicDaoUtil();

    @Override/* 找出所有充值记录*/
    public List<ChargeView> findChargeRecords() {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        List<ChargeView> list = new ArrayList<ChargeView>();
        //需要获得
        String sql = "select * from recharge_card";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst);
            while (res != null&&res.next()) {
                ChargeView chargeView = new ChargeView();
                chargeView.setRecharge_cardNumber(res.getInt(1));
                chargeView.setCreditCard_Number(res.getInt(2));
                chargeView.setCharge_Standard(res.getInt(3));
                chargeView.setAmtall(res.getInt(4));
                int rechargeCompanyNumber = res.getInt(6);//获得公司编号,根据编号获取公司名称
                String loginName = findLoginName(rechargeCompanyNumber);
                String companyName = findCompanyName(rechargeCompanyNumber);
                chargeView.setUsername(loginName);//需要获取登录名.
                chargeView.setCompany_name(companyName);
                chargeView.setBalance(res.getInt(5));
                String pointScript = getPointScript(rechargeCompanyNumber);
                chargeView.setPostScript(pointScript);//備注需要從充值記錄中
                Timestamp chargeTime = getChargeTime(rechargeCompanyNumber);
                chargeView.setRecharge_time(chargeTime);//需要从充值记录中获取时间
                list.add(chargeView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return list;
    }

    //傳入公司編號
    @Override
    public String findLoginName(int company){
        String name =  "";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select loginName from account,company,recharge_card where " +
                "     account.belongCompany = company.company_number and company.company_number = recharge_card.recharge_CompanyNumber and " +
                "recharge_CompanyNumber = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,company);
            if (res!=null&&res.next()){
                name = res.getString("LoginName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return name;

    }

    @Override
    public String findCompanyName(int companyNumber){
        String name =  "";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select company_name from company,recharge_card where recharge_card.recharge_CompanyNumber = company.company_number and company_number =?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,companyNumber);
            if (res!=null&&res.next()){
                name = res.getString("company_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return name;
    }

    //获取备注
    @Override
    public String getPointScript(int companyNumber){
        //需要从充值卡表中获取
        //根据充值之公司编号来获取记录
        String ps =  "";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select postScript from recharge_record,recharge_card where recharge_card.recharge_CompanyNumber =recharge_record.recharge_record_CompanyNumber and recharge_card.recharge_CompanyNumber = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,companyNumber);
            if (res!=null&&res.next()){
                ps = res.getString("postScript");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return ps;
    }


    @Override
    public Timestamp getChargeTime(int companyNumber){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Timestamp recharge_time = null;
        String sql = "select recharge_time from recharge_record,recharge_card where recharge_card.recharge_CompanyNumber =recharge_record.recharge_record_CompanyNumber and recharge_card.recharge_CompanyNumber = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,companyNumber);
            if (res!=null&&res.next()){
                recharge_time = res.getTimestamp("recharge_time");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return recharge_time;
    }

    /*充值
    * */
    @Override
    public boolean charge(String companyName, String ps, int chargeMoney) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        Timestamp recharge_time = null;
        //充值成功后,对应公司的余额应该增加
        //充值过后，充值卡和充值记录表中都应该有记录
        String sql = "insert into recharge_record values(null,?,?,?,?,?)";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            int companyNumber = getCompanyNumber(companyName);//0表示为总公司
            Date date = new Date();
            String format = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(date);
            con.setAutoCommit(false);
            Timestamp timestamp = Timestamp.valueOf(format);
            flag = basicDaoUtil.executeUpdate(pst,companyNumber,chargeMoney,0,timestamp,ps);
            if (flag){
                //如果flag插入成功,也要向充值卡中插入一条记录
                boolean b = insertChargeCard(companyNumber, chargeMoney);
                if (b){
                    con.commit();
                    System.out.println("是否成功"+b);
                }else{
                    System.out.println("失败");
                }
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return flag;
    }


    @Override
    public int getCompanyNumber(String companyName){
        int number = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select company_number from company where  company_name =?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basicDaoUtil.executeQuery(pst,companyName);
            if (res!=null&&res.next()){
                number = res.getInt("company_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return number;
    }

    //向充值卡中插入记录
    public boolean insertChargeCard(int companyNumber,int chargeMoney){
        //当用户充值时,需要判断充值卡中是否有这条记录，
        //如果有,只修改余额
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        boolean aNull = isNull(companyNumber);
        if (aNull){
            String sql = "insert into recharge_card values(null,?,?,?,?)";
            con = DataBasePool.getConnection();
            try {
                pst = con.prepareStatement(sql);//刷卡标准,5元每次
                int chargeCount = 0;//刷卡次数
                int chargeStand = 5;//刷卡标准
                int totalAmount = chargeCount*chargeStand;
                int balance = chargeMoney - totalAmount;
                if (balance<0){
                    balance = 0;
                }
                flag = basicDaoUtil.executeUpdate(pst,chargeCount,chargeStand,totalAmount,balance,companyNumber);
                System.out.println("添加部分的flag"+flag);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                basicDaoUtil.close(res,pst,con);
            }

        }else{//不是空的,我们只需要将余额更新即可
            String sql = "update recharge_card set balance = balance + ? where recharge_CompanyNumber = ?";
            con = DataBasePool.getConnection();
            try {
                pst = con.prepareStatement(sql);
                 flag = basicDaoUtil.executeUpdate(pst, chargeMoney, companyNumber);
                System.out.println("更新部分的flag"+flag);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return flag;
    }

    //判断是否是第一次充值
    public boolean isNull(int companyNumber){
        boolean flag = false;
        int result = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select count(*) from recharge_card where recharge_CompanyNumber = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);//刷卡标准,5元每次
            res = basicDaoUtil.executeQuery(pst, companyNumber);
            if (res !=null&&res.next()){
                result = res.getInt(1);
                if (result == 0){
                    //为空
                    flag = true;
                }else{
                    flag = false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            basicDaoUtil.close(res,pst,con);
        }
        return flag;
    }
}
