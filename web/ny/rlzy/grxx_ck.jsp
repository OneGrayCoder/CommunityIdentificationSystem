<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style type="text/css">
    <!--
    .STYLE1 {
        font-size: 24px;
        font-weight: bold;
    }

    -->
</style>
<head>
    <title>Untitled Document</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link href="${pageContext.request.contextPath}/ny/css/INDEX.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/ny/javascript/validator.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/public.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ny/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/ny/javascript/handleArchive.js"></script>


</head>

<body>

<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
    <tr>
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;人力资源--&gt;工人管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>


<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="67%" height="40" align="center" nowrap class="MENU_line1">工人资料登记表</td>
    </tr>
</table>
<br>
<form action="${pageContext.request.contextPath}/ny/WorkerServlet" method="post">
    <table width="96%" height="577" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3"
           class="text_lb">
        <tr>
            <td width="118" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
            <td width="284" bgcolor="#FFFFFF">${worker.worker_number}</td>
            <td width="104" align="right" bgcolor="#FFFFFF">所属公司：</td>
            <td width="289" bgcolor="#FFFFFF">${worker.company_name}</td>
            <td width="138" rowspan="6" align="center" valign="middle" bgcolor="#FFFFFF">相片</td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
            <td bgcolor="#FFFFFF">${worker.worker_name}</td>
            <td align="right" bgcolor="#FFFFFF">性别：</td>
            <td bgcolor="#FFFFFF">
                ${worker.worker_sex}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
            <td bgcolor="#FFFFFF">${worker.worker_IDNumber}</td>
            <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
            <td bgcolor="#FFFFFF">${worker.worker_birth}</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FFFFFF">年龄：</td>
            <td bgcolor="#FFFFFF">${worker.worker_age}</td>
            <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
            <td bgcolor="#FFFFFF">${worker.worker_height}</td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FFFFFF">手机：</td>
            <td bgcolor="#FFFFFF">${worker.worker_mobile}</td>
            <td align="right" bgcolor="#FFFFFF">电话：</td>
            <td bgcolor="#FFFFFF">${worker.worker_telephone}</td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
            <td bgcolor="#FFFFFF">${worker.typeOfWork}</td>
            <td align="right" bgcolor="#FFFFFF">从业时间：</td>
            <td bgcolor="#FFFFFF">${worker.worker_time}</td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
            <td bgcolor="#FFFFFF">${worker.defect}</td>
            <td align="right" bgcolor="#FFFFFF">教育程度：</td>
            <td bgcolor="#FFFFFF">
                ${worker.album}&nbsp;
            </td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">户籍地址：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.permanent_address}&nbsp;
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">现住地址：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.address_Now}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">银行卡号：</td>
            <td bgcolor="#FFFFFF">${worker.bankCardNumber}</td>
            <td align="right" bgcolor="#FFFFFF">保险单号：</td>
            <td colspan="2" bgcolor="#FFFFFF">${worker.policyNo}</td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">语言：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.language}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">状态：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.worker_statu}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">婚姻状况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.marriage_status}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">证照状况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.certification_status}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">体检情况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="68%" height="28" bgcolor="#FFFFFF">
                            ${worker.health_examination}
                        </td>

                        <td width="11%" align="right" bgcolor="#FFFFFF">体检时间：</td>
                        <td width="21%" bgcolor="#FFFFFF">
                            ${worker.healExamTime}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" nowrap bgcolor="#FFFFFF">家庭成员：
            <td colspan="4" bgcolor="#FFFFFF">
                <table id="familyMember" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td height="28" bgcolor="#FFFFFF">
                            <div align="center">关系</div>
                        </td>
                        <td height="28" bgcolor="#FFFFFF">
                            <div align="center">姓名</div>
                        </td>
                        <td height="28" bgcolor="#FFFFFF">
                            <div align="center">年龄</div>
                        </td>
                        <td height="28" bgcolor="#FFFFFF">
                            <div align="center">电话</div>
                        </td>
                        <td height="28" bgcolor="#FFFFFF">
                            <div align="center">工作单位(学校)</div>
                        </td>
                    </tr>

                    <c:forEach items="${familyMembers}" var="family">
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${family.relation}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${family.member_name}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${family.age}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${family.telephone}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${family.work_place}
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">个人技能：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="1" cellspacing="0" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td height="28" bgcolor="#FFFFFF">
                            ${worker.skills}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">主要工作经历：
                </td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table id="work_history" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="45%" height="28" bgcolor="#FFFFFF">
                            <div align="center">单位</div>
                        </td>
                        <td width="17%" height="28" bgcolor="#FFFFFF">
                            <div align="center">工种</div>
                        </td>
                        <td width="17%" height="28" bgcolor="#FFFFFF">
                            <div align="center">职务</div>
                        </td>
                        <td width="21%" height="28" bgcolor="#FFFFFF">
                            <div align="center">工作时间</div>
                        </td>
                    </tr>

                    <c:forEach items="${work_histories}" var="work">
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${work.unit}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${work.work_type}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${work.duty}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${work.work_time}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">岗位培训记录：
               </td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table id="job_training" width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="42%" height="28" bgcolor="#FFFFFF">
                            <div align="center">培训机构</div>
                        </td>
                        <td width="25%" height="28" bgcolor="#FFFFFF">
                            <div align="center">培训内容</div>
                        </td>
                        <td width="15%" height="28" bgcolor="#FFFFFF">
                            <div align="center">培训情况</div>
                        </td>
                        <td width="18%" height="28" bgcolor="#FFFFFF">
                            <div align="center">培训时间</div>
                        </td>
                    </tr>

                    <c:forEach items="${job_trainings}" var="train">
                        <tr>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${train.training_agency}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${train.training_content}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${train.training_situation}
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                ${train.training_time}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">自我介绍：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                ${worker.introduce}
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">人人要求：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="10%" height="28" align="right" bgcolor="#FFFFFF">时间要求：</td>
                        <td width="37%" height="28" bgcolor="#FFFFFF">
                            ${worker.timeRequire}
                        </td>
                        <td width="10%" height="28" align="right" bgcolor="#FFFFFF">住宿：</td>
                        <td width="43%" height="28" bgcolor="#FFFFFF">
                            ${worker.live}
                        </td>
                    </tr>
                    <tr>
                        <td height="28" align="right" bgcolor="#FFFFFF">工资要求：</td>
                        <td height="28" bgcolor="#FFFFFF">
                            ${worker.moneyRequire}
                        </td>
                        <td height="28" align="right" bgcolor="#FFFFFF">餐饮或其它：</td>
                        <td height="28" bgcolor="#FFFFFF">
                            ${worker.eatDrink}
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <table width="96%" height="104" border="0" align="center" class="text_lb">
        <tr>
            <td width="126" height="23" align="right">个人声明：</td>
            <td width="1146">1、本资料由所属公司提供，本人保证所填资料属实。</td>
        </tr>
        <tr>
            <td height="23">&nbsp;</td>
            <td>2、本人保证从无任何刑事记录。</td>
        </tr>
        <tr>
            <td height="23">&nbsp;</td>
            <td>3、如有虚假或伪造资料，一切责任自负。</td>
        </tr>
        <tr>
            <td height="23">&nbsp;</td>
            <td>4、本人同意将资料公布在96909系统。</td>
        </tr>
    </table>
    <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td width="67%" align="center" class="text" nowrap>
                
                <input type="button" name="searchbtn3" value="返  回" class="button_new"
                       onClick="javascript:history.go(-1)">
                <input type="hidden" name="mod" value="no">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>

</html>
