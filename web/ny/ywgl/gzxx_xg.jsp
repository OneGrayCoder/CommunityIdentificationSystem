<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

function getSex() {
    var c = "${list.employer_sex}";
    if (c == '男'){
        var elementById = document.getElementById("M");
        elementById.checked();
    }else{
        var w = document.getElementById("W");
        w.checked();
    }
}
</script>
</head>

<body onload="getSex()">

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
        <form method="post" action="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changeEmployer">
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="${requestScope.list.employer_name}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="sex" id="M" value="男">
男
  <input type="radio" name="sex" id="W" value="女">
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${requestScope.list.employer_age}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${requestScope.list.employer_nation}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${requestScope.list.employer_jiguan}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${requestScope.list.employer_education}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${requestScope.list.IDCardNumber}" size="40" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${requestScope.list.work_unit}" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="${requestScope.list.job}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">合同号：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea8" value="${requestScope.list.contract_number}" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">合同期限：</td>
      <td bgcolor="#FFFFFF"><input name="textarea9" type="text" id="textarea9" value="${requestScope.list.contract_term}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">联系电话：${requestScope.list.telephone}</td>
      <td align="center" bgcolor="#FFFFFF">手机</td>
      <td colspan="4" bgcolor="#FFFFFF"><input name="textarea10" type="text" id="textarea10" value="${requestScope.list.mobile}" size="44" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">住宅：</td>
      <td bgcolor="#FFFFFF"><input name="textarea11" type="text" id="textarea11" value="${requestScope.list.house}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="${requestScope.list.place_of_domicile}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="${requestScope.list.service_location}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="${requestScope.list.familyInfo_liveAddress}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="${requestScope.list.familyInfo_peopleCount}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="${requestScope.list.familyInfo_serviceContent}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="${requestScope.list.familyInfo_houseArea}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="${requestScope.list.familyInfo_dietaryHabit}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="${requestScope.list.familyInfo_other}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="center" nowrap bgcolor="#FFFFFF">要求服务等级：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="textarea20" type="text" id="textarea20" value="${requestScope.list.employ_requirement}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="textarea21" type="text" id="textarea21" value="${requestScope.list.agent}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">登记日期：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${requestScope.list.add_time}" size="65" class="pi"></td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><input type="submit" name="searchbtn3" value="保  存" class="button_new" ">
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='gzxx.htm'" >
      <input type="hidden" name="mod" value="no">
        </form>
    &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
