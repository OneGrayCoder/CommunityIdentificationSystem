<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<LINK rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ny/css/INDEX.css">
<HTML><HEAD><TITLE>96909社区生活服务中心身份确认系统</TITLE>
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script>
    //当用户点击超链接,向servlet发送获取验证码请求
    function changeValidator() {
        document.getElementById("img").src = "${pageContext.request.contextPath}/ny/LoginSvl?reqType=validator&time="+new Date().getMilliseconds();
    }


  </script>
  <style type="text/css">
  body{
    MARGIN: 0px;
    background: url(${pageContext.request.contextPath}/ny/image/l_bg.jpg);
    background-repeat: repeat-x;
  }
  .input {
	BORDER-BOTTOM: #a3a3a3 1px solid; BORDER-LEFT: #636562 1px solid; LINE-HEIGHT: 14px; HEIGHT: 14px; COLOR: #000000; FONT-SIZE: 12px; BORDER-TOP: #636562 1px solid; BORDER-RIGHT: #a3a3a3 1px solid
}
  .text {
	LINE-HEIGHT: 20px; COLOR: #3a3a39; FONT-SIZE: 12px
}
.outtable {
	BORDER-BOTTOM: #8b8c8d 1px dashed; BORDER-LEFT: #8b8c8d 1px dashed; BORDER-TOP: #8b8c8d 1px dashed; BORDER-RIGHT: #8b8c8d 1px dashed
}

    #img{
      position: relative;
      left: -17px;
      top: 5px;
    }
</style>
<style type="text/css">
<!--
.STYLE1 {color: #333333;
		 font-size: 12px;
 	  	 font-weight: bold;
		 }
-->
</style>
</HEAD>
<BODY style="MARGIN: 0px;" >
<TABLE cellSpacing=0 cellPadding=0 width=1001 align=center height=595>
  <TR>
    <TD background="${pageContext.request.contextPath}/ny/image/ov2.jpg"><TABLE width=650 height="378"  border="0"
      align=center 
      cellPadding=0 cellSpacing=0>
      <TR>
        <TD height="378" align=left  vAlign=middle><table width="65%" 
              border=0 align="right" cellpadding=0 cellspacing=0>
          <tr>
            <td width="10%" height="213">&nbsp;</td>
            <td width="90%" valign=top><p>&nbsp;</p>
              <table width="75%" border=0 align="right" cellpadding=0 cellspacing=0>
              <tr>
                <td class=text height=20 colspan=2><font 
                        color=red></font></td>
              </tr>
                <form method="post" action="${pageContext.request.contextPath}/ny/LoginSvl?reqType=login">
              <tr>
                <td width="34%" height=36 align=right class=STYLE1>用户名：</td>
                <td height="36" width="66%" align=left>
                  <input style="WIDTH: 120px" class="input" name="j_username" required />
                </td>
              </tr>
              <tr align=middle>
                <td height=20 align="right" class="STYLE1">密&nbsp;&nbsp;码：</td>
                <td height="20" align="left">
                  <input style="WIDTH: 120px" class="input"  type="password" name="j_password" required /></td>
              </tr>
                  <tr align="middle">
                    <td height="20" align="center"class="STYLE1">请输入验证码:</td>
                    <td  height="20" align="left">
                      <input style="width:60px;" id="validator"  class="input" type="text" name="validator" onblur="testValidator()" >
                    &nbsp; &nbsp;
                    <img id="img" src="${pageContext.request.contextPath}/ny/LoginSvl?reqType=validator" width="90" height="20" >
                      <br>
                    <a href="javascript:changeValidator()">看不清,下一张</a></td>
                    </td>
                  </tr>
              <tr align="middle">
                <td height="20" colspan="2">&nbsp;</td>
              </tr>
              <tr align="middle">
                <td height="20" colspan="2" align="center">
                  <input class="button_new" value="登 录" type="submit" name="Submit2">
                  &nbsp; &nbsp;
                  <input class="button_new" value="重 置" type="reset" name="Submit">
                  <input style="WIDTH: 60px" class="input"  type="text" value="${requestScope.info}" />
                  <input style="WIDTH: 60px" class="input"  type="text" value="${requestScope.loginInfo}" />
                </td>
              </tr>

                  <tr align="middle">
                    <td height="20" colspan="2" align="center">
                      <input class="button_new" value="点此直接进入" type="button" name="Submit2" onClick="javascript:location.href='${pageContext.request.contextPath}/ny/main.jsp'">
                      &nbsp; &nbsp;
                </form><!--用以获取错误信息-->
                  </tr>

              </table></td>
          </tr>
        </table></TD>
      </TR>
    </TABLE></TD>
  </TR></TABLE>
</BODY></HTML>
