<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/ny/css/button.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<script type="text/javascript" src="../js/public.js"></script>
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


  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>&nbsp;公司名称：
        <input type="text" name="searchName" maxlength="20" size="12" value="" class="input">
        &nbsp;&nbsp;&nbsp;&nbsp;公司帐号：
        <input type="text" name="searchName3" maxlength="20" size="12" value="" class="input">
 &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" name="searchbtn" value="查  询" class="button_new">
      &nbsp;&nbsp; </td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="3%">序号</td>
      <td width="19%" align="center" nowrap id=".name" >公司名称</td>
      <td width="8%" align="center" nowrap id=".name" >帐户名</td>
      <td width="9%" align="center" nowrap id=".name" >刷卡次数</td>
      <td width="7%" align="center" nowrap id=".name" >收费标准<strong>(元/次)</strong></td>
      <td width="12%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true"><strong>合计消费额(元)</strong></div></td>
      <td width="14%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true"><strong>帐户余额</strong><strong>(元)</strong></div></td>
      <td width="10%" align="center" nowrap id=".register" ><div align="center" orderBy="true"><strong>操作人</strong></div></td>
      <td width="9%" align="center" nowrap id=".register" ><strong>备注</strong></td>
      <td width="9%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
      <c:forEach items="${requestScope.chargeRecords}" var="c">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="3%">1${c.recharge_cardNumber}</td><!--此编号就是充值记录编号-->
      <td align="center" nowrap>千福家政公司${c.company_name}</td>
      <td align="center" nowrap>liuzhu${c.username}</td>
      <td align="center" nowrap>390${c.creditCard_Number}</td>
      <td align="center" nowrap>3${c.charge_Standard}</td>
      <td height="14" align="center" nowrap>1170${c.amtall}</td>
      <td align="center" nowrap>498${c.balance}</td>
      <td align="center" nowrap>系统管理员</td>
      <td align="center" nowrap>&nbsp;</td>
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/ny/XTGLSvl?reqType=findThisCompany&companyName=${c.company_name}">充值</a></td>
    </tr>
      </c:forEach>
    <tr align="center" class="td1"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td colspan="3" align="right" nowrap><strong>合计总额：</strong></td>
      <td height="14" align="left" nowrap><div align="center" class="STYLE1">390</div></td>
      <td height="14" align="left" nowrap><div align="center"><span class="STYLE1"></span></div></td>
      <td height="14" align="left" nowrap><div align="center" class="STYLE1">1170</div></td>
      <td height="14" align="left" nowrap><div align="center" class="STYLE1">498</div></td>
      <td height="14" align="left" nowrap>&nbsp;</td>
      <td height="14" align="left" nowrap>&nbsp;</td>
      <td height="14" align="left" nowrap>&nbsp;</td>
    </tr>
  </table>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第1页 共5记录 分1页显示 </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                  <input type="hidden" name="paginationAction" value="">
                  <img src="${pageContext.request.contextPath}/ny/image/First_no.gif" alt="第一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp <img src="${pageContext.request.contextPath}/ny/image/Previous_no.jpg" alt="上一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="${pageContext.request.contextPath}/ny/image/Next_no.jpg" alt="下一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp <img src="${pageContext.request.contextPath}/ny/image/Last_no.jpg" alt="最后一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp <a href="javascript:this.document.AwaitForm.submit()" oncontextmenu="return false" onClick="if(this.document.AwaitForm.pageSelect.value==''){ alert('页码必须输入');return false;}
 else {this.document.AwaitForm.paginationAction.value='gotoPage';}">前往</a>
                  <input type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' value=''/>
                页 </td>
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
</html>
