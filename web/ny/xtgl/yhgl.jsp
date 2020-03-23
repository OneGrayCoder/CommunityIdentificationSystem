<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/public.js"></script>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<title>用户管理--列表</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body class="bodybg" onLoad="onLoadInTemplate('','用户管理--列表')">
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<SCRIPT LANGUAGE="JavaScript">
<!--
function xiugai() {
	document.forms[0].mod.value="yes";
	document.forms[0].submit();
}
function toInsertDengji(){
  if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
  var myForm = document.forms[0];
  myForm.mhd.value="toInsertDengji";
  myForm.submit();
 }
function toUpdateDengji(){
  if(document.forms.length>1){
    alert("注意:有两个或多个form存在,此方法可能不适用");
    return false;
  }
  if(checkSelect_me()==false)
   return false;
  var myForm = document.forms[0];
  myForm.mhd.value="toUpdateDengji";
  myForm.submit();
 }
function doDeleteDengji(){
  	var count = 0;
	var length = 0;
	try{
		 length = document.forms[0].id_1.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].id_1.checked)	{
				++count;
			}
		}catch(e){}
	}
	for(var i=0;i<document.forms[0].id_1.length;i++){
		if(document.forms[0].id_1[i].checked)
			count++;
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	}
	if(confirm("有"+count+"条记录被选中,您确定要删除吗？") == false){
		return false;
	}
  	document.forms[0].mhd.value="doDeleteDengji";
  	document.forms[0].submit();
	//////////
 }
//检查是否有选择记录
function checkSelect_me(){
	var count = 0;
	var length = 0;
	try{
		 length = document.forms[0].id_1.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].id_1.checked)	{
				++count;
			}
		}catch(e){}
	}

	for(var i=0;i<document.forms[0].id_1.length;i++){
		if(document.forms[0].id_1[i].checked)
			count++;
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	} else if (count >1){
		alert("请选择单条记录");
		return false;
	}

	return true;
}
//分页
function pageFirst() {
    window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=changePage&pageNow=1";
}
function pagePrevious() {
    window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=changePage&pageNow=${requestScope.pageNow-1}";
}
function pageNext() {
    window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=changePage&pageNow=${requestScope.pageNow+1}";
}
function pageLast() {
    window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=changePage&pageNow=${requestScope.totalPages}";
}



function turnPage(){
    var page = document.getElementById("pageSelect").value;
    if (page == ''){
        alert("不能为空!")
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=changePage&fullname="+c;
    }
}

//
function findByName(){
    var val = document.getElementById("serchByName").value;
    alert(val)
    if (val == ''){
        alert("不能为空!")
    } else{
        window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=queryUserByName&pageNow=1&fullname="+val;
    }
}



//通过用户名

//-->
</SCRIPT>
<SCRIPT LANGUAGE="JavaScript">
function doDBClick(url,operator) {
  if (operator == false) {
    alert("您没有权限");
  } else {
    document.forms[0].action = url;
    document.forms[0].submit();
  }
}

</SCRIPT>
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;用户管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<table width="100%" height="10"  border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td> </td>
  </tr>
</table>
<table width="94%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="23"><img src="${pageContext.request.contextPath}/ny/image/red_BODY_left.gif" width="23" height="23"></td>
    <td background="${pageContext.request.contextPath}/ny/image/red_BODY_bg.gif"><table width="90%"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td><table height="23"  border="0" cellpadding="0" cellspacing="0">
              <tr align="center">
                <td width="82" class="Column_blue">用户管理</td>
              </tr>
          </table></td>
        </tr>
    </table></td>
    <td width="15"><img src="${pageContext.request.contextPath}/ny/image/red_BODY_right.gif" width="15" height="23"></td>
  </tr>
