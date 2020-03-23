package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.EmployerDao;
import com.yuandagaoke.IdentificationSystem.pojo.Employer;
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
 * @CREATE 2020/3/16 12:02
 */
public class EmployerDaoImpl implements EmployerDao {
    //
    private BasicDaoUtil basic = new BasicDaoUtil();

    @Override
    public int findCompanyNumber(int agent) {
        int companyNumber = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select company_number from deal where agent_number = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, agent);
            while(res != null&&res.next()){
                companyNumber = res.getInt("company_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return companyNumber;
    }

    @Override
    public boolean addEmployer(Employer em) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;

        String sql = "insert into employer values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            flag = basic.executeUpdate(pst, em.getCompany_number(), em.getEmployer_name(),
                    em.getEmployer_sex(), em.getEmployer_age(), em.getEmployer_nation(), em.getEmployer_jiguan(),
                    em.getEmployer_education(), em.getIDCardNumber(), em.getWork_unit(), em.getJob(), em.getContract_number(),
                    em.getContract_term(), em.getTelephone(), em.getMobile(), em.getHouse(), em.getPlace_of_domicile(), em.getService_location(),
                    em.getFamilyInfo_liveAddress(), em.getFamilyInfo_peopleCount(), em.getEmploy_requirement(), em.getFamilyInfo_serviceContent(),
                    em.getFamilyInfo_houseArea(), em.getFamilyInfo_dietaryHabit(), em.getFamilyInfo_other(),
                    em.getAgent(), em.getAdd_time(), em.getHighest_salary_received(), em.getLowest_salary_received(),
                    em.getBirthDay());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(null,pst,con);
        }
        return flag;
    }

    @Override
    public Map<Employer,String> findEmployerList(int pageNow, int pageSize) {
        Map<Employer,String> map = new HashMap<>();
        Employer employer = new Employer();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String sql = "select * from employer order by employer_number limit ?,?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst,(pageNow-1)*pageSize,pageSize);
            while(res != null&&res.next()){
                Employer em = new Employer();
                em.setEmployer_number(res.getInt("employer_number"));
                em.setEmployer_name(res.getString("employer_name"));
                em.setEmployer_sex(res.getString("employer_sex"));
                em.setEmployer_age(res.getInt("employer_age"));
                em.setEmploy_requirement(res.getString("employ_requirement"));
                String totalSalary = "";
                String highest_salary_received = res.getString("highest_salary_received");
                String lowest_salary_received = res.getString("lowest_salary_received");
                totalSalary = highest_salary_received +"-"+lowest_salary_received;
                em.setHighest_salary_received(totalSalary);
                em.setAdd_time(res.getTimestamp("add_time"));
                int agent = res.getInt("agent");
                String statuByAgent = findStatuByAgent(agent);
                map.put(em,statuByAgent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return map;
    }

    @Override
    public String findStatuByAgent(int agent) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        String statu = "";
        String sql = "select statu from deal where agent_number = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, agent);
            if (res != null&&res.next()){
                statu = res.getString("statu");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return statu;
    }


    @Override
    public int findEmployerCount(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int count = 0;
        String sql = "select count(*) from employer";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst);
            if (res != null&&res.next()){
                count = res.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return count;
    }

    @Override
    public List<Employer> findThisEmployer(int employer_number) {
        List<Employer> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int count = 0;
        String sql = "select * from employer where employer_number = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst,employer_number);
            if (res != null&&res.next()){
                res.getInt(2);
                Employer employer = new Employer(employer_number,res.getInt(2),res.getString(3),res.getString(4)
                        ,res.getInt(5),res.getString(6),res.getString(7),
                        res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),
                        res.getTimestamp(13),res.getString(14),res.getString(15),
                        res.getString(16),res.getString(17),res.getString(18),res.getString(19),res.getString(20),res.getString(21),
                        res.getString(22),res.getString(23),res.getString(24),res.getString(25),res.getInt(26),
                        res.getTimestamp(27),res.getString(28),res.getString(29),res.getTimestamp(30));
                list.add(employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return list;
    }

    @Override
    public List<Employer> selectEmployer(Employer emp, String statu) {
        List<Employer> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int count = 0;
        String sql = "select * from employer where employer_name = ? and employer_sex = ? and " +
                "telephone = ? and  jobType = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst,emp.getEmployer_name(),
                    emp.getEmployer_sex(),emp.getTelephone(),emp.getJob());
            while(res != null&&res.next()){
                Employer em = new Employer();
                em.setEmployer_number(res.getInt("employer_number"));
                em.setEmployer_name(res.getString("employer_name"));
                em.setEmployer_sex(res.getString("employer_sex"));
                em.setEmployer_age(res.getInt("employer_age"));
                em.setEmploy_requirement(res.getString("employ_requirement"));
                String totalSalary = "";
                String highest_salary_received = res.getString("highest_salary_received");
                String lowest_salary_received = res.getString("lowest_salary_received");
                totalSalary = highest_salary_received +"-"+lowest_salary_received;
                em.setHighest_salary_received(totalSalary);
                em.setAdd_time(res.getTimestamp("add_time"));
                int agent = res.getInt("agent");
                String statuByAgent = findStatuByAgent(agent);
               list.add(em);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return list;
    }


    @Override
    public int findAgentByStatu(String statu){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;
        int agent = 0;
        String sql = "select  agent_number from deal where statu = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            res = basic.executeQuery(pst, statu);
            if (res != null&&res.next()){
                agent = res.getInt("agent_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(res,pst,con);
        }
        return agent;
    }

    @Override
    public boolean changeEmployer(Employer em) {
        //修改某位用户
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        ResultSet res = null;
        ResultSet res1 = null;
        int number = 0;
        String sql1 = "select employer_number from employer where employer_name = ? and IDCardNumber = ?";
        String sql = "update  employer set company_number= ?," +
                "employer_name = ?,employer_sex = ?, employer_age = ?,employer_nation= ?,employer_jiguan = ?,employer_education = ?,IDCardNumber = ?," +
                "work_unit = ?,job = ?,contract_number= ?,contract_term= ?" +
                ",telephone = ?,mobile = ?,house= ?,place_of_domicile= ?,service_location= ?,familyInfo_liveAddress= ?,familyInfo_peopleCount= ?," +
                "employ_requirement= ?,familyInfo_serviceContent= ?,familyInfo_houseArea= ?,familyInfo_dietaryHabit= ?,familyInfo_other= ?,agent= ?," +
                "add_time= ?,highest_salary_received= ?,lowest_salary_received= ?,birthDay= ?)" +
                "where employer_number = ?";
        con = DataBasePool.getConnection();
        try {
            pst = con.prepareStatement(sql);
            pst1 = con.prepareStatement(sql1);
            res1 = basic.executeQuery(pst1, em.getEmployer_name(), em.getIDCardNumber());
            while(res1!= null&&res1.next()){
                number = res1.getInt("employer_number");
            }
            int agent = em.getAgent();
            int companyNumber = findCompanyNumber(agent);
            if (number != 0){
                flag = basic.executeUpdate(pst, companyNumber, em.getEmployer_name(),
                        em.getEmployer_sex(), em.getEmployer_age(), em.getEmployer_nation(), em.getEmployer_jiguan(),
                        em.getEmployer_education(), em.getIDCardNumber(), em.getWork_unit(), em.getJob(), em.getContract_number(),
                        em.getContract_term(), em.getTelephone(), em.getMobile(), em.getHouse(), em.getPlace_of_domicile(), em.getService_location(),
                        em.getFamilyInfo_liveAddress(), em.getFamilyInfo_peopleCount(), em.getEmploy_requirement(), em.getFamilyInfo_serviceContent(),
                        em.getFamilyInfo_houseArea(), em.getFamilyInfo_dietaryHabit(), em.getFamilyInfo_other(),
                        em.getAgent(), em.getAdd_time(), em.getHighest_salary_received(), em.getLowest_salary_received(),
                        em.getBirthDay());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            basic.close(null,pst,con);
        }
        return flag;
    }
}
