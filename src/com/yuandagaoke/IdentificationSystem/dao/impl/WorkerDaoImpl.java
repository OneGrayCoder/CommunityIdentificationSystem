package com.yuandagaoke.IdentificationSystem.dao.impl;

import com.yuandagaoke.IdentificationSystem.dao.WorkerDao;
import com.yuandagaoke.IdentificationSystem.pojo.*;
import com.yuandagaoke.IdentificationSystem.util.DataBasePool;
import com.yuandagaoke.IdentificationSystem.util.JdbcUtil;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 12:01
 */
public class WorkerDaoImpl implements WorkerDao {
    private BasicDaoUtil basic = new BasicDaoUtil();
    private JdbcUtil jdbcUtil = new JdbcUtil();

    @Override
    public int insertWorker(WorkerVO workerVO) {
        String sql = "insert into worker (worker_number, company_number, worker_name, \n" +
                "      worker_sex, worker_IDNumber, worker_birth, \n" +
                "      worker_age, worker_height, worker_mobile, \n" +
                "      worker_telephone, typeOfWork, worker_time, \n" +
                "      defect, album, permanent_address, \n" +
                "      address_Now, bankCardNumber, policyNo, \n" +
                "      language, worker_statu, marriage_status, \n" +
                "      certification_status, health_examination, \n" +
                "      healExamTime, skills, introduce, \n" +
                "      timeRequire, moneyRequire, live, \n" +
                "      eatDrink, input_time)\n" +
                "    values (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now())";
        List params = new ArrayList();
        params.add(workerVO.getCompany_number());
        params.add(workerVO.getWorker_name());
        params.add(workerVO.getWorker_sex());
        params.add(workerVO.getWorker_IDNumber());
        params.add(workerVO.getWorker_birth());
        params.add(workerVO.getWorker_age());
        params.add(workerVO.getWorker_height());
        params.add(workerVO.getWorker_mobile());
        params.add(workerVO.getWorker_telephone());
        params.add(workerVO.getTypeOfWork());
        params.add(workerVO.getWorker_time());
        params.add(workerVO.getDefect());
        params.add(workerVO.getAlbum());
        params.add(workerVO.getPermanent_address());
        params.add(workerVO.getAddress_Now());
        params.add(workerVO.getBankCardNumber());
        params.add(workerVO.getPolicyNo());
        params.add(arrToString(workerVO.getLanguage()));
        params.add(workerVO.getWorker_statu());
        params.add(workerVO.getMarriage_status());
        params.add(arrToString(workerVO.getCertification_status()));
        params.add(arrToString(workerVO.getHealth_examination()));
        params.add(workerVO.getHealExamTime());
        params.add(arrToString(workerVO.getSkills()));
        params.add(workerVO.getIntroduce());
        params.add(workerVO.getTimeRequire());
        params.add(workerVO.getMoneyRequire());
        params.add(workerVO.getLive());
        params.add(workerVO.getEatDrink());
        int key = jdbcUtil.updatePreparedStatementKey(sql, params);
        jdbcUtil.close();
        return key;
    }

    @Override
    public void updateWorker(WorkerVO workerVO) {
        String sql = "update worker\n" +
                "    set company_number = ?,\n" +
                "      worker_name = ?,\n" +
                "      worker_sex = ?,\n" +
                "      worker_IDNumber = ?,\n" +
                "      worker_birth = ?,\n" +
                "      worker_age = ?,\n" +
                "      worker_height = ?,\n" +
                "      worker_mobile = ?,\n" +
                "      worker_telephone = ?,\n" +
                "      typeOfWork = ?,\n" +
                "      worker_time = ?,\n" +
                "      defect = ?,\n" +
                "      album = ?,\n" +
                "      permanent_address = ?,\n" +
                "      address_Now = ?,\n" +
                "      bankCardNumber = ?,\n" +
                "      policyNo = ?,\n" +
                "      language = ?,\n" +
                "      worker_statu = ?,\n" +
                "      marriage_status = ?,\n" +
                "      certification_status = ?,\n" +
                "      health_examination = ?,\n" +
                "      healExamTime = ?,\n" +
                "      skills = ?,\n" +
                "      introduce = ?,\n" +
                "      timeRequire = ?,\n" +
                "      moneyRequire = ?,\n" +
                "      live = ?,\n" +
                "      eatDrink = ?\n" +
                "    where worker_number = ?";

        List params = new ArrayList();
        params.add(workerVO.getCompany_number());
        params.add(workerVO.getWorker_name());
        params.add(workerVO.getWorker_sex());
        params.add(workerVO.getWorker_IDNumber());
        params.add(workerVO.getWorker_birth());
        params.add(workerVO.getWorker_age());
        params.add(workerVO.getWorker_height());
        params.add(workerVO.getWorker_mobile());
        params.add(workerVO.getWorker_telephone());
        params.add(workerVO.getTypeOfWork());
        params.add(workerVO.getWorker_time());
        params.add(workerVO.getDefect());
        params.add(workerVO.getAlbum());
        params.add(workerVO.getPermanent_address());
        params.add(workerVO.getAddress_Now());
        params.add(workerVO.getBankCardNumber());
        params.add(workerVO.getPolicyNo());
        params.add(arrToString(workerVO.getLanguage()));
        params.add(workerVO.getWorker_statu());
        params.add(workerVO.getMarriage_status());
        params.add(arrToString(workerVO.getCertification_status()));
        params.add(arrToString(workerVO.getHealth_examination()));
        params.add(workerVO.getHealExamTime());
        params.add(arrToString(workerVO.getSkills()));
        params.add(workerVO.getIntroduce());
        params.add(workerVO.getTimeRequire());
        params.add(workerVO.getMoneyRequire());
        params.add(workerVO.getLive());
        params.add(workerVO.getEatDrink());
        params.add(workerVO.getWorker_number());

        jdbcUtil.updatePreparedStatement(sql, params);
    }

