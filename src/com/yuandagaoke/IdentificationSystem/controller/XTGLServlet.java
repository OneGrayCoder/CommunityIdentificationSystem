package com.yuandagaoke.IdentificationSystem.controller;

import com.yuandagaoke.IdentificationSystem.pojo.ChargeView;
import com.yuandagaoke.IdentificationSystem.pojo.Company;
import com.yuandagaoke.IdentificationSystem.service.ChargeService;
import com.yuandagaoke.IdentificationSystem.service.CompanyService;
import com.yuandagaoke.IdentificationSystem.service.MessageService;
import com.yuandagaoke.IdentificationSystem.service.impl.ChargeServiceImpl;
import com.yuandagaoke.IdentificationSystem.service.impl.CompanyServiceImpl;
import com.yuandagaoke.IdentificationSystem.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/17 21:26
 */
//所有和系统管理有关的代码在这里进行
@WebServlet(value = "/ny/XTGLSvl")
//系统管理中除用户管理以外的业务在此处实现
public class XTGLServlet extends HttpServlet {
    private CompanyService companyService = new CompanyServiceImpl();
    private MessageService messageService = new MessageServiceImpl();
    private ChargeService chargeService = new ChargeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reqType = request.getParameter("reqType");
        if (reqType.equals("addCompany")){
            addCompany(request,response);
        }else if (reqType.equals("reCharge")){//充值管理
            reCharge(request,response);
        }else if (reqType.equals("findThisCompany")){
            //需要充值,要找到当前公司
            findThisCompany(request,response);
        }else if (reqType.equals("chargeManagement")){
            chargeManagement(request,response);
        }
    }

    private void chargeManagement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //找到所有公司,及其对应的
        //通过公司编号来寻找当前公司的用户名
        //另外需要一个类来展示数据
        System.out.println("CHARGEMANAGEMENT START");
        List<ChargeView> chargeRecords = chargeService.findChargeRecords();
        if (chargeRecords != null){
            request.setAttribute("chargeRecords",chargeRecords);
            request.getRequestDispatcher("xtgl/czgl.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('初始化失败');history.back()</script>");
        }
    }
    /*
    *获得当前充值的某个公司名称
    * */
    private void findThisCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String companyName = request.getParameter("companyName");
        request.setAttribute("companyName",companyName);
        request.getRequestDispatcher("xtgl/czgl_xz.jsp").forward(request,response);
    }

    /*
    * 充值管理-新增
    * */
    private void reCharge(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("RECHARGE START");
        //获得所有的公司
        //充值管理
        //需要获取当前公司名称
        //用户输入充值金额
        //用户输入备注
        String companyName = request.getParameter("companyName");//公司名
        String ps = request.getParameter("ps");//备注
        int  remoteAmounts = Integer.parseInt(request.getParameter("remoteAmount"));
        boolean charge = chargeService.charge(companyName, ps, remoteAmounts);
        if (charge){//充值成功,回到主页面
            /*response.getWriter().print("<script>window.alert('充值成功!')</script>");*/
            chargeManagement(request,response);
        }else{
            response.getWriter().print("<script>window.alert('初始化失败');history.back()</script>");
        }
    }

    /**
     * 添加公司
     *
     */
    private void addCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //添加公司的方法
        String companyAccount = request.getParameter("companyAccount");
        String companyName = request.getParameter("companyName");
        String desc = request.getParameter("desc");
        Company co = new Company();
        co.setCompany_account(companyAccount);
        co.setCompany_name(companyName);
        co.setDescription(desc);
        boolean b = companyService.addCompany(co);
        if (b){
            //跳转主页面
            request.getRequestDispatcher("xtgl/gsgl.jsp").forward(request,response);
        }else{
            response.getWriter().print("<script>window.alert('添加失败');history.back()</script>");
        }
    }


}
