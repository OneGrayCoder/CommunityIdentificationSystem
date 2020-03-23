<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/ny/css/button.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
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


function pageFirst() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=inform&pageNow=1";
}
function pagePrevious() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=informChangePage&pageNow=${requestScope.pageNow-1}";
}
function pageNext() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=informChangePage&pageNow=${requestScope.pageNow+1}";
}
function pageLast() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=informChangePage&pageNow=${requestScope.totalPages}";
}



function turnPage(){
    var page = document.getElementById("pageSelect").value;
    if (page == ''){
        alert("不能为空!")
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=informChangePage&pageNow="+c;
    }
}


function selectInform() {
    var c = document.getElementById("1").value;
    var d = document.getElementById("2").value;
    if (c == ''&&d==''){
        alert("不能为空");
        return false;
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=queryByRange&1="+c+"&2="+d+"&pageNow=1";
        return true;
    }
}


</script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;每日通知</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="91%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>从
        <input type="text" id="1" name="searchName" maxlength="20" size="12" value="" class="input">
        到
        <input type="text" id="2" name="searchName2" maxlength="20" size="12" value="" class="input">
        &nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
<input type="submit" name="searchbtn" value="查  询" class="button_new" onclick="return selectInform()">
        <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
    </tr>
  </table>
<br>
  <table width="91%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="3%">序号</td>
      <td height="24" align="center" nowrap id=".name" >提醒内容</td>
      <td width="9%" align="center" nowrap id=".submit_date" >通知时间</td>
    </tr>
    <c:forEach items="${requestScope.allInformation}" var="d">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="3%">${d.inform_number} </td>
      <td height="14" align="center" nowrap>${d.inform_content}</td>
      <td align="center" nowrap>${d.inform_date}</td>
    </tr>
    </c:forEach>
  </table>
<table width="91%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
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