    @Override
    public void insertFamilyMember(familyMemberVO vo) {

        //先删除
        String sql = "delete from familymember where worker_number=" + vo.getWorker_number();
        jdbcUtil.updatePreparedStatement(sql);

        //在新增
        String[] relation = vo.getRelation();
        String[] member_name = vo.getMember_name();
        int[] age = vo.getAge();
        String[] telephone = vo.getTelephone();
        String[] work_place = vo.getWork_place();

        sql = "insert into familymember (member_number, worker_number, relation, \n" +
                "      member_name, age, telephone, \n" +
                "      work_place)\n" +
                "    values (null,?,?,?,?,?,?)";
        for (int i = 0; i < relation.length; i++) {
            jdbcUtil.updatePreparedStatement(sql, vo.getWorker_number(), relation[i], member_name[i],
                    age[i], telephone[i], work_place[i]);
        }

        jdbcUtil.close();
    }

    @Override
    public void insertJob_trainingVO(job_trainingVO vo) {

        //先删除
        String sql = "delete from job_training where worker_number=" + vo.getWorker_number();
        jdbcUtil.updatePreparedStatement(sql);

        //在新增
        int worker_number = vo.getWorker_number();
        String[] training_agency = vo.getTraining_agency();
        String[] training_content = vo.getTraining_content();
        String[] training_situation = vo.getTraining_situation();
        Date[] training_time = vo.getTraining_time();
        sql = "insert into job_training (training_number, worker_number, training_agency, \n" +
                "      training_content, training_situation, training_time\n" +
                "      )\n" +
                "    values (null,?,?,?,?,?)";
        for (int i = 0; i < training_agency.length; i++) {
            jdbcUtil.updatePreparedStatement(sql, worker_number, training_agency[i], training_content[i],
                    training_situation[i], training_time[i]);

        }
        jdbcUtil.close();
    }

    @Override
    public void insertWork_historyVO(work_historyVO vo) {

        //先删除
        String sql = "delete from work_history where worker_number=" + vo.getWorker_number();
        jdbcUtil.updatePreparedStatement(sql);

        //在新增
        int worker_number = vo.getWorker_number();
        String[] unit = vo.getUnit();
        String[] work_type = vo.getWork_type();
        String[] duty = vo.getDuty();
        Date[] work_time = vo.getWork_time();
        sql = "insert into work_history (history_number, worker_number, unit, \n" +
                "      work_type, duty, work_time\n" +
                "      )\n" +
                "    values (null,?,?,?,?,?)";
        for (int i = 0; i < unit.length; i++) {
            jdbcUtil.updatePreparedStatement(sql, worker_number, unit[i], work_type[i], duty[i], work_time[i]);
        }
        jdbcUtil.close();
    }

