<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--点击查看  具体的短消息内容-->
<link href="../css/INDEX.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE1 {	font-size: 24px;
	font-weight: bold;
}
-->
</style>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <script type="text/javascript" src="../javascript/validator.js"></script>
<script type="text/javascript" src="../js/public.js"></script>
<script type="text/javascript" src="../javascript/handleArchive.js"></script>
<script language="JavaScript">
function doDBClick(url,operator,type) {
  if (operator == false) {
    document.forms[0].action = url + "&op=view";
    document.forms[0].submit();
  } else {
    document.forms[0].action = url;
    document.forms[0].submit();
  }
}
</script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;内部短消息</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>
<br>
  <table width="96%" height="49" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    
    <tr>
      <td width="73" height="23" align="right" bgcolor="#FFFFFF">标题：</td>
      <td width="668" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${requestScope.messageThem}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">内容：</td>
      <td bgcolor="#FFFFFF"><textarea name="textarea7" id="textarea7" cols="45" rows="10">
        ${requestScope.content}
      </textarea></td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><input type="submit" name="searchbtn3" value="返  回" class="button_new" onClick="javascript:location.href='gsgl.jsp'" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
