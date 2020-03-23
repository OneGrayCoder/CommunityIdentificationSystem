package com.yuandagaoke.IdentificationSystem.controller;

import com.yuandagaoke.IdentificationSystem.pojo.*;
import com.yuandagaoke.IdentificationSystem.service.WorkerService;
import com.yuandagaoke.IdentificationSystem.service.impl.WorkerSerciceImpl;
import com.yuandagaoke.IdentificationSystem.util.Conversion;
import com.yuandagaoke.IdentificationSystem.util.Pager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/16 11:41
 */
@WebServlet("/ny/WorkerServlet")
public class WorkerServlet extends BaseServlet {
    //进入新增页面
    public void to_insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        WorkerService workerService = new WorkerSerciceImpl();
        //查询公司信息
        List<Company> companies = workerService.queryCompany();
        request.setAttribute("companies",companies);
        request.getRequestDispatcher("rlzy/grxx_xz.jsp").forward(request,response);
    }

    //进入修改页
    public void to_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        WorkerService workerService = new WorkerSerciceImpl();
        //查询公司信息
        List<Company> companies = workerService.queryCompany();
        request.setAttribute("companies",companies);

        int worker_number = Integer.parseInt(request.getParameter("worker_number"));
        Worker worker = new Worker();
        worker.setWorker_number(worker_number);
        //查询工人信息
        Worker wk = workerService.query(worker).get(0);
        request.setAttribute("worker",wk);

        //查询家庭成员
        List<FamilyMember> familyMembers = workerService.queryFamilyMember(worker_number);
        request.setAttribute("familyMembers",familyMembers);

        //查询培训经历
        List<Job_Training> job_trainings = workerService.queryJob_training(worker_number);
        request.setAttribute("job_trainings",job_trainings);

        //查询工作经历
        List<Work_History> work_histories = workerService.queryWork_history(worker_number);
        request.setAttribute("work_histories",work_histories);

        request.getRequestDispatcher("rlzy/grxx_xg.jsp").forward(request,response);

    }

    //新增
    public void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //封装工人对象
        WorkerVO workerVO = new WorkerVO();
        Conversion.convert(workerVO,request);
        WorkerService workerService = new WorkerSerciceImpl();
        int key= workerService.insertWorker(workerVO);

        //封装家庭成员对象
        familyMemberVO fVO = new familyMemberVO();
        Conversion.convert(fVO,request);
        fVO.setWorker_number(key);
        workerService.insertFamilyMember(fVO);

        //封装岗前培训对象
        job_trainingVO jVO = new job_trainingVO();
        Conversion.convert(jVO,request);
        jVO.setWorker_number(key);
        workerService.insertJob_trainingVO(jVO);

        //封装工作经历对象
        work_historyVO wVO = new work_historyVO();
        Conversion.convert(wVO,request);
        wVO.setWorker_number(key);
        workerService.insertWork_historyVO(wVO);

        response.sendRedirect("/ny/WorkerServlet?act=query");
    }


    //修改
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        //封装工人对象
        WorkerVO workerVO = new WorkerVO();
        Conversion.convert(workerVO,request);
        WorkerService workerService = new WorkerSerciceImpl();
        workerService.updateWorker(workerVO);

        //封装家庭成员对象
        familyMemberVO fVO = new familyMemberVO();
        Conversion.convert(fVO,request);
        fVO.setWorker_number(workerVO.getWorker_number());
        workerService.insertFamilyMember(fVO);

        //封装岗前培训对象
        job_trainingVO jVO = new job_trainingVO();
        Conversion.convert(jVO,request);
        jVO.setWorker_number(workerVO.getWorker_number());
        workerService.insertJob_trainingVO(jVO);

        //封装工作经历对象
        work_historyVO wVO = new work_historyVO();
        Conversion.convert(wVO,request);
        wVO.setWorker_number(workerVO.getWorker_number());
        workerService.insertWork_historyVO(wVO);

        response.sendRedirect("/ny/WorkerServlet?act=query");
    }
    /**
     *    Pager<Worker> pager = new Pager<>();
     *         pager.setCurentPageIndex(1);
     *         pager.setCountPerpage(每页X条);
     *         pager.setBigList(查询到的大集合);
     *         pager.getRecordCount();//得到总条数
     *         pager.getSmallList();//得到小的集合(分页的当前页的记录)
     *
     */
    //搜索
    public void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String flag = request.getParameter("flag");

        Worker worker = new Worker();
        Conversion.convert(worker,request);
        WorkerService workerService = new WorkerSerciceImpl();
        List<Worker> workers = workerService.query(worker);

        //分页工具类
        String cp = request.getParameter("cp");
        Integer currentPage=1;
        if(cp!=null && !cp.equals("")){
            currentPage=Integer.parseInt(cp);
        }
        Pager<Worker> pager = new Pager<>();
        pager.setCurentPageIndex(currentPage);
        pager.setBigList(workers);

        request.setAttribute("pager",pager);

        if(flag!=null && !flag.equals("")){
            request.getRequestDispatcher("rlzy/grxx_ss.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("rlzy/grxx.jsp").forward(request,response);
        }

    }

    //查看
    public void grxx_ck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int worker_number = Integer.parseInt(request.getParameter("worker_number"));
        WorkerService workerService = new WorkerSerciceImpl();
        Worker worker = new Worker();
        worker.setWorker_number(worker_number);
        //查询工人信息
        Worker wk = workerService.query(worker).get(0);
        request.setAttribute("worker",wk);

        //查询家庭成员
        List<FamilyMember> familyMembers = workerService.queryFamilyMember(worker_number);
        request.setAttribute("familyMembers",familyMembers);

        //查询培训经历
        List<Job_Training> job_trainings = workerService.queryJob_training(worker_number);
        request.setAttribute("job_trainings",job_trainings);

        //查询工作经历
        List<Work_History> work_histories = workerService.queryWork_history(worker_number);
        request.setAttribute("work_histories",work_histories);

        request.getRequestDispatcher("rlzy/grxx_ck.jsp").forward(request,response);
    }


}
