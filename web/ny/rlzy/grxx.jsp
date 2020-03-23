<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >

<html>
<head>
    <title>Untitled Document</title>
    <base href="/" />
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/ny/css/button.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/public.js"></script>

</head>

<body>

<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
    <tr>
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;人力资源--&gt;工人管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>

<form action="${pageContext.request.contextPath}/ny/WorkerServlet" method="post">
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
        <tr>
            <td width="67%" align="right" class="text" nowrap>&nbsp;姓名：
                <input type="text" name="worker_name" maxlength="20" size="12" value="" class="input">
                &nbsp;&nbsp;性别：
                <input type="radio" name="worker_sex" id="radio" value="男">
                男
                <input type="radio" name="worker_sex" id="radio2" value="女">
                女 年龄：
                <input type="text" name="worker_age" maxlength="3" size="12" value="" class="input">
                状态：
                <select name="worker_statu" id="worker_statu" class="input">
                    <option value="">请选择</option>
                    <option value="在岗">在岗</option>
                    <option value="待岗">待岗</option>
                    <option value="其他">其他</option>
                </select>
                适合职位：
                <select name="skills" id="skills" class="input">
                    <option value="">请选择</option>
                    <option value="照顾婴儿">照顾婴儿</option>
                    <option value="带小孩">带小孩</option>
                    <option value="照顾老人">照顾老人</option>
                    <option value="粤菜">粤菜</option>
                    <option value="客家菜">客家菜</option>
                    <option value="煲烫">煲烫</option>
                    <option value="扫地">扫地</option>
                    <option value="拖地">拖地</option>
                    <option value="擦窗">擦窗</option>
                    <option value="洗衣">洗衣</option>
                    <option value="打蜡">打蜡</option>
                    <option value="通渠">通渠</option>
                    <option value="其它">其它</option>

                </select>
                <input type="hidden" name="act" value="query">
                <input type="submit" name="searchbtn" value="查  询" class="button_new">
                <input type="button" name="searchbtn2" value="新  增" class="button_new"
                       onClick="javascript:location.href='/ny/WorkerServlet?act=to_insert'">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>
<br>
<table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
        <td nowrap align="center" width="3%">编号</td>
        <td width="12%" align="center" nowrap id=".name"><strong>姓名</strong></td>
        <td width="11%" height="24" align="center" nowrap id=".name">
            <div align="center" orderBy="true"><strong>性别</strong></div>
        </td>
        <td width="12%" height="24" align="center" nowrap id=".phone">
            <div align="center" orderBy="true"><strong>年龄</strong></div>
        </td>
        <td width="16%" align="center" nowrap id=".title">
            <div align="center" orderBy="true"><strong>个人技能</strong></div>
        </td>
        <td width="13%" align="center" nowrap id=".register">
            <div align="center" orderBy="true"><strong>工资要求</strong></div>
        </td>
        <td width="9%" align="center" nowrap id=".register"><strong>状态</strong></td>
        <td width="15%" align="center" nowrap id=".submit_date"><strong>录入日期</strong></td>
        <td width="9%" align="center" nowrap id=".submit_date"><strong>操作</strong></td>
    </tr>

    <c:forEach items="${pager.smallList}" var="worker" varStatus="status">

        <tr align="center" class="td2" onmouseover="javascript:changeBgColorOnMouseOver(this);"
            onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
            <td nowrap align="center" width="3%">${worker.worker_number}</td>
            <td align="center" nowrap>${worker.worker_name}</td>
            <td height="14" align="center" nowrap>${worker.worker_sex}</td>
            <td align="center" nowrap>${worker.worker_age}</td>
            <td align="left" nowrap>${worker.skills}</td>
            <td align="center" nowrap>${worker.moneyRequire}</td>
            <td align="center" nowrap>${worker.worker_statu}</td>
            <td align="center" nowrap>${worker.input_time}</td>
            <td align="center" nowrap>
                <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=grxx_ck&worker_number=${worker.worker_number}">查看</a>
                <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=to_update&worker_number=${worker.worker_number}">修改</a>
            </td>
        </tr>

    </c:forEach>

</table>
<table width="96%" height="10" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td><input type="hidden" name="orderType" value="asc">
            <input type="hidden" name="orderFid" value=".submit_date">
            <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
                <tr>
                    <td nowrap width="45%" align="center"> 当前第${pager.curentPageIndex}页 共${pager.recordCount}记录 分${pager.pageCount}页显示</td>
                    <td nowrap width="55%" align="right">
                        <c:if test="${pager.curentPageIndex<=1}">
                            <img src="${pageContext.request.contextPath}/ny/image/First_no.gif" alt="第一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp
                            <img src="${pageContext.request.contextPath}/ny/image/Previous_no.jpg" alt="上一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp
                        </c:if>

                        <c:if test="${pager.curentPageIndex>1}">
                            <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=query&cp=1">
                                <img src="${pageContext.request.contextPath}/ny/image/First.jpg" alt="第一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp
                            </a>
                            <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=query&cp=${pager.curentPageIndex-1}">
                                <img src="${pageContext.request.contextPath}/ny/image/Previous.gif" alt="上一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp
                            </a>
                        </c:if>

                        <c:if test="${pager.curentPageIndex>=pager.pageCount}">
                            <img src="${pageContext.request.contextPath}/ny/image/Next_no.jpg" alt="下一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp
                            <img src="${pageContext.request.contextPath}/ny/image/Last_no.jpg" alt="最后一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp
                        </c:if>

                        <c:if test="${pager.curentPageIndex<pager.pageCount}">
                            <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=query&cp=${pager.curentPageIndex+1}">
                                <img src="${pageContext.request.contextPath}/ny/image/Next.gif" alt="下一页" width="14" height="13" border="0">&nbsp&nbsp&nbsp
                            </a>
                            <a href="${pageContext.request.contextPath}/ny/WorkerServlet?act=query&cp=${pager.pageCount}">
                                <img src="${pageContext.request.contextPath}/ny/image/Last.gif" alt="最后一页" width="18" height="13" border="0">&nbsp&nbsp&nbsp
                            </a>

                        </c:if>

                        <a href="javascript:this.document.AwaitForm.submit()" oncontextmenu="return false" onClick="goto()">前往</a>
                        <input type=text size='4' onlytype='int' onblur='checkTextBoxInput(this)' id='pageSelect'
                               value=''/>
                        页
                    </td>
                </tr>
            </table>

        </td>
    </tr>
</table>
<script>
    function goto(){
        var cp = document.getElementById("pageSelect").value;
        if(cp==''){
            alert('页码必须输入');
            return false;
        }

        window.location.href="/ny/WorkerServlet?act=query&cp="+cp;
    }

    function checkTextBoxInput(t){
        if(t.value==''){
            return;
        }else{
            var reg = /^[0-9]+$/;
            if(!reg.test(t.value)){
                alert('只能输入数字！！')
                t.value='';
            }
        }

    }
</script>
</body>
</html>
