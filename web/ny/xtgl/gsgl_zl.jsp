<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
<script language="javascript">
		function doTreeMenuFrameHandle(){
			var treeFrame = window.parent.frames["mainFrameSet"];
			var cols = treeFrame.cols;			
			var imgSrc = event.srcElement;
			if(document.all("frmTitle").style.display=="none"){
				treeFrame.cols = "190,*";
				switchPoint.innerHTML="<img src='${pageContext.request.contextPath}/ny/image/arrow.jpg' >"
				document.all("frmTitle").style.display="";
				imgSrc.title = "隐藏菜单";
			}else{
				treeFrame.cols = "10,*";
				switchPoint.innerHTML="<img src='${pageContext.request.contextPath}/ny/image/arrow_2.jpg' >"
				document.all("frmTitle").style.display="none";
				imgSrc.title = "显示菜单";
			}			
		}
</script>

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style></head>

<body >
<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td></td>
  </tr>
</table>
<TABLE width="100%" height="100%" border=0 cellPadding=0 cellSpacing=0>
  <TR>
    <TD width="180" align=middle vAlign=top noWrap id=frmTitle>
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="180" valign="top" bgcolor="#efefef"><iframe src="left_1b.htm" name="left" width="180" marginwidth="0" height="100%" marginheight="0" align="top" scrolling="no" frameborder="0"></iframe></td>
      </tr>
    </table>
    </TD>
    <TD>
    <TABLE width="10" height="100%" border=0 cellPadding=0 cellSpacing=0 background="../image/zl_bg.jpg">
      <SCRIPT>

function switchSysBar(){
if (document.all("frmTitle").style.display==""){
	switchPoint.innerHTML="<img src='${pageContext.request.contextPath}/ny/image/arrow_2.jpg' >"
	document.all("frmTitle").style.display="none"
}
else{
	switchPoint.innerHTML="<img src='${pageContext.request.contextPath}/ny/image/arrow.jpg' >"
	document.all("frmTitle").style.display=""
}
}
          </SCRIPT>
      <TR>
        <TD align="center" style="HEIGHT: 100%" onClick="doTreeMenuFrameHandle()"><BR>
                <BR>
                <BR>
                <BR>
                <BR>
                <BR>
<SPAN class=navPoint style="font-size: 9pt;" id=switchPoint title="关闭/打开左栏"><img src="../image/arrow.jpg" width="7" height="48" id="aaa"></SPAN><br>
<BR>
                <BR>
                <BR>
            <BR>
                <BR>
                <BR>
                <BR>
       <br>        </TD>
      </TR>     
    </TABLE>
    </TD>
  </TR>
</TABLE>
</body>
</html>
