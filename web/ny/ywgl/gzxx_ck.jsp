<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE2 {font-size: 16px}
-->
</style>
<head>
<title>Untitled Document</title>
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
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;客户管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费者资料登记表</td>
    </tr>
    <tr>
      <td align="right" nowrap class="MENU_line1 STYLE2">档案编号：GZ20006300223</td>
    </tr>
  </table>
<br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="15%" bgcolor="#FFFFFF">${requestScope.list.employer_name}</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF">
      ${requestScope.list.employer_sex}     </td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF">${requestScope.list.employer_age}</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF">${requestScope.list.employer_nation}</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF">${requestScope.list.employer_jiguan}&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF">${requestScope.list.employer_education}&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF">${requestScope.list.IDCardNumber}</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="5" bgcolor="#FFFFFF">${requestScope.list.work_unit}&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td bgcolor="#FFFFFF">${requestScope.list.job}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">合同号：</td>
      <td colspan="5" bgcolor="#FFFFFF">${requestScope.list.contract_number}&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">合同期限：</td>
      <td bgcolor="#FFFFFF">${requestScope.list.contract_term}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">联系电话：${requestScope.list.telephone}</td>
      <td align="center" bgcolor="#FFFFFF">手机</td>
      <td colspan="4" bgcolor="#FFFFFF">${requestScope.list.mobile}&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">住宅：</td>
      <td bgcolor="#FFFFFF">${requestScope.list.house}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF">${requestScope.list.place_of_domicile}&nbsp;</td>
    </tr>
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF">${requestScope.list.service_location}&nbsp;</td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF">${requestScope.list.familyInfo_liveAddress}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF">${requestScope.list.familyInfo_peopleCount}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF">>${requestScope.list.familyInfo_serviceContent}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF">${requestScope.list.familyInfo_houseArea}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF">${requestScope.list.familyInfo_dietaryHabit}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF">${requestScope.list.familyInfo_other}&nbsp;</td>
    </tr>
    <tr>
      <td align="center" nowrap bgcolor="#FFFFFF">要求服务等级：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF">${requestScope.list.employ_requirement}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF">${requestScope.list.agent}&nbsp;</td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">登记日期：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF">${requestScope.list.add_time}&nbsp;</td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><input type="submit" name="searchbtn3" value="保  存" class="button_new" onClick="javascript:location.href='gzxx.htm'">
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='gzxx.htm'" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
