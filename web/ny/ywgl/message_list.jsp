<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/ny/css/button.css" rel="stylesheet" type="text/css">
<html>
<head>
<title>Untitled Document</title>
  <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">

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

function queryMessage() {
    //点击查找,进行消息的查找
    var c = document.getElementById("sender").value;
    var d = document.getElementById("statu").value;
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?sender="+c+"&statu="+d;
}

function pageFirst() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changePage&pageNow=1";
}
function pagePrevious() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changePage&pageNow=${requestScope.pageNow-1}";
}
function pageNext() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changePage&pageNow=${requestScope.pageNow+1}";
}
function pageLast() {
    window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changePage&pageNow=${requestScope.totalPages}";
}



function turnPage(){
    var page = document.getElementById("pageSelect").value;
    if (page == ''){
        alert("不能为空!")
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/YWGLSvl?reqType=changePage&fullname="+c;
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
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
  <tr>
    <td width="67%" align="right" class="text" nowrap>     &nbsp;&nbsp;&nbsp;发送人：
      <select id="sender" name="sender">
          <c:forEach items="${requestScope.name}" var="d"><!--发送人,获取所有发送人-->
      <option value="${d}">${d}</option>
          </c:forEach>
      </select> &nbsp;&nbsp;&nbsp;
      状态：
       <select id="statu" name="statu"><!--0表示未读,一表示已读-->
      <option value="1">已读</option>
      <option value="0">未读</option>
      </select>
      <input type="button" name="searchbtn" value="查  询" class="button_new" onclick="queryMessage()">
      <input type="button" name="searchbtn2" value="新  增" class="button_new"onClick="javascript:location.href='${pageContext.request.contextPath}/ny/YWGLSvl?reqType=findCompany'" >
      <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
  </tr>
</table>
<br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="6%">序号</td>
      <td width="31%" align="center" nowrap id=".name" >标题</td>
      <td width="38%" align="center" nowrap id=".name" >发送人</td>
      <td width="38%" align="center" nowrap id=".name" >状态</td>
      <td width="38%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true">发送时间</div></td>
      <td width="21%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
<c:forEach items="${requestScope.messageShow}" var="message">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="6%">${message.messageNumber} </td>
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=messageShow&messageNumber=${message.messageNumber}&messageThem=${message.messageThem}">${message.messageThem} </a></td>
      <td align="center" nowrap>${message.sender}</td>
      <td align="center" nowrap> ${message.statu}</td>
      <td height="14" align="center" nowrap>${message.messageDate}</td><!--回复也指向添加短消息-->
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/ny/YWGLSvl?reqType=findCompany">回复</a>&nbsp;</td>
    </tr>
</c:forEach>
  </table>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第1页 共${requestScope.totalRecords}记录 分1${requestScope.totalPages}显示 </td>
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