    @Override
    public List<Worker> query(Worker worker) {

        StringBuffer sql = new StringBuffer("select w.*,c.company_name from worker w ,company c where w.company_number=c.company_number  ");
        List params = new ArrayList();

        if (worker.getWorker_number() != 0) {
            sql.append(" and worker_number = ? ");
            params.add(worker.getWorker_number());
        }

        if (worker.getWorker_name() != null && !worker.getWorker_name().equals("")) {
            sql.append(" and worker_name like '%" + worker.getWorker_name() + "%' ");
        }

        if (worker.getWorker_sex() != null && !worker.getWorker_sex().equals("")) {
            sql.append(" and worker_sex = ? ");
            params.add(worker.getWorker_sex());
        }

        if (worker.getWorker_age() != 0) {
            sql.append(" and worker_age = ? ");
            params.add(worker.getWorker_age());
        }

        if (worker.getWorker_statu() != null && !worker.getWorker_statu().equals("")) {
            sql.append(" and worker_statu = ? ");
            params.add(worker.getWorker_statu());
        }

        if (worker.getSkills() != null && !worker.getSkills().equals("")) {
            sql.append(" and skills = ? ");
            params.add(worker.getSkills());
        }
        sql.append(" order by worker_number desc");
        List<Worker> workers = jdbcUtil.queryPreparedStatement(sql.toString(), Worker.class, params);
        jdbcUtil.close();
        return workers;
    }

    @Override
    public List<FamilyMember> queryFamilyMember(Integer worker_number) {

        String sql = "select * from familyMember where worker_number=" + worker_number;
        List<FamilyMember> familyMembers = jdbcUtil.queryPreparedStatement(sql, FamilyMember.class, null);
        jdbcUtil.close();
        return familyMembers;

    }

    @Override
    public List<Job_Training> queryJob_training(Integer worker_number) {

        String sql = "select * from job_training where worker_number=" + worker_number;
        List<Job_Training> job_trainings = jdbcUtil.queryPreparedStatement(sql, Job_Training.class, null);
        jdbcUtil.close();
        return job_trainings;

    }

    @Override
    public List<Work_History> queryWork_history(Integer worker_number) {

        String sql = "select * from work_history where worker_number=" + worker_number;
        List<Work_History> work_histories = jdbcUtil.queryPreparedStatement(sql, Work_History.class, null);
        jdbcUtil.close();
        return work_histories;

    }

    @Override
    public List<Company> queryCompany() {
        String sql = "select * from company";
        List<Company> companies = jdbcUtil.queryPreparedStatement(sql, Company.class, null);
        return companies;
    }

    @Override
    public List<Worker> queryByInfo(Worker worker, Worker w) {
        List<Worker> list = new ArrayList<Worker>();
        //检索工人功能,利用封装到worker中的信息来查找
        //需要查找显示到页面的数据有
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet res = null;
        String condition = "";
        int ageMax = worker.getWorker_age();
        int ageMin = w.getWorker_age();
        condition += "where worker_age >= " + ageMin + " and worker_age <= " + ageMax;
        String sex = worker.getWorker_sex();
        Date worker_time = worker.getWorker_time();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(worker_time);
        Timestamp WorkerTime = Timestamp.valueOf(format);
        String[] split = worker.getLanguage().split(" ");
        if (split.length == 1) {
            //说明只勾选了一项
            condition += " and language like %'" + split[0] + "%' ";
        } else {//不止一项
            for (String lang : split) {
                condition += " and language like %'" + lang + "%' ";
            }
        }
        //单选钮只能选择一个
        String sta = worker.getWorker_statu();
        condition += " and worker_statu = " + sta;
        String marriage_status = worker.getMarriage_status();
        condition += "and marriage_status = " + marriage_status;
        String[] split1 = worker.getCertification_status().split(" ");
        if (split1.length == 1) {
            condition += " and Certification_status like '%" + split1[0] + "%' ";
        } else {
            for (String s : split1) {
                condition += " and Certification_status like '%" + s + "%' ";
            }
        }

        String[] split2 = worker.getSkills().split(" ");
        if (split2.length == 1) {
            condition += " and skills like '%" + split2[0] + "%' ";
        } else {
            for (String s : split2) {//以后这种字符串拼接最好调用StringBuffer().append
                condition += " and skills like '%" + split2[0] + "%' ";
            }
        }
        System.out.println("最后的条件是:" + condition);
        String sql = "select worker_number,worker_name,worker_sex," +
                "worker_age,skills,money_Require,worker_statu,inputTime " + condition;
        con = DataBasePool.getConnection();
        try {
            pre = con.prepareStatement(sql);
            res = pre.executeQuery();
            while (res != null && res.next()) {
                Worker ww = new Worker();
                ww.setWorker_number(res.getInt("worker_number"));
                ww.setWorker_name(res.getString("worker_name"));
                ww.setWorker_sex(res.getString("worker_sex"));
                ww.setWorker_age(res.getInt("worker_age"));
                ww.setSkills(res.getString("money_Require"));
                ww.setWorker_statu(res.getString("worker_statu"));
                Timestamp inputTime = res.getTimestamp("inputTime");
                String value = String.valueOf(inputTime);
                ww.setInput_time(value);
                list.add(ww);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public String arrToString(String[] arr) {
        if (arr == null) return null;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i] + ",");
            }
        }

        return sb.toString();
    }


}
