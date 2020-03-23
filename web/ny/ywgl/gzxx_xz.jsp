<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--雇主信息新增界面-->
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

function pageFirst() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=findEmployerList&pageNow=1";
}
function pagePrevious() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=employerChangePage&pageNow=${requestScope.pageNow-1}";
}
function pageNext() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=employerChangePage&pageNow=${requestScope.pageNow+1}";
}
function pageLast() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=employerChangePage&pageNow=${requestScope.totalPages}";
}



function turnPage(){
    var page = document.getElementById("pageSelect").value;
    if (page == ''){
        alert("不能为空!")
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=employerChangePage&pageNow="+c;
    }
}

</script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;雇主信息</td>
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
        <form method="post" action="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=addEmployer">
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="employer_name" type="text" id="textarea40" value="" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="employer_sex" id="radio12" value="男">
男
  <input type="radio" name="radio" id="radio13" value="女">
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="employer_age" type="text" id="textarea" value="" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="employer_nation" type="text" id="textarea2" value="" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="employer_jiguan" type="text" id="textarea5" value="" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="employer_education" type="text" id="textarea4" value="" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="IDCardNumber" type="text" id="textarea3" value="" size="40" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="work_unit" type="text" id="textarea6" value="" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td bgcolor="#FFFFFF"><input name="job" type="text" id="textarea7" value="" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">合同号：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="contract_number" type="text" id="textarea8" value="" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">合同期限：</td>
      <td bgcolor="#FFFFFF"><input name="contract_term" type="text" id="textarea9" value="" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">联系电话：</td>
        <td colspan="4" bgcolor="#FFFFFF"><input name="telephone" type="text" id="textarea11" value="" size="44" class="pi"></td>
        <td align="center" bgcolor="#FFFFFF">手机</td>
      <td colspan="4" bgcolor="#FFFFFF"><input name="mobile" type="text" id="textarea10" value="" size="44" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">住宅：</td>
      <td bgcolor="#FFFFFF"><input name="house" type="text" id="textarea11" value="" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="place_of_domicile" type="text" id="textarea12" value="" size="65" class="pi"></td>
    </tr>
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="service_location" type="text" id="textarea13" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="familyInfo_liveAddress" type="text" id="textarea14" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="familyInfo_peopleCount" type="text" id="textarea15" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="familyInfo_serviceContent" type="text" id="textarea16" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="familyInfo_houseArea" type="text" id="textarea17" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="familyInfo_dietaryHabit" type="text" id="textarea18" value="" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="familyInfo_other" type="text" id="textarea19" value="" size="44" class="pi"></td>
    </tr>
	 <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
      <td colspan="2" align="left" bgcolor="#FFFFFF">从<!--最低到最高-->
        <input name="lowest_salary_received" type="text" id="textarea11" value="" size="8" class="pi">
      到
      <input name="highest_salary_received" type="text" id="textarea23" value="" size="8" class="pi"></td>
      <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">&nbsp;</td>
      <td colspan="3" bgcolor="#FFFFFF">&nbsp;</td>
	 </tr>s
       <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">雇用：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input type="checkbox" name="employ_requirement" id="checkbox4" value="月嫂" />
        月嫂
&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox4" value="保姆" />
保姆&nbsp;&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox4" value="钟点" />
钟点&nbsp;&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox4" value="厨嫂" />
厨嫂
<input type="checkbox" name="employ_requirement" id="checkbox" value="清洁工" />
清洁工
&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox" value="护工" />
 护工&nbsp;&nbsp;
 <input type="checkbox" name="employ_requirement" id="checkbox" value="早教" />
 早教
&nbsp;&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox" value="家教" />
家教
&nbsp;&nbsp;
<input type="checkbox" name="employ_requirement" id="checkbox2" value="高级管家" />
高级管家<br>
备注：
<input name="textarea9" type="text" id="textarea9" value="" size="40" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="agent" type="text" id="textarea21" value="" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">登记日期：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="add_time" type="text" id="textarea22" value="" size="65" class="pi"></td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><input type="submit" name="searchbtn3" value="保  存" class="button_new" >
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='gzxx.htm'" >
      <input type="hidden" name="mod" value="no">
        </form>
    &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
