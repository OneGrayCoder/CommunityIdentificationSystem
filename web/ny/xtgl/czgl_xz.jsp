<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE2 {font-size: 16px}
.STYLE3 {color: #FF0000}
-->
</style>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/ny/javascript/validator.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/public.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/ny/javascript/handleArchive.js"></script>


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
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;充值管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="79%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td width="67%" height="40" align="center" nowrap class="MENU_line1">充 值 缴 费</td>
    </tr>
    <tr>
      <td align="right" nowrap class="MENU_line1 STYLE2">&nbsp;</td>
    </tr>
  </table>
  <form method="post" action="${pageContext.request.contextPath}/ny/XTGLSvl?reqType=reCharge&companyName=${requestScope.companyName}">
  <table width="79%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr bgcolor="#FFFFFF">
      <td width="15%" align="right" bgcolor="#FFFFFF"><strong>充值帐户：</strong></td>
      <td width="20%">千福家政${requestScope.companyName}</td><!--公司名称,需要通过el表达式来获取,找到所有的公司名称-->
      <td width="25%" align="right"><strong>充值金额：</strong></td>
      <td width="40%"><input name="remoteAmount" type="text" id="textarea4" value="" size="12" class="pi">
        <span class="text"><span class="STYLE3">*
      </span></span></td>
    </tr>
    <tr bgcolor="#FFFFFF">
      <td width="15%" height="79" align="right"><strong>备注：</strong></td>
      <td colspan="3"><textarea name="ps" id="textarea35" cols="60" rows="5" ></textarea></td>
    </tr>
  </table>
<br>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><span class="STYLE3">
      <input type="submit" name="searchbtn3" value="保  存" class="button_new" >
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:history.back();" >
      <input type="hidden" name="mod" value="no">
&nbsp;&nbsp; </span></td>
  </tr>
</table>
  </form>
</body>
</html>
