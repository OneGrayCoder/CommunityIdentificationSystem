package com.yuandagaoke.IdentificationSystem.controller;

import com.yuandagaoke.IdentificationSystem.pojo.Account;
import com.yuandagaoke.IdentificationSystem.service.UserService;
import com.yuandagaoke.IdentificationSystem.service.impl.UserServiceImpl;
import com.yuandagaoke.IdentificationSystem.util.MD5Tools;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @AUTUOR QXW
 * @CREATE 2020/3/15 7:41
 */
//数据库名称:统一为:idenSystem
//此servlet用作登录
//使用此系统的是中介公司
//登录身份有两个,一个是子公司，一个是总公司
//总公司拥有所有权限, 而子公司
//处理登录的逻辑
@WebServlet(value= "/ny/LoginSvl")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private static String codeChars = "1234567890abcdefghijklmnopqrstuvwxyz";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //此处判断应该执行什么逻辑执行各种逻辑
        String reqType = request.getParameter("reqType");
        if (reqType.equals("login")){
            login(request,response);
        }else if (reqType.equals("validator")){
            getValidator(request,response);
        }else if (reqType.equals("checkValidator")){
            System.out.println("你好");
        }
    }


    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        //进行加密
        String securityPwd = MD5Tools.md5(password);
        //从session中获取本次验证码
        String validator = request.getParameter("validator");
        HttpSession session = request.getSession();
        String validation_code = (String)session.getAttribute("validation_code");
        String info = "";
        String loginInfo = "";
        if ( validation_code != null&& validation_code.equalsIgnoreCase(validator)){
            Account acc = new Account();
            acc.setLoginName(username);
            acc.setPwd(securityPwd);
            boolean login = userService.login(acc);
            //将用户的登录名记录到session中
            session.setAttribute("username",username);
            session.setMaxInactiveInterval(60*10);
            Cookie c = new Cookie("username",username);
            c.setMaxAge(10*60);//设置当前应用下有效
            c.setPath(request.getServletContext().getContextPath());
            if (login){//登录成功,跳转到主页面
                response.sendRedirect("main.jsp");
            }else {
                loginInfo = "登录失败";
                request.setAttribute("loginInfo",loginInfo);
                request.getRequestDispatcher("../login.jsp").forward(request,response);
            }
        }else {
            info = "验证码错误";
            request.setAttribute("info",info);
            request.getRequestDispatcher("../login.jsp").forward(request,response);
        }


    }

    //获取验证码
    private void getValidator(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //获得验证码集合的长度
        int charsLength = codeChars.length();
        //下面3条是关闭客户端浏览器的缓冲区
        response.setHeader("ragma", "No-cache");
        response.setHeader("Cach-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //设置图形验证码的长宽
        int width = 90, height = 20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();//获得输出文字的graphics对象
        Random random = new Random();
        g.setColor(getRandomColor(180, 250));//背景颜色
        g.fillRect(0, 0, width, height);
        //设置初始字体
        g.setFont(new Font("Times New Roman",Font.ITALIC,height));
        g.setColor(getRandomColor(120, 180));//字体颜色
        StringBuilder validationCode = new StringBuilder();
        //验证码的随机字体
        String[] fontNames = {"Times New Roman","Book antiqua","Arial"};
        //随机生成3-5个验证码
        for (int i = 0; i < 3+random.nextInt(3); i++) {
            //随机设置当前验证码的字符的字体
            g.setFont(new Font(fontNames[random.nextInt(3)],Font.ITALIC,height));
            //随机获得当前验证码的字符
            char codeChar = codeChars.charAt(random.nextInt(charsLength));
            validationCode.append(codeChar);
            //随机设置当前验证码字符的颜色
            g.setColor(getRandomColor(10, 100));
            //在图形上输出验证码字符，x y随机生成
            g.drawString(String.valueOf(codeChar), 16*i+random.nextInt(7), height-random.nextInt(6));
        }
        //获得session对象
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(5*60);
        //将验证码保存在session对象中，key为validation_code
        session.setAttribute("validation_code", validationCode.toString());
        System.out.println("本次的验证码是:"+validationCode.toString());
        g.dispose();
        OutputStream os = response.getOutputStream();
        ImageIO.write(image,"JPEG",os);//以JPEG格式向客户端发送图形验证码
    }

    //获取颜色
    private static Color getRandomColor(int minColor, int maxColor){
        Random random = new Random();
        if(minColor>255)
            minColor = 255;
        if(maxColor>255)
            maxColor = 255;
        int red = minColor + random.nextInt(maxColor - minColor);
        int green = minColor + random.nextInt(maxColor - minColor);
        int blue = minColor + random.nextInt(maxColor - minColor);
        return new Color(red,green,blue);
    }
}
