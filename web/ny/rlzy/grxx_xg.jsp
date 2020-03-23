<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html >

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
    <link href="/ny/css/INDEX.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/ny/javascript/validator.js"></script>
    <script type="text/javascript" src="/ny/js/public.js"></script>
    <script type="text/javascript" src="/ny/js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="/ny/javascript/handleArchive.js"></script>


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
<form action="/ny/WorkerServlet" method="post">
    <table width="96%" height="577" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3"
           class="text_lb">
        <tr>
            <td width="106" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
            <td width="280" bgcolor="#FFFFFF">
                <input name="worker_number" type="text" readonly id="worker_number" value="${worker.worker_number}" size="30" class="pi">
            </td>
            <td width="116" align="right" bgcolor="#FFFFFF">所属公司：</td>
            <td width="300" bgcolor="#FFFFFF" >

                <select name="company_number" id="company_number" class="input" style="width:200px;">
                   <c:forEach items="${companies}" var="company">
                    <option value="${company.company_number}"
                            <c:if test="${worker.company_number==company.company_number}">checked</c:if> >
                            ${company.company_name}
                    </option>
                   </c:forEach>
                </select>
            </td>
            <td width="131" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF">相片</td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
            <td bgcolor="#FFFFFF"><input name="worker_name" maxlength="50" type="text" id="worker_name" value="${worker.worker_name}" size="30" class="pi"></td>
            <td align="right" bgcolor="#FFFFFF">性别：</td>
            <td bgcolor="#FFFFFF">
                <input type="radio" name="worker_sex" id="worker_sex" value="男" <c:if test="${worker.worker_sex=='男'}">checked</c:if>>
                男
                <input type="radio" name="worker_sex" id="worker_sex" value="女" <c:if test="${worker.worker_sex=='女'}">checked</c:if>>
                女
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
            <td bgcolor="#FFFFFF"><input name="worker_IDNumber" type="text" maxlength="18" id="worker_IDNumber" value="${worker.worker_IDNumber}" size="30" class="pi"></td>
            <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
            <td bgcolor="#FFFFFF"><input name="worker_birth" type="date" id="worker_birth" value="${worker.worker_birth}" size="30" class="pi"></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FFFFFF">年龄：</td>
            <td bgcolor="#FFFFFF"><input name="worker_age" type="text" maxlength="3" id="worker_age" value="${worker.worker_age}" size="30" class="pi"></td>
            <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
            <td bgcolor="#FFFFFF"><input name="worker_height" type="text" maxlength="3" id="worker_height" value="${worker.worker_height}" size="30" class="pi"></td>
        </tr>
        <tr>
            <td align="right" bgcolor="#FFFFFF">手机：</td>
            <td bgcolor="#FFFFFF"><input name="worker_mobile" type="text" maxlength="11" id="worker_mobile" value="${worker.worker_mobile}" size="30" class="pi"></td>
            <td align="right" bgcolor="#FFFFFF">电话：</td>
            <td bgcolor="#FFFFFF"><input name="worker_telephone" type="text" maxlength="11" id="worker_telephone" value="${worker.worker_telephone}" size="30" class="pi"></td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
            <td bgcolor="#FFFFFF"><input name="typeOfWork" type="text" id="typeOfWork" maxlength="30" value="${worker.typeOfWork}" size="30" class="pi"></td>
            <td align="right" bgcolor="#FFFFFF">从业时间：</td>
            <td bgcolor="#FFFFFF"><input name="worker_time" type="date" id="worker_time" value="${worker.worker_time}" size="30" class="pi"></td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
            <td bgcolor="#FFFFFF"><input name="defect" type="text" id="defect" maxlength="50" value="${worker.defect}" size="30" class="pi"></td>
            <td align="right" bgcolor="#FFFFFF">教育程度：</td>
            <td bgcolor="#FFFFFF">
                大专&nbsp;
                <input type="radio" name="album" id="album" value="大专" <c:if test="${worker.album=='大专'}">checked</c:if> />
                高中&nbsp;
                <input type="radio" name="album" id="album" value="高中" <c:if test="${worker.album=='高中'}">checked</c:if>/>
                初中&nbsp;
                <input type="radio" name="album" id="album" value="初中" <c:if test="${worker.album=='初中'}">checked</c:if>/>
                小学
                <input type="radio" name="album" id="album" value="小学" <c:if test="${worker.album=='小学'}">checked</c:if>/>&nbsp;
            </td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">户籍地址：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input name="permanent_address" type="text" id="permanent_address" maxlength="50" value="${worker.permanent_address}" size="65" class="pi">
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">现住地址：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input name="address_Now" type="text" maxlength="50" id="address_Now" value="${worker.address_Now}" size="65"
                                                     class="pi"></td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">银行卡号：</td>
            <td bgcolor="#FFFFFF">
                <input name="bankCardNumber" type="text" id="bankCardNumber" maxlength="50" value="${worker.bankCardNumber}" size="30" class="pi"></td>
            <td align="right" bgcolor="#FFFFFF">保险单号：</td>
            <td colspan="2" bgcolor="#FFFFFF">
                <input name="policyNo" type="text" id="policyNo" maxlength="50" value="${worker.policyNo}" size="30"
                                                     class="pi"></td>
        </tr>

        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">语言：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input type="checkbox" name="language" id="language" value="普通话" <c:if test="${fn:contains(worker.language,'普通话')}">checked</c:if>/>
                普通话&nbsp;
                <input type="checkbox" name="language" id="language" value="广州话" <c:if test="${fn:contains(worker.language,'广州话')}">checked</c:if>/>
                广州话&nbsp;
                <input type="checkbox" name="language" id="language" value="英语" <c:if test="${fn:contains(worker.language,'英语')}">checked</c:if>/>
                英语
                <input type="checkbox" name="language" id="language" value="其他语言" <c:if test="${fn:contains(worker.language,'其他语言')}">checked</c:if>/>
                其它语言

            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">状态：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input type="radio" name="worker_statu" id="worker_statu" value="在岗" <c:if test="${worker.worker_statu=='在岗'}">checked</c:if>/>
                在岗&nbsp;&nbsp;
                <input type="radio" name="worker_statu" id="worker_statu" value="待岗" <c:if test="${worker.worker_statu=='待岗'}">checked</c:if>/>
                待岗&nbsp;&nbsp;
                <input type="radio" name="worker_statu" id="worker_statu" value="其他" <c:if test="${worker.worker_statu=='其他'}">checked</c:if>/>
                其它
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">婚姻状况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input type="radio" name="marriage_status" id="marriage_status" value="已婚" <c:if test="${worker.marriage_status=='已婚'}">checked</c:if>/>
                已婚
                <input type="radio" name="marriage_status" id="marriage_status" value="未婚" <c:if test="${worker.marriage_status=='未婚'}">checked</c:if>/>
                未婚&nbsp;&nbsp;
                <input type="radio" name="marriage_status" id="marriage_status" value="离异" <c:if test="${worker.marriage_status=='离异'}">checked</c:if>/>
                离异
                <input type="radio" name="marriage_status" id="marriage_status" value="丧偶" <c:if test="${worker.marriage_status=='丧偶'}">checked</c:if>/>
                丧偶
                <input type="radio" name="marriage_status" id="marriage_status" value="其他" <c:if test="${worker.marriage_status=='其他'}">checked</c:if>/>
                其它
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">证照状况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <input type="checkbox" name="certification_status" id="certification_status" value="计生证" <c:if test="${fn:contains(worker.certification_status,'计生证')}">checked</c:if>/>
                计生证&nbsp;
                <input type="checkbox" name="certification_status" id="certification_status" value="健康证" <c:if test="${fn:contains(worker.certification_status,'健康证')}">checked</c:if>/>
                健康证&nbsp;&nbsp;
                <input type="checkbox" name="certification_status" id="certification_status" value="暂住证" <c:if test="${fn:contains(worker.certification_status,'暂住证')}">checked</c:if>/>
                暂住证&nbsp;&nbsp;
                <input type="checkbox" name="certification_status" id="certification_status" value="上岗证" <c:if test="${fn:contains(worker.certification_status,'上岗证')}">checked</c:if>/>
                上岗证
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">体检情况：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="68%" height="28" bgcolor="#FFFFFF">
                            <input type="checkbox" name="health_examination" id="health_examination" value="肝功" <c:if test="${fn:contains(worker.health_examination,'肝功')}">checked</c:if>/>
                            肝功
                            <input type="checkbox" name="health_examination" id="health_examination" value="胸透" <c:if test="${fn:contains(worker.health_examination,'胸透')}">checked</c:if>/>
                            胸透
                            <input type="checkbox" name="health_examination" id="health_examination" value="皮肤妇科" <c:if test="${fn:contains(worker.health_examination,'皮肤妇科')}">checked</c:if>/>
                            皮肤妇科
                            <input type="checkbox" name="health_examination" id="health_examination" value="其他" <c:if test="${fn:contains(worker.health_examination,'其他')}">checked</c:if>/>
                            其它
                        </td>

                        <td width="11%" align="right" bgcolor="#FFFFFF">体检时间：</td>
                        <td width="21%" bgcolor="#FFFFFF">
                            <input name="healExamTime" type="date" id="healExamTime" value="${worker.healExamTime}" size="16" class="pi">
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" nowrap bgcolor="#FFFFFF">家庭成员：
                <input type="button" name="button3" id="button3" value="+"/></td>
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
                                <input name="relation" type="text" id="relation" value="${family.relation}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="member_name" type="text"  id="member_name" value="${family.member_name}" size="18"class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="age" type="text" id="age" value="${family.age}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="telephone" type="text" id="telephone" value="${family.telephone}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="work_place" type="text" id="work_place" value="${family.work_place}" size="18" class="pi">
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
                            <input type="checkbox" name="skills" id="skills" value="照顾婴儿" <c:if test="${fn:contains(worker.skills,'照顾婴儿')}">checked</c:if>/>
                            照顾婴儿 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="带小孩" <c:if test="${fn:contains(worker.skills,'带小孩')}">checked</c:if>/>
                            带小孩 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="照顾老人" <c:if test="${fn:contains(worker.skills,'照顾老人')}">checked</c:if>/>
                            照顾老人 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="煮饭" <c:if test="${fn:contains(worker.skills,'煮饭')}">checked</c:if>/>
                            煮饭 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="粤菜" <c:if test="${fn:contains(worker.skills,'粤菜')}">checked</c:if>/>
                            粤菜 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="客家菜" <c:if test="${fn:contains(worker.skills,'客家菜')}">checked</c:if>/>
                            客家菜 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="煲烫" <c:if test="${fn:contains(worker.skills,'煲烫')}">checked</c:if>/>
                            煲烫
                        </td>
                    </tr>
                    <tr>
                        <td height="28" bgcolor="#FFFFFF">
                            <input type="checkbox" name="skills" id="skills" value="扫地" <c:if test="${fn:contains(worker.skills,'扫地')}">checked</c:if>/>
                            扫地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="拖地" <c:if test="${fn:contains(worker.skills,'拖地')}">checked</c:if>/>
                            拖地 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="擦窗" <c:if test="${fn:contains(worker.skills,'擦窗')}">checked</c:if>/>
                            擦窗
                            <input type="checkbox" name="skills" id="skills" value="洗衣" <c:if test="${fn:contains(worker.skills,'洗衣')}">checked</c:if>/>
                            洗衣 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="打蜡" <c:if test="${fn:contains(worker.skills,'打蜡')}">checked</c:if>/>
                            打蜡 &nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="通渠" <c:if test="${fn:contains(worker.skills,'通渠')}">checked</c:if>/>
                            通渠&nbsp;&nbsp;&nbsp;
                            <input type="checkbox" name="skills" id="skills" value="其它" <c:if test="${fn:contains(worker.skills,'其它')}">checked</c:if>/>
                            其它
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">主要工作经历：
                <input type="button" name="button4" id="button4" value="+"/></td>
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
                                <input name="unit" type="text" id="unit" value="${work.unit}" size="40" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="work_type" type="text" id="work_type" value="${work.work_type}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="duty" type="text" id="duty" value="${work.duty}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="work_time" type="date"  id="work_time" value="${work.work_time}" size="18" class="pi">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">岗位培训记录：
                <input type="button" name="button5" id="button5" value="+"/></td>
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
                                <input name="training_agency" type="text" id="training_agency" value="${train.training_agency}" size="40" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="training_content" type="text" id="training_content" value="${train.training_content}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="training_situation" type="text" id="training_situation" value="${train.training_situation}" size="18" class="pi">
                            </td>
                            <td height="28" align="center" bgcolor="#FFFFFF">
                                <input name="training_time" type="date" id="training_time" value="${train.training_time}" size="18" class="pi">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">自我介绍：</td>
            <td colspan="4" bgcolor="#FFFFFF"><textarea name="introduce" maxlength="50" id="introduce" cols="60" rows="5">${worker.introduce}</textarea>
            </td>
        </tr>
        <tr>
            <td height="23" align="right" bgcolor="#FFFFFF">人人要求：</td>
            <td colspan="4" bgcolor="#FFFFFF">
                <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
                    <tr>
                        <td width="10%" height="28" align="right" bgcolor="#FFFFFF">时间要求：</td>
                        <td width="37%" height="28" bgcolor="#FFFFFF">
                            <input name="timeRequire" type="text" id="timeRequire" maxlength="50" value="${worker.timeRequire}" size="40" class="pi">
                        </td>
                        <td width="10%" height="28" align="right" bgcolor="#FFFFFF">住宿：</td>
                        <td width="43%" height="28" bgcolor="#FFFFFF">
                            <input name="live" type="text" id="live" value="${worker.live}" maxlength="50" size="40" class="pi">
                        </td>
                    </tr>
                    <tr>
                        <td height="28" align="right" bgcolor="#FFFFFF">工资要求：</td>
                        <td height="28" bgcolor="#FFFFFF">
                            <input name="moneyRequire" type="text" id="moneyRequire" maxlength="50" value="${worker.moneyRequire}" size="40" class="pi">
                        </td>
                        <td height="28" align="right" bgcolor="#FFFFFF">餐饮或其它：</td>
                        <td height="28" bgcolor="#FFFFFF">
                            <input name="eatDrink" type="text" id="eatDrink" maxlength="50" value="${worker.eatDrink}" size="40" class="pi">
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
                <input type="hidden" name="act" value="update">
                <input type="submit" name="searchbtn3" value="保  存" class="button_new">
                <input type="button" name="searchbtn3" value="返  回" class="button_new"
                       onClick="javascript:history.go(-1)">
                <input type="hidden" name="mod" value="no">
                &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript">

    $(function(){
        $("#button3").click(function () {
            $("#familyMember").append(`<tr>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="relation" type="text" id="relation" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="member_name" type="text"  id="member_name" value="" size="18"class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="age" type="text" id="age" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="telephone" type="text" id="telephone" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="work_place" type="text" id="work_place" value="" size="18" class="pi">
                        </td>
                    </tr>`)
        })

        $("#button4").click(function(){
            $("#work_history").append(`<tr>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="unit" type="text" id="unit" value="" size="40" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="work_type" type="text" id="work_type" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="duty" type="text" id="duty" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="work_time" type="date"  id="work_time" value="" size="18" class="pi">
                        </td>
                    </tr>`)
        })

        $("#button5").click(function(){
            $("#job_training").append(`<tr>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="training_agency" type="text" id="training_agency" value="" size="40" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="training_content" type="text" id="training_content" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="training_situation" type="text" id="training_situation" value="" size="18" class="pi">
                        </td>
                        <td height="28" align="center" bgcolor="#FFFFFF">
                            <input name="training_time" type="date" id="training_time" value="" size="18" class="pi">
                        </td>
                    </tr>`)
        })
    })

</script>
</body>

</html>
