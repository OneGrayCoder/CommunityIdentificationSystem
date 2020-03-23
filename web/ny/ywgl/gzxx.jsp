<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/ny/css/button.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
  <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/public.js"></script>
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


  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <form method="post" action="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=selectEmployer">
      <td width="67%" align="right" class="text" nowrap>&nbsp;姓名：
        <input type="text" id="name" name="name" maxlength="20" size="12" value="" class="input" required>
        &nbsp;&nbsp;性别：
        <input type="radio" name="sex" id="radio" value="男" checked >
        男
        <input type="radio" name="sex" id="radio2" value="女" >
        女 电话：
        <input type="text" id="statu" name="telephone" required maxlength="20" size="12" value="" class="input">
        状态：
        <select name="statu" id="select" class="input">
          <option>请选择</option>
          <option value="未雇佣">已经雇佣</option>
          <option value="已雇佣">未雇佣</option>
        </select>
        雇用职位：
        <select name="jobType" id="select2" class="input">
          <option selected>请选择</option>
          <option value="保姆">保姆</option>
          <option value="月嫂">月嫂</option>
          <option value="家教">家教</option>
          <option value="厨嫂">厨嫂</option>
          <option value="高级管家">高级管家</option>
          <option value="钟点工">钟点工</option>
          <option value="钟点工">早教</option>
          <option value="钟点工">护工</option>
          <option value="其他">其他</option>
        </select>
        <input type="submit" name="searchbtn" value="查  询" class="button_new" >
      </form>
        <input type="submit" name="searchbtn2" value="新  增" class="button_new"onClick="javascript:location.href='gzxx_xz.jsp'" >
        <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
    </tr>
  </table>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="3%">序号</td>
      <td width="12%" align="center" nowrap id=".name" ><strong>姓名</strong></td>
      <td width="11%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true"><strong>性别</strong></div></td>
      <td width="12%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true"><strong>年龄</strong></div></td>
      <td width="16%" align="center" nowrap id=".title" ><div align="center" orderBy="true"><strong>雇用</strong></div></td>
      <td width="13%" align="center" nowrap id=".register" ><div align="center" orderBy="true"><strong>接受薪资</strong></div></td>
      <td width="9%" align="center" nowrap id=".register" ><strong>状态</strong></td>
      <td width="14%" align="center" nowrap id=".submit_date" ><strong>录入日期</strong></td>
      <td width="10%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
    <c:forEach items="${requestScope.list}" var="c">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="3%">${c.employer_number} </td>
      <td align="center" nowrap>${c.employer_name}</td>
      <td height="14" align="center" nowrap>${c.employer_sex}</td>
      <td align="center" nowrap>${c.employer_age}</td>
      <td align="left" nowrap>${c.employ_requirement}</td>
      <td align="center" nowrap>${c.highest_salary_received}</td>
      <td align="center" nowrap>${requestScope.li.statu}</td>
      <td align="center" nowrap>${c.add_time}&nbsp; </td>
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=findThisEmployer&number=${c.employer_number}">查看</a> <a href="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changeEmployer&number=${c.employer_number}">修改</a> <a href="lsda.htm">历史档案</a></td>
    </tr>
    </c:forEach>
  </table>
  <table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第${requestScope.pageNow}页 共${requestScope.totalRecords}记录 分${requestScope.totalPages}页显示 </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                <input type="hidden" name="paginationAction" value="">
                <a href="javascript:void(0)" onclick="pageFirst()"><img src="${pageContext.request.contextPath}/ny/image/First.jpg" id="pageFirst"  alt="首页" width="18" height="13" border="0" >&nbsp;&nbsp;</a>
                <a href="javascript:void(0)" onclick="pagePrevious()"><img src="${pageContext.request.contextPath}/ny/image/Previous.gif" id="pagePrevious"   alt="上一页" width="14" height="13" border="0"  >&nbsp;&nbsp;</a>
                <a href="javascript:void(0)"  onclick="pageNext()"><img src="${pageContext.request.contextPath}/ny/image/Next.gif" id="pageNext"  alt="下一页" width="14" height="13" border="0" >&nbsp;&nbsp;</a>
                <a href="javascript:void(0)" onclick="pageLast()"><img src="${pageContext.request.contextPath}/ny/image/Last.gif" id="pageLast"  alt="尾页" width="18" height="13" border="0"  >&nbsp;&nbsp;</a>
                <a href="javascript:void(0)" onClick="turnPage()">前往</a>
                <input type=text size='4' id="pageSelect" onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' />页
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
</html>