</table>
<table width="94%"  border="0" align="center" cellpadding="0" cellspacing="0">
<form name="UserForm" method="POST" action="xz.htm">
<input type="hidden" name="mhd" value="toList">
  <tr>
    <td width="15" background="${pageContext.request.contextPath}/ny/image/red_BODY_leftbg.gif">&nbsp;</td>
    <td><table width="100%" height="10"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td> </td>
        </tr>
      </table>
      <table width="96%" height="30"  border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
        <tr>
            <td align="left" nowrap>
                <input type="radio" id="all" name="available" value="3" checked="checked" onClick="findAll()">所有
        		<input type="radio" id="normal" name="available" value="0" onClick="findNormal()">正常
        		<input type="radio" name="available" value="1" onClick="unUseable()">禁用
        		<input type="radio" id="del" name="available" value="2" onClick="deleteUser()">已删除
        	</td>
          <td width="67%" align="right" class="text" nowrap>&nbsp; 姓名：
<input type="text" name="serchByName" id="serchByName" maxlength="20" size="12" class="input">
<input type="button" name="select"  value="查询" class="button_new" onclick="findByName()">
<input type="button" name="insert" value="新增" onClick="javascript:location.href='${pageContext.request.contextPath}/ny/xtgl/yhgl_xz.htm';" class="button_new">

<input type="button" name="delete" value="删除" onClick="doUpdateAvailable()" class="button_new">

<input type="hidden" name="mod" value="no">
&nbsp;&nbsp; </td>
        </tr>
      </table>
      <table width="100%" height="10"  border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td> </td>
        </tr>
      </table>
      <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CAD6E8">
        <tr align="center" class="tdtitle">
	  <td nowrap align="center" width=10%><input type="checkbox" onClick="checkAll(this,'fid')"></td>
          <td nowrap align="center" onClick="orderBy(this)" id=".UIDF"><div align="center" orderBy="true">编号</div></td>
	  <td nowrap align="center" onClick="orderBy(this)" id=".user_name"><div align="center" orderBy="true">帐号</div></td>
          <td align="center" height="24" nowrap onClick="orderBy(this)"  id=".trueName"><div align="center" orderBy="true">姓名</div></td>
          <td align="center" height="24" nowrap onClick="orderBy(this)"   id=".email"><div align="center" orderBy="true">电子邮件</div></td>
          <td align="center" nowrap onClick="orderBy(this)"  id=".isAvailable"><div align="center" orderBy="true">帐号状态</div></td>
          <td align="center" nowrap>操作</td>
        </tr>

          <c:forEach items="${requestScope.listUser}" var="c">
	<tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);"  ondblclick="doDBClick('ck.htm',true);">
		  <td nowrap align="center" width=10%>
			<input type='checkbox' name='fid' value='${c.account_number}'><!--复选框中-->
		  </td>
          <td align="center">${c.account_number}&nbsp;</td>
		  <td align="left">${c.loginName}&nbsp;</td>
          <td height="14" align="left">
		      ${c.fullname}
		  </td>
          <td height="14" align="left">${c.email}&nbsp;</td>
          <td align="center">
          <font color="red">${c.enabled}</font>
	  </td>
          <td align="center">

          <a href="xg.htm">修改</a>      </td>
		</tr>
          </c:forEach>

      </table>
      <table width="500"  border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CBCBCB"><tr></tr></table>
      <table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td>
		  <input type="hidden" name="orderType" value="asc">
			<input type="hidden" name="orderFid" value=".UIDF">
		<table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
<tr>
<td nowrap width="45%" align="center"><!--下面这些都从域中取出来-->
当前第${requestScope.pageNow}页&nbsp;共${requestScope.totalRecords}条记录&nbsp;&nbsp; 分${requestScope.totalPages}页显示
</td>
<td nowrap width="55%" align="right">
<input type="hidden" name="currentPage" value="1">
<input type="hidden" name="paginationAction" value="">
    <a href="javascript:void(0)" onclick="pageFirst()"><img src="${pageContext.request.contextPath}/ny/image/First.jpg" id="pageFirst"  alt="首页" width="18" height="13" border="0" >&nbsp;&nbsp;</a>
