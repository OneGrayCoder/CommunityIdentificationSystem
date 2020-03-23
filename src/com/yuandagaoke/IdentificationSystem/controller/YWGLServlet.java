package com.yuandagaoke.IdentificationSystem.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.yuandagaoke.IdentificationSystem.pojo.*;
import com.yuandagaoke.IdentificationSystem.service.*;
import com.yuandagaoke.IdentificationSystem.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

//此servlet负责业务管理的部分数据
@WebServlet(value = "/ny/YWGLSvl",initParams = @WebInitParam(name = "pageSize",value = "15"))
public class YWGLServlet extends HttpServlet {
    private MessageService messageService = new MessageServiceImpl();
    private InformService informService = new InformServiceImpl();
    private EmployerService employerService = new EmployerServiceImpl();
    private WorkerService workerService = new WorkerSerciceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");//首先获得请求类型
        //首先写短消息的部分
        if (reqType.equals("message")){//短消息部分
            message(request,response);
        }else if (reqType.equals("addMessage")){
            addMessage(request,response);
        } else if (reqType.equals("findCompany")){
            findCompanyAndName(request,response);
        }else if (reqType.equals("messageShow")){
            messageShow(request,response);
        }else if(reqType.equals("findMessage")){
            findMessage(request,response);
        }else if (reqType.equals("changePage")){
            changePage(request,response,-1);
        }else if (reqType.equals("turnPage")){
            turnPage(request,response);
        }else if (reqType.equals("inform")){               //每日通知部分
            dayInform(request,response,-1);
        }else if (reqType.equals("informChangePage")){
            informChangePage(request,response);
        }else if (reqType.equals("queryByRange")){
            queryByRange(request,response);
        }else if (reqType.equals("addEmployer")){//客户管理部分
            addEmployer(request,response);
        }else if (reqType.equals("findEmployerList")){
            findEmployerList(request,response,-1);
        }else if (reqType.equals("findThisEmployer")){
            findThisEmployer(request,response);
        }else if (reqType.equals("employerChangePage")){
            employerChangePage(request,response);
        }else if (reqType.equals("changeEmployer")){
            changeEmployer(request,response);
        }else if (reqType.equals("selectEmployer")){
            selectEmployer(request,response);
        }else if (reqType.equals("queryWorker")){//工人资料检索
            queryWorker(request,response);
        }
    }

    private void queryWorker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //工人资料检索
        //接收页面上的所有数据
        System.out.println("QueryWorker Start");
        WorkerVO wk = new WorkerVO();
        Worker worker1 = new Worker();
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        int ageMin = Integer.parseInt(request.getParameter("ageMin"));
        int ageMax = Integer.parseInt(request.getParameter("ageMax"));
        String jobTime = request.getParameter("jobTime");
        Timestamp timestamp = Timestamp.valueOf(jobTime);
        String education = request.getParameter("education");
        String like = "";
        String[] likes = request.getParameterValues("like");
        //存到数据库的这类数据都可以用字符串的solit方法类分割开来
        if (likes.length>0){
            if (likes.length !=1){
                for (String s:likes) {
                    like = s+"";
                }
            }else{
                like = likes[0]+" ";
            }
        }
        String[] language = request.getParameterValues("language");
        String languages = "";
        if (language.length>0){
            if (language.length!=1){
                for(String s:language){
                    languages+=s+" ";//加以空格,方便区分
                }
            }else{//只有一个
                languages += language[0]+" ";
            }
        }
        String otherLanguage = request.getParameter("otherLanguage");
        if (!otherLanguage.isEmpty()){
            languages += otherLanguage+" ";
        }
        System.out.println(languages);//打印查看结果
        String status = "";
        String statu = request.getParameter("statu");//单选钮
        if (!statu.isEmpty()) {//最多一个
            if (statu.equals("其他")){
                String otherStatu = request.getParameter("otherStatu");
                status += otherStatu;
            }else{
                status += statu;
            }
        }

        System.out.println("最后获取的"+status);
        String marriage_statuses = request.getParameter("marriage_status");
        String marry = "";
        if (!marriage_statuses.isEmpty()) {
            if (marriage_statuses.equals("其他")){
                String otherMarriageStatu = request.getParameter("otherMarriageStatu");
                marry += otherMarriageStatu;
            }else{
                marry += marriage_statuses;
            }
        }
        System.out.println(marry);//最多一个
        //证照状况
        String certification = "";
        String[] certification_statuses = request.getParameterValues("certification_status");
        if (certification_statuses.length>0){
            if (certification_statuses.length !=1){
                for(String cerfication_staus:certification_statuses){
                    certification += cerfication_staus+" ";
                }
            }else{
                certification += certification_statuses[0]+" ";
            }
        }
        System.out.println(certification);
        String skill = "";
        String[] skills = request.getParameterValues("skills");
        if (skills.length !=1){
            for (String sk:skills) {
                skill += sk+" ";
            }
        }else{//当用户只勾选了一个
            skill += skills[0]+" ";
        }
        //可能用户勾选了一些技能后又勾选了其他技能
        String otherSkills = request.getParameter("otherSkills");
        if (!otherSkills.isEmpty()){
            skill += otherSkills+" ";
        }
        Worker w = new Worker();
        System.out.println(skill);
        worker1.setWorker_name(name);
        worker1.setWorker_sex(sex);
        worker1.setWorker_age(ageMax);
        w.setWorker_age(ageMin);
        worker1.setWorker_time(timestamp);//工作时间
        //将自我介绍添加到education中
        worker1.setLanguage(languages);
        worker1.setWorker_statu(status);
        worker1.setMarriage_status(marry);
        worker1.setCertification_status(certification);
        worker1.setSkills(skill);
        //select worker_number,company_number,worker_name,workerage,idcardNumber,telephone,mobilePhone,defect()
        List<Worker> worker = workerService.queryByInfo(worker1, w);
        if(worker!=null){
            request.setAttribute("worker",worker);
            request.getRequestDispatcher("rlzy/grxx.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('检索失败,未添加数据');window.history.back()</script>");
        }
    }

    private void selectEmployer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //按照条件查找雇主
        Employer em = new Employer();
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String telephone = request.getParameter("telephone");
        String statu = request.getParameter("statu");
        String jobType = request.getParameter("jobType");
        em.setEmployer_name(name);
        em.setEmployer_sex(sex);
        em.setTelephone(telephone);
        em.setJob(jobType);
        List<Employer> list = employerService.selectEmployer(em, statu);
        if (list!=null){
            request.setAttribute("list",list);
            request.getRequestDispatcher("ywgl/gzxx.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('修改失败,未添加数据');window.history.back()</script>");
        }
    }

    //修改用户信息
    private void changeEmployer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String employer_name = request.getParameter("employer_name");
        String sex = request.getParameter("employer_sex");
        int age = Integer.parseInt(request.getParameter("employer_age"));
        String nation = request.getParameter("employer_nation");
        String jiguan = request.getParameter("employer_jiguan");
        String education = request.getParameter("employer_education");
        String idCardNumber = request.getParameter("IDCardNumber");
        String workUnit = request.getParameter("work_unit");
        String job = request.getParameter("job");
        String contractNumber = request.getParameter("contract_number");
        Timestamp contract_term1 = Timestamp.valueOf(request.getParameter("contract_term"));
        String telephone = request.getParameter("telephone");
        String mobile = request.getParameter("mobile");
        String house = request.getParameter("house");
        String place_of_domicile = request.getParameter("place_of_domicile");
        String service_location = request.getParameter("service_location");
        String familyInfo_liveAddress = request.getParameter("familyInfo_liveAddress");
        String familyInfo_peopleCount = request.getParameter("familyInfo_peopleCount");
        String[] employ_requirements = request.getParameterValues("employ_requirement");
        String requirements = "";
        for (String s :employ_requirements){
            requirements += s;
        }
        System.out.println(requirements);
        String familyInfo_serviceContent = request.getParameter("familyInfo_serviceContent");
        String familyInfo_houseArea = request.getParameter("familyInfo_houseArea");
        String familyInfo_dietaryHabit = request.getParameter("familyInfo_dietaryHabit");
        String familyInfo_other = request.getParameter("familyInfo_other");
        int agent = Integer.parseInt(request.getParameter("agent"));
        Timestamp addTime = Timestamp.valueOf(request.getParameter("add_time"));
        String highest_salary_received = request.getParameter("highest_salary_received");
        String lowest_salary_received = request.getParameter("lowest_salary_received");
        Timestamp birthDay = Timestamp.valueOf(request.getParameter("birthDay"));
        //交易公司的编号，可以通过经办人编号获取
        int companyNumber = employerService.findCompanyNumber(agent);
        Employer employer = new Employer(null,companyNumber,employer_name,sex,age,nation,jiguan,
                education,idCardNumber,workUnit,job,contractNumber,contract_term1,telephone,mobile,
                house,place_of_domicile,service_location,familyInfo_liveAddress,familyInfo_peopleCount,requirements,
                familyInfo_serviceContent,familyInfo_houseArea,familyInfo_dietaryHabit,familyInfo_other,agent,
                addTime,highest_salary_received,lowest_salary_received,birthDay);
        int number = Integer.parseInt(request.getParameter("number"));
        boolean b = employerService.changeEmployer(employer);
        if (b){//修改成功
            findEmployerList(request,response,-1);
        }else{
            response.getWriter().print("<script>window.alert('修改失败,未添加数据');window.history.back()</script>");        }

    }

    private void findThisEmployer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查看某位雇主的具体信息
         int number = Integer.parseInt(request.getParameter("number"));
        List<Employer> list = employerService.findThisEmployer(number);
        if (list!=null){
            request.setAttribute("list",list);
            request.getRequestDispatcher("ywgl/gzxx.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败,未添加数据');window.history.back()</script>");        }
    }

    //跳页
    private void employerChangePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int   pageNow = Integer.parseInt(request.getParameter("pageNow"));
        findEmployerList(request,response,pageNow);

    }

    private void findEmployerList(HttpServletRequest request, HttpServletResponse response,int pageNow) throws IOException, ServletException {
        //到主页面时查找所有雇主信息的方法
        //交易状态可以根据经办人编号来查找,每一个订单都有对应的交易状态
        //依然实现分页查询
        if (pageNow == -1){
            pageNow = 1;
        }else {

            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }
        int totalPages = 0;
        int totalRecords = employerService.findEmployerCount();
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        if (totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else{
            totalPages = totalRecords/pageSize+1;
        }
        Map<Employer, String> employerList = employerService.findEmployerList(pageNow, pageSize);
        if (employerList!=null){
            List<Employer> list = new ArrayList<>();
            List<String> li = new ArrayList<>();
            Set<Employer> employers = employerList.keySet();
            for (Employer  emp:employers) {
                list.add(emp);
                String s = employerList.get(emp);
                li.add(s);
            }
            System.out.println(list+" "+li);
            request.setAttribute("pageNow",pageNow);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("list",list);
            request.setAttribute("li",li);
            request.getRequestDispatcher("ywgl/gzxx.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败,为添加数据');window.history.back()</script>");        }
    }

    private void addEmployer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //添加客户的方法。
        String employer_name = request.getParameter("employer_name");
        String sex = request.getParameter("employer_sex");
        int age = Integer.parseInt(request.getParameter("employer_age"));
        String nation = request.getParameter("employer_nation");
        String jiguan = request.getParameter("employer_jiguan");
        String education = request.getParameter("employer_education");
        String idCardNumber = request.getParameter("IDCardNumber");
        String workUnit = request.getParameter("work_unit");
        String job = request.getParameter("job");
        String contractNumber = request.getParameter("contract_number");
        Timestamp contract_term1 = Timestamp.valueOf(request.getParameter("contract_term"));
        String telephone = request.getParameter("telephone");
        String mobile = request.getParameter("mobile");
        String house = request.getParameter("house");
        String place_of_domicile = request.getParameter("place_of_domicile");
        String service_location = request.getParameter("service_location");
        String familyInfo_liveAddress = request.getParameter("familyInfo_liveAddress");
        String familyInfo_peopleCount = request.getParameter("familyInfo_peopleCount");
        String[] employ_requirements = request.getParameterValues("employ_requirement");
        String requirements = "";
        for (String s :employ_requirements){
            requirements += s;
        }
        System.out.println(requirements);
        String familyInfo_serviceContent = request.getParameter("familyInfo_serviceContent");
        String familyInfo_houseArea = request.getParameter("familyInfo_houseArea");
        String familyInfo_dietaryHabit = request.getParameter("familyInfo_dietaryHabit");
        String familyInfo_other = request.getParameter("familyInfo_other");
        int agent = Integer.parseInt(request.getParameter("agent"));
        Timestamp addTime = Timestamp.valueOf(request.getParameter("add_time"));
        String highest_salary_received = request.getParameter("highest_salary_received");
        String lowest_salary_received = request.getParameter("lowest_salary_received");
        Timestamp birthDay = Timestamp.valueOf(request.getParameter("birthDay"));
        //交易公司的编号，可以通过经办人编号获取
        int companyNumber = employerService.findCompanyNumber(agent);
        Employer employer = new Employer(null,companyNumber,employer_name,sex,age,nation,jiguan,
                education,idCardNumber,workUnit,job,contractNumber,contract_term1,telephone,mobile,
                house,place_of_domicile,service_location,familyInfo_liveAddress,familyInfo_peopleCount,requirements,
                familyInfo_serviceContent,familyInfo_houseArea,familyInfo_dietaryHabit,familyInfo_other,agent,
                addTime,highest_salary_received,lowest_salary_received,birthDay);
        boolean b = employerService.addEmployer(employer);
        if (b){//添加成功跳转到主页面
            request.getRequestDispatcher("ywgl/gzxx.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('添加失败');window.history.back()</script>");
        }
    }

    private void queryByRange(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //每日通知部分通过范围来查找
        int min = Integer.parseInt(request.getParameter("1"));
        int max = Integer.parseInt(request.getParameter("2"));
        //根据这两个范围查询有多少条记录
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int totalPages = 0;
        int totalRecords = informService.findRangeCount(min, max);
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        if (totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else{
            totalPages = totalRecords/pageSize+1;
        }
        List<Inform> allInformation = informService.queryByRange(min, max);
        if (allInformation != null){
            request.setAttribute("pageNow",pageNow);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("allInformation",allInformation);
            request.getRequestDispatcher("ywgl/mrtz.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }
    }

    private void informChangePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //跳页
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        dayInform(request,response,pageNow);
    }


    //每日通知部分,
    private void dayInform(HttpServletRequest request, HttpServletResponse response,int pageNow) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        if (pageNow==-1){
            pageNow = 1;
        }else {
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }
        //获得总记录数
        int totalRecords = informService.totalRecords();
        int totalPages = 0;
        if (pageNow<=0){
            pageNow = 1;
        }else if (pageNow>totalRecords){
            pageNow = totalRecords;
        }
        if (totalRecords%pageSize == 0){
            totalPages = totalRecords/pageSize;
        }else {
            totalPages = totalRecords/pageSize+1;
        }
        List<Inform> allInformation = informService.findAllInformation(pageNow, pageSize);
        if (allInformation!= null){
            request.setAttribute("pageNow",pageNow);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("allInformation",allInformation);
            request.getRequestDispatcher("ywgl/mrtz.jsp").forward(request,response);
        }else {
            response.getWriter().print("<script>window.alert('页面加载失败');window.history.back()</script>");
        }

    }

    private void turnPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int pageNow = Integer.parseInt(request.getParameter("pageNow"));
       if (pageNow<=0){
           pageNow = 1;
       }
       changePage(request,response,pageNow);
    }

    private void changePage(HttpServletRequest request, HttpServletResponse response, int pageNow) throws ServletException, IOException {
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        //分页查询需要三个参数,总页数,总记录数,每页的记录
        int totalRecords = messageService.totalRecords();
        int totalPages = 0;
        if (pageNow != -1){
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }else{
            pageNow = 1;
        }
        if (pageNow <=0){
            pageNow = 1;
        }else if (pageNow>totalRecords){
            pageNow = totalRecords;
        }
        if (totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else{
            totalPages = totalRecords/pageSize+1;
        }
        List<MessageShow> messageShow = messageService.changePage(pageNow, pageSize);
        if (messageShow!=null){
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("messageShow",messageShow);
            request.getRequestDispatcher("ywgl/message_list.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }
    }

    private void findMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据发送人和发送状态查找短消息
        String sender = request.getParameter("sender");
        int statu = Integer.parseInt(request.getParameter("statu"));
        List<MessageShow> messageShow = messageService.findBy_SenderStatu(sender, statu);
        if (messageShow != null){
            request.setAttribute("messageShow",messageShow);
            request.getRequestDispatcher("ywgl/message_list.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }
    }

    private void messageShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //点击标题,出现对应标题的内容
        int messageNumber = Integer.parseInt(request.getParameter("messageNumber"));
        String messageThem = request.getParameter("messageThem");
        String content = messageService.findContent(messageNumber);
        List<String> name = messageService.findName();
        request.setAttribute("name",name);
        request.setAttribute("messageThem",messageThem);
        request.setAttribute("content",content);
        request.getRequestDispatcher("ywgl/message_show.jsp").forward(request,response);
    }

    private void findCompanyAndName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询出所有公司和该公司下对应的成员
        List<String> name = messageService.findName();
        List<String> company = messageService.findCompany();
        if (name != null&&company != null ){
            request.setAttribute("company",company);
            request.setAttribute("name",name);
            request.getRequestDispatcher("ywgl/message_add.jsp").forward(request,response);
        }
    }



    private void addMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加短消息
        response.setContentType("text/html;charset=UTF-8");
        SendMessage sed = new SendMessage();
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String receiver = request.getParameter("name");
        //需要通过接收者姓名获取编号
        int account_byFName = messageService.findAccount_ByFName(receiver);
        //发送人就是当前登录此系统的用户,如果没有登录,就为0
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        //通过登录名获取该用户编号
        int account = messageService.findAccount(username);
        //0表示未读
        int status = 0;
        //获取发送时间
        Date d = new Date();
        Timestamp time = getTime(d);
        MessageInfo messageInfo = new MessageInfo(null,title,content,time);
        sed.setNumber(null);
        sed.setMessageNumber(0);//暂时设为0
        sed.setSender(account);
        sed.setReceiver(account_byFName);
        sed.setStatu(0);
        //先把信息存储再短消息表中
        boolean b = messageService.addMessage(messageInfo,sed);
        if (b){
            //如果添加成功,再向表中添加其他数据
            //跳转到主页面
            request.getRequestDispatcher("ywgl/message_list.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('添加失败');window.history.back()</script>");
        }
    }

    private void message(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //有五列信息
        //序号 标题 发送人 状态 发送时间
        //点击标题可以获取到内容()
        //最终转向这个页面 message_list.jsp
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        int totalRecords = messageService.totalRecords();
        int totalPages = 0;
        if (pageNow != -1){
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }else{
            pageNow = 1;
        }
        if (pageNow <=0){
            pageNow = 1;
        }else if (pageNow>totalRecords){
            pageNow = totalRecords;
        }
        if (totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else{
            totalPages = totalRecords/pageSize+1;
        }
        List<MessageShow> messageShow = messageService.findMessage();
        HttpSession session = request.getSession();
        if (messageShow != null){
            //分离两个对象
            session.setMaxInactiveInterval(60*10*10);
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("messageShow",messageShow);
            request.getRequestDispatcher("ywgl/message_list.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }

    }

    private Timestamp getTime(Date date){//转换时间
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp timestamp = Timestamp.valueOf(format);
        return timestamp;
    }

}
