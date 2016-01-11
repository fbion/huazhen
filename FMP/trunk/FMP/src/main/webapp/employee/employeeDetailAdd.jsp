<%@ taglib prefix="s" uri="/struts-tags" %>
﻿<form id="employeeDetailAdd" class="tableCenter">
<h5 class="tc">应聘人员登记表</h5>
<p>编号：<span><input id="detailCode" name="code" type="text" class="code"/></span>
</p>
<table align="center" border="1" class="mt30">
    <tr>
        <td width="90" height="30" valign="center" colspan="1">姓名</td>
        <td width="100" valign="center" colspan="1">
            <input id="detailName" name="name" type="text" style="width:72px;" class="data name"/>
        </td>
        <td width="90" valign="center" colspan="1">性别</td>
        <td width="100" valign="center" colspan="1">
            <div class="DivSelect">
                <select id="detailSex" name="sex" class="SelectList data sex" style="width:70px;"></select>
            </div>
        </td>
        <td width="100" valign="center" colspan="1">出生日期</td>
        <td width="136" valign="center" colspan="4">
            <input id="birthday" name="birthday" type="text" style="width:340px;" class="data dateYMD"/>
        </td>
        <td width="107" valign="center" colspan="1" rowspan="4">
            <img alt="照片" class="emphead" src="" height="120" width="100">
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">民族</td>
        <td width="60" valign="center" colspan="1">
            <input id="nation" name="nation" type="text" style="width:72px;" class="data"/>
        </td>
        <td width="85" valign="center" colspan="1">婚姻状况</td>
        <td width="56" valign="center" colspan="1">
            <div class="DivSelect">
                <select id="detailMarry" name="marry" class="SelectList data marry" style="width:70px;"></select>
            </div>
        </td>
        <td width="85" valign="center" colspan="1">个人邮箱&nbsp;</td>
        <td width="196" valign="center" colspan="4">
            <input id="detailEmail" name="email" type="text" style="width:340px;" class="data email"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">工作年月</td>
        <td width="60" valign="center" colspan="1">
            <input id="workTime" name="workTime" type="text" style="width:72px;" class="data dateYM"/>
        </td>
        <td width="85" valign="center" colspan="1">政治面貌</td>
        <td width="56" valign="center" colspan="2">
            <div class="DivSelects">
                <select id="politicalStatus" name="politicalStatus" style="width:130px;"
                        class="SelectLists data"></select>
            </div>
        </td>
        <td width="85" valign="center" colspan="1">出生地</td>
        <td width="196" valign="center" colspan="3">
            <input id="birthPlace" name="birthPlace" type="text" style="width:340px;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">女员工是否<br/>怀有身孕</td>
        <td width="60" valign="center" colspan="1">
            <div class="DivSelect">
                <select id="isPregnant" name="isPregnant" class="SelectList data" style="width:70px;">
                    <option value="0"></option>
                    <option value="1">是</option>
                    <option value="2">否</option>
                </select>
            </div>
        </td>
        <td width="85" valign="center" colspan="1">子女情况</td>
        <td width="188" valign="center" colspan="2">
            <input id="childrenSituation" name="childrenSituation" type="text" style="width:162px;" class="data"/>
        </td>
        <td width="94" valign="center" colspan="1">身份证号</td>
        <td width="60" valign="center" colspan="3">
            <input id="IDCard" name="IDCard" type="text" style="width:243px;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">最高学历</td>
        <td width="60" valign="center" colspan="1">
            <div class="DivSelect">
                <select id="highestDegree" name="highestDegree" style="width:72px;" class="SelectList data education"></select>
            </div>
        </td>
        <td width="85" valign="center" colspan="1">专业</td>
        <td width="56" valign="center" colspan="2">
            <input id="profession" name="profession" type="text" style="width:162px;" class="data"/>
        </td>
        <td width="85" valign="center" colspan="1">户籍所在地</td>
        <td width="303" valign="center" colspan="4">
            <input id="permanentPlace" name="permanentPlace" type="text" style="width:350px;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">身高</td>
        <td width="60" valign="center" colspan="1">
            <input id="height" name="height" type="text" style="width:52px;" class="data number"/>cm
        </td>
        <td width="85" valign="center" colspan="1">体重</td>
        <td width="56" valign="center" colspan="1">
            <input id="weight" name="weight" type="text" style="width:52px;" class="data number"/>kg
        </td>
        <td width="85" valign="center" colspan="1">健康状况</td>
        <td width="303" valign="center" colspan="5">
            <input id="healthSituation" name="healthSituation" type="text" style="width:280px;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="98" height="30" valign="center" colspan="1">外语水平</td>
        <td width="581" valign="center" class="tl" colspan="9">1．
            <input id="firstForeignLanguage" name="firstForeignLanguage" type="text"
                   style="width:60px; text-align:left;" class="data"/>语，掌握水平：
            <input id="firstForeignLanguageLevel" name="firstForeignLanguageLevel" type="text"
                   style="height:25px;text-align:left;" class="data"/>2.
            <input id="secondForeignLanguage" name="secondForeignLanguage" type="text"
                   style="width:60px; text-align:left;" class="data"/>语，掌握水平：
            <input id="secondForeignLanguageLevel" name="secondForeignLanguageLevel" type="text"
                   style="height:25px;text-align:left;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">QQ号码</td>
        <td width="192" valign="center" colspan="4">
            <input id="detailQq" name="qq" type="text" style="width:350px;" class="data qq number"/>
        </td>
        <td width="85" valign="center" colspan="1">微信号码</td>
        <td width="303" valign="center" colspan="4">
            <input id="detailWeixin" name="weixin" type="text" style="width:350px;" class="data weixin"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">联系电话</td>
        <td width="581" height="30" valign="center" class="tl" colspan="9">
            住宅电话：
            <input id="homeTelephone" name="homeTelephone" type="text" tyle="width:150px; height:30px; text-align:left;" class="data tel"/>
            办公电话：
            <input id="detailTelephone" name="telephone" type="text" style="width:150px; height:30px; text-align:left;" class="data telephone tel"/>
            手机：
            <input id="detailCellphone1" name="cellphone1" type="text" style="width:150px; height:30px; text-align:left;" class="data cellphone1 cellphone"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">户籍地址</td>
        <td width="581" valign="center" colspan="9">
            <input id="permanentAddress" name="permanentAddress" type="text" style="width:615px;" class="data"/>邮编：
            <input id="permanentAddressPostcode" name="permanentAddressPostcode" type="text" class="data postCode" style="width:180px;"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">联系地址</td>
        <td width="581" valign="center" colspan="9">
            <input id="detailAddress" name="address" type="text" style="width:615px;" class="data address"/>邮编：
            <input id="addressPostcode" name="addressPostcode" type="text" class="data postCode" style="width:180px;"/>
        </td>
    </tr>
    <tr>
        <td width="98" valign="center" colspan="1">紧急联系人</td>
        <td width="192" valign="center" colspan="4">
            <input id="emergencyContactName" name="emergencyContactName" type="text" style="width:368px;" class="data"/>
        </td>
        <td width="85" valign="center" colspan="1">联系电话</td>
        <td width="303" valign="center" colspan="4">
            <input id="emergencyContactCellphone" name="emergencyContactCellphone" type="text" style="width:350px;"
                   class="data phone"/>
        </td>
    </tr>
    <tr>
        <td width="595" height="30" valign="center" colspan="10">教育与培训经历&nbsp;（从高中起）</td>
    </tr>
    <tr>
        <td width="0" style="display:none;"></td>
        <td width="110" height="30" valign="center" colspan="2">在学时间</td>
        <td width="200" valign="center" colspan="4">学校及学院（系）或培训单位名称</td>
        <td width="132" valign="center" colspan="2">专业</td>
        <td width="86" valign="center" colspan="1">学历</td>
        <td width="86" valign="center" colspan="1">学位</td>
    </tr>
    <tr class="employeeEducationTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="200" valign="center" colspan="4">
            <input type="text" style="width:352px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:157px;" class="data"/>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data education" style="width:70px;">
                </select>
            </div>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data degree" style="width:70px;">
                </select>
            </div>
        </td>
    </tr>
    <tr class="employeeEducationTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="200" valign="center" colspan="4">
            <input type="text" style="width:352px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:157px;" class="data"/>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data education" style="width:70px;"></select>
            </div>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data degree" style="width:70px;"></select>
            </div>
        </td>
    </tr>
    <tr class="employeeEducationTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="200" valign="center" colspan="4">
            <input type="text" style="width:352px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:157px;" class="data"/>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data education" style="width:70px;"></select>
            </div>
        </td>
        <td width="86" valign="center" colspan="1">
            <div class="DivSelect">
                <select class="SelectList data degree" style="width:70px;"></select>
            </div>
        </td>
    </tr>
    <tr>
        <td width="595" height="30" valign="center" colspan="10">工作经历</td>
    </tr>
    <tr>
        <td width="0" style="display:none;"></td>
        <td width="110" height="30" valign="center" colspan="2">工作时间</td>
        <td width="125" valign="center" colspan="3">工作单位及部门</td>
        <td width="110" valign="center" colspan="2">职位</td>
        <td width="90" valign="center" colspan="1">月收入</td>
        <td width="90" valign="center" colspan="1">联系人</td>
        <td width="90" valign="center" colspan="1">联系电话</td>
    </tr>
    <tr class="workExperienceTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="125" valign="center" colspan="3">
            <input type="text" style="width:262px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" style="width:160px;" class="data "/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:70px;" class="data"/> 元
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" class="data phone" style="width:100px;"/>
        </td>
    </tr>
    <tr class="workExperienceTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="125" valign="center" colspan="3">
            <input type="text" style="width:262px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" style="width:160px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:70px;" class="data"/>元
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" class="data phone" style="width:100px;"/>
        </td>
    </tr>
    <tr class="workExperienceTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="125" valign="center" colspan="3">
            <input type="text" style="width:262px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" style="width:160px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:70px;" class="data"/>元
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" class="data phone" style="width:100px;"/>
        </td>
    </tr>
    <tr class="workExperienceTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" class="data dateYMLine" style="width:86px;"/>
            <input type="text" class="data dateYM" style="width:86px;"/>
        </td>
        <td width="125" valign="center" colspan="3">
            <input type="text" style="width:262px;" class="data"/>
        </td>
        <td width="110" valign="center" colspan="2">
            <input type="text" style="width:160px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:70px;" class="data"/>元
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" class="data phone" style="width:100px;"/>
        </td>
    </tr>
    <tr>
        <td width="595" valign="center" class="tl" colspan="10">奖惩情况：
            <input id="reward" name="reward" type="text" style="width:780px; text-align:left;" class="data"/>
        </td>
    </tr>
    <tr>
        <td width="595" height="30" valign="center" colspan="10">家庭成员</td>
    </tr>
    <tr>
        <td width="0" style="display:none;"></td>
        <td width="90" height="30" valign="center" colspan="1">姓名</td>
        <td width="90" valign="center" colspan="1">称谓</td>
        <td width="85" valign="center" colspan="1">年龄</td>
        <td width="200" valign="center" colspan="3">工作单位及部门</td>
        <td width="100" valign="center" colspan="2">担任职务</td>
        <td width="100" valign="center" colspan="2">联系电话</td>
    </tr>
    <tr class="familyMemberTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="98" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="50" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="50" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data number"/>
        </td>
        <td width="200" valign="center" colspan="3">
            <input type="text" style="width:280px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data phone"/>
        </td>
    </tr>
    <tr class="familyMemberTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data number"/>
        </td>
        <td width="200" valign="center" colspan="3">
            <input type="text" style="width:280px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data phone"/>
        </td>
    </tr>
    <tr class="familyMemberTable">
        <td width="0" style="display:none;">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data"/>
        </td>
        <td width="90" valign="center" colspan="1">
            <input type="text" style="width:80px;" class="data number"/>
        </td>
        <td width="200" valign="center" colspan="3">
            <input type="text" style="width:280px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data"/>
        </td>
        <td width="100" valign="center" colspan="2">
            <input type="text" style="width:170px;" class="data phone"/>
        </td>
    </tr>
    <tr>
        <td width="595" height="30" valign="center" class="tl" colspan="10">金融行业从业经历概况/对金融行业有哪些认识/接触过哪些金融产品（2000字以内）：
    </tr>
    <tr>
        <td width="595" height="30" valign="center" class="tc" colspan="10">
            <textarea id="generalSituation" name="generalSituation" style="width:98%; height:85px;"
                      class="data"></textarea>
        </td>
    </tr>
    <tr>
        <td width="595" valign="center" colspan="10">技能与专长:
            <input id="skill" name="skill" type="text" style="width:380px; text-align:left;" class="mr30 data"/>兴趣与爱好:
            <input id="hobby" name="hobby" type="text" style="width:380px; text-align:left;" class="data"/>
            <br/> 优点与长处:
            <input id="advantage" name="advantage" type="text" style="width:380px; text-align:left;" class="mr30 data"/>缺点与不足:
            <input id="disadvantage" name="disadvantage" type="text" style="width:380px; text-align:left;"
                   class="data"/>
        </td>
    </tr>
    <tr>
        <td width="595" height="30" valign="center" colspan="10" class="tl">受过何种培训，持有哪些证书：
            <input id="educationExperience" name="educationExperience" type="text" style="width:750px; text-align:left;"
                   class="data"/>
        </td>
    </tr>
    <tr>
        <td width="595" valign="top" colspan="10" class="p10">
            <h3>声明</h3>
            <strong style="text-indent:26px;" class="tl pl15 pr30"> 本人确认，在本表中提供的有关信息是真实准确的；如有虚假，本人愿意接受无条件解除劳动关系的处理，并承担或赔偿因此给公司带来的一切损失。本人
                <input id="accept" name="accept" type="radio" style="width:20px; vertical-align:middle;"/>同意
                <input name="accept" type="radio" style="width:20px; vertical-align:middle;"/>不同意
                公司在必要的情况下对相关情况进行调查。
            </strong>
        </td>
    </tr>
</table>

<div id="btn" class="pt20"><em id="msg"></em>
    <s:if test="showEditButton">
        <input id="employeeDetailEdit" name="employeeDetailEdit" type="button" value="修改" class="submit_Btn none btn_style edit"/>
        <input id="employeeDetailSubmit" name="employeeDetailSubmit" type="submit" value="保存" class="submit_Btn none btn_style submit"/>
    </s:if>
    <input id="employeeDetailBack" name="employeeDetailBack" type="button" value="返回" class="cancel_Btn btn_style back"/>
</div>
</form>
