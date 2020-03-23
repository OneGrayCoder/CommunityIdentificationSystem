package com.yuandagaoke.IdentificationSystem.controller;

import com.yuandagaoke.IdentificationSystem.pojo.Account;
import com.yuandagaoke.IdentificationSystem.service.UserService;
import com.yuandagaoke.IdentificationSystem.service.impl.UserServiceImpl;
import com.yuandagaoke.IdentificationSystem.util.MD5Tools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/17 11:41
 */
//此处用来操作和用户有关的各种信息的信息
@WebServlet(value = "/ny/UserSvl",initParams = {@WebInitParam(name = "pageSize",value = "15")})
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先获得请求类型
        String reqType = request.getParameter("reqType");
        if (reqType.equals("addUser")){
            addUser(request,response);
        }else if (reqType.equals("queryUser")){
            queryUser(request,response,-1);
        }else if (reqType.equals("changePage")){
            changePage(request,response);
        }else if(reqType.equals("queryUserByName")){
            queryUserByName(request,response);
        }else if (reqType.equals("delete")){
            deleteUser(request,response);
        }else if(reqType.equals("findDeleteUser")){
            findDeleteUser(request,response);
        }


    }

    private void findDeleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //查找被删除的用户
        List<Account> listUser = userService.findDeleteUser();
        if (listUser != null){
            //就显示被删除的用户
            request.setAttribute("listUser",listUser);
            request.getRequestDispatcher("xtgl/yhgl.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('查找失败');window.history.back()</script>");
        }
    }

    //删除用户
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        int number = Integer.parseInt(request.getParameter("account_number"));
        boolean b = userService.addDeleteUser(number);
        boolean b1 = userService.deleteUser(number);
        if (b1){
            //回到主页面
            queryUser(request,response,-1);
        }else{
            response.getWriter().print("<script>window.alert('删除失败');window.history.back()</script>");
        }
    }

    //根据用户名查询用户信息
    private void queryUserByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        List<Account> listUser = userService.findByName(fullname, 1, pageSize);
        if (listUser != null){
            //将上面所有数据都存放到request域中
            request.setAttribute("listUser",listUser);
            request.getRequestDispatcher("xtgl/yhgl.jsp").forward(request,response);
        }else {
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }
    }

    //改变页数
    private void changePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        queryUser(request,response,pageNow);
    }

    private void queryUser(HttpServletRequest request, HttpServletResponse response,int pageNow) throws IOException, ServletException {
        //对应用户管理的查询用户的方法,查询用户信息,封装到list集合中
        //实现分页查询,需要三个参数,总页数

        System.out.println("我已经收到请求 QUERY USER");
        int totalRecords = 0;//总记录数
        int totalPages = 0; //
        totalRecords = userService.totalRecords();
        int pageSize = Integer.parseInt(getServletConfig().getInitParameter("pageSize"));
        if (totalRecords%pageSize==0){
            totalPages = totalRecords/pageSize;
        }else{
            totalPages = totalRecords/pageSize+1;
        }

        //判断是不是传递过来的,如果pageNow是传递过来的,说明只是呈现第一页
        if (pageNow == -1){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(request.getParameter("pageNow"));
        }

        if (pageNow <=0){
            pageNow = 1;
        }else if (pageNow> totalPages){
            pageNow = totalPages;
        }

        Account account = new Account();
        List<Account> listUser = userService.findAllUser(pageNow, pageSize);
        if (listUser != null){
            //将上面所有数据都存放到request域中
            request.setAttribute("totalRecords",totalRecords);
            request.setAttribute("totalPages",totalPages);
            request.setAttribute("pageNow",pageNow);
            request.setAttribute("listUser",listUser);
            request.getRequestDispatcher("xtgl/yhgl.jsp").forward(request,response);
        }else {
            response.getWriter().print("<script>window.alert('查询失败');window.history.back()</script>");
        }

    }



    private void addUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //接收新增用户表中传递过来的各种信息
        response.setContentType("text/html;charset=utf-8");
        System.out.println("添加用户");
        //登录用用户名
        String loginName = request.getParameter("loginName");
        //姓名
        String fullname = request.getParameter("fullname").trim();
        String sex = request.getParameter("sex");
        //用户名
        int username = Integer.parseInt(request.getParameter("username").trim());
        //两次密码的是否相同由前端验证
        String pwd = request.getParameter("pwd").trim();
        //对于密码,我们需要进行加密,将加密的方法单独作为一个方法
        String securityPwd = md5(pwd);/*加密后的*/
        System.out.println("加密后的密码是:"+securityPwd);
        String enable = request.getParameter("Enable");
        System.out.println(enable);
        String email = request.getParameter("email").trim();
        String companyLv = request.getParameter("companyLv");
        //所属公司
        int belongCompany = Integer.parseInt(request.getParameter("belongCompany"));

        Account account = new Account(null,username,fullname,email,securityPwd,enable,companyLv,belongCompany,loginName,sex);
        boolean b = userService.addUser(account);
        if (b){//如果添加成功,跳转到用户查询界面
            response.sendRedirect("xtgl/menu_xtgl.htm");
        }else {//查询失败
            response.getWriter().print("<script>window.alert('添加失败');widow.history.back()</script>");
        }
    }

    public String md5(String password){

        String s = MD5Tools.md5(password);
        return s;
    }

}