<a href="javascript:void(0)" onclick="pagePrevious()"><img src="${pageContext.request.contextPath}/ny/image/Previous.gif" id="pagePrevious"   alt="上一页" width="14" height="13" border="0"  >&nbsp;&nbsp;</a>
<a href="javascript:void(0)"  onclick="pageNext()"><img src="${pageContext.request.contextPath}/ny/image/Next.gif" id="pageNext"  alt="下一页" width="14" height="13" border="0" >&nbsp;&nbsp;</a>
<a href="javascript:void(0)" onclick="pageLast()"><img src="${pageContext.request.contextPath}/ny/image/Last.gif" id="pageLast"  alt="尾页" width="18" height="13" border="0"  >&nbsp;&nbsp;</a>
<a href="javascript:void(0)" onClick="turnPage()">前往</a>
<input type=text size='4' id="pageSelect" onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' />页
</td>
</tr>
</table>

		  </td>
        </tr>
      </table></td>
    <td width="15" bordercolor="#FFCC6D" background="../image/red_BODY_rightbg.gif">&nbsp;</td>
  </tr>
</form></table>
<table width="94%"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="18"><img src="../image/red_BODY_downleft.gif" width="24" height="24"></td>
    <td background="../image/red_BODY_downbg.gif">&nbsp;</td>
    <td width="18"><img src="../image/red_BODY_downright.gif" width="24" height="24"></td>
  </tr>
</table>
</body>

<script>

	function deleteUser()//当用户点击已删除时:向客户端发出请求,查询已经被删除的用户
	{
		window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=findDeleteUser";
        document.getElementById("all").checked = true;
    }
    function findAll()//当用户点击时,查询正常用户
    {
        window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=queryUser";
        document.getElementById("normal").checked = true;
    }
    function findNormal()//当用户点击已删除时:向客户端发出请求,查询已经被删除的用户
    {
        window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=queryUser";
        document.getElementById("del").checked = true;
    }


	function doUpdateAvailable(){
  	var count = 0;
	var length = 0;
	var val;

	try{
		 length = document.forms[0].fid.length;
	} catch(e){
		alert("没有任何记录！");
		return false;
	}
	if (isNaN(length))	{
		try{
			if (document.forms[0].fid.checked)	{
				++count;
			}
		}catch(e){}
	}
	for(var i=0;i<document.forms[0].fid.length;i++){
		if(document.forms[0].fid[i].checked){
            val = document.forms[0].fid[i].value;//根据val的值判断是哪一条记录
            count++;
        }
	}
	if(count==0){
		alert("您没有选择任何记录！");
		return false;
	}

	if(confirm("有"+count+"条记录被选中,您确定要删除吗？") == false){
		return false;
	}else{//用户选择true//执行删除逻辑
	window.location.href = "${pageContext.request.contextPath}/ny/UserSvl?reqType=delete&account_number="+val;
    }
 }
 
 
 function toDistribute(uid){
	  document.forms[0].mhd.value="toDistribute";
	  var url=document.forms[0].action;
	  var keyValue="fid="+uid;
	  var index = url.indexOf("?");
	  if (index < 0) {
		url=url + "?" + keyValue;
	  } else {
		url=url + "&" + keyValue;
	  }
	  document.forms[0].action=url;
	  document.forms[0].submit();
	}
	
 function toUpdate(uid){
	  document.forms[0].mhd.value="toUpdate";
	  var url=document.forms[0].action;
	  var keyValue="fid="+uid;
	  var index = url.indexOf("?");
	  if (index < 0) {
		url=url + "?" + keyValue;
	  } else {
		url=url + "&" + keyValue;
	  }
	  document.forms[0].action=url;
	  document.forms[0].submit();
	}

//document.getElementsByName("available")[1].click();

</script>
</html>


</body>
</html>