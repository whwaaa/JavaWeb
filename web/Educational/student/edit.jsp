<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head><meta http-equiv="Content-Type" content="text/html; charset=utf-8" /><title>
	学生信息管理平台
</title>
	<link href="../../Style/StudentStyle.css" rel="stylesheet" type="text/css" />
	<link href="../../Script/jBox/Skins/Blue/jbox.css" rel="stylesheet" type="text/css" />
	<link href="../../Style/ks.css" rel="stylesheet" type="text/css" />
	<link href="../../css/mine.css" type="text/css" rel="stylesheet">
    <script src="../../Script/jBox/jquery-1.4.2.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/jquery.jBox-2.3.min.js" type="text/javascript"></script>
    <script src="../../Script/jBox/i18n/jquery.jBox-zh-CN.js" type="text/javascript"></script>
    <script src="../../Script/Common.js" type="text/javascript"></script>
    <script src="../../Script/Data.js" type="text/javascript"></script>

    <script>
        var ckeckStuNoFlag = false;
        var checkEmailFlag = true;
        var checkPhoneFlag = true;
        var checkIdNumberFlag = false;

        function ckeckStuNo(input){
            $(function(){
                if($(input).val().trim() == "${stu.stuNo}"){
                    $("#stuNoErr").css("display","none");
                    ckeckStuNoFlag = true;
                    return;
                }
                if($(input).val().trim()!=""){
                    $.post("/Educational/student/CkeckStuNo", {"stuNo":$(input).val()}, function(res){
                        if(res.trim() == "exist"){
                            $("#stuNoErr").css("display","inline-block");
                            $("#stuNoErr").text("学号重复,请重新输入");
                            ckeckStuNoFlag = false;
                        }else{
                            $("#stuNoErr").css("display","none");
                            ckeckStuNoFlag = true;
                        }
                    })
                }else{
                    $("#stuNoErr").css("display","inline-block");
                    $("#stuNoErr").text("学号不能为空");
                    ckeckStuNoFlag = false;
                }
            })
        }

        function checkEmail(input){
            $(function(){
                if($(input).val().trim() == "${stu.email}"){
                    $("#emailErr").css("display","none");
                    checkEmailFlag = true;
                    return;
                }
                if($(input).val().trim()!=""){
                    $.post("/Educational/student/CheckEmail", {"email":$(input).val()}, function(res){
                        if(res.trim() == "exist"){
                            $("#emailErr").css("display","inline-block");
                            $("#emailErr").text("邮箱重复,请重新输入");
                            checkEmailFlag = false;
                        }else{
                            $("#emailErr").css("display","none");
                            checkEmailFlag = true;
                        }
                    })
                }else{
                    $("#emailErr").css("display","none");
                    checkEmailFlag = true;
                }
            })
        }

        function checkPhone(input){
            $(function(){
                if($(input).val().trim() == "${stu.phone}"){
                    $("#phoneErr").css("display","none");
                    checkPhoneFlag = true;
                    return;
                }
                if($(input).val().trim()!=""){
                    $.post("/Educational/student/CkeckPhone", {"phone":$(input).val()}, function(res){
                        if(res.trim() == "exist"){
                            $("#phoneErr").css("display","inline-block");
                            $("#phoneErr").text("电话号重复,请重新输入");
                            checkPhoneFlag = false;
                        }else{
                            $("#phoneErr").css("display","none");
                            checkPhoneFlag = true;
                        }
                    })
                }else{
                    $("#phoneErr").css("display","none");
                    checkPhoneFlag = true;
                }
            })
        }

        function checkIdNumber(input){
            $(function(){
                if($(input).val().trim() == "${stu.idNumber}"){
                    $("#idNumberErr").css("display","none");
                    checkIdNumberFlag = true;
                    return;
                }
                if($(input).val().trim()!=""){
                    $.post("/Educational/student/CkeckIdNumber", {"idNumber":$(input).val()}, function(res){
                        if(res.trim() == "exist"){
                            $("#idNumberErr").css("display","inline-block");
                            $("#idNumberErr").text("身份证号重复,请重新输入");
                            checkIdNumberFlag = false;
                        }else{
                            $("#idNumberErr").css("display","none");
                            checkIdNumberFlag = true;
                        }
                    })
                }else{
                    $("#idNumberErr").css("display","inline-block");
                    $("#idNumberErr").text("身份证号不能为空");
                    checkIdNumberFlag = false;
                }
            })
        }

        function ckeckInfo(){
            ckeckStuNo($("input[name='stuNo']")[0]);
            checkEmail($("input[name='email']")[0]);
            checkPhone($("input[name='phone']")[0]);
            checkIdNumber($("input[name='idNumber']")[0]);
            if(ckeckStuNoFlag && checkEmailFlag && checkPhoneFlag && checkIdNumberFlag){
                $("#form").submit();
            }
        }
    </script>

</head>
<body>

		<div class="div_head">
            <span>
                <span style="float:left">当前位置是：教务中心-》学生管理-》更新</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="/Educational/student/EditServlet" method="post">
	<table border="1" width="100%" class="table_a">
        <input type="hidden" name="pageIndex" value="${pageInfo.pageIndex}" />
        <input type="hidden" name="stuId" value="${stu.stuId}" />

                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
                        <input type="text"  name="stuNo" value="${stu.stuNo}" onblur="ckeckStuNo(this)" />
                        <p id="stuNoErr" style="display:none;color:red;"></p>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuName" value="${stu.stuName}" />
					</td>
                </tr>
                 
                <tr>
                    <td>班级<span style="color:red">*</span>：</td>

                    <td>
                        <select name="gid">
                            <c:forEach items="${grade}" var="grad">
                                <option name="gid" ${grad.gradeId==stu.gid?"selected":""} value="${grad.gradeId}">${grad.gradeName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>性别<span style="color:red">*</span>：</td>
                    <td>
                        <c:choose>
                            <c:when test="${stu.sex==1}">
                                <input type="radio" name="sex" checked value="1" />男 <input type="radio" name="sex" value="0"/>女
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="sex" value="1" />男 <input type="radio" name="sex" checked value="0"/>女
                            </c:otherwise>
                        </c:choose>


                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="${stu.email}" onblur="checkEmail(this)"/>
                        <p id="emailErr" style="display:none;color:red;"></p>
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="${stu.phone}" onblur="checkPhone(this)"/>
                        <p id="phoneErr" style="display:none;color:red;"></p>
                    </td>                
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="${stu.registered}"  />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="${stu.address}" />
                    </td>                
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="${stu.politics}" />
                    </td>                
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="idNumber" value="${stu.idNumber}" onblur="checkIdNumber(this)"/>
                        <p id="idNumberErr" style="display:none;color:red;"></p>
                    </td>
                </tr>
				
				<tr>
                    <td>专业：</td>
                    <td>
                        <input type="text" name="profession" value="${stu.profession}" />
                    </td>                
                </tr>

				
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea>${stu.introduction}</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="submit" value="保存"> 
					</td> 
				</tr>
			</table>
	</form>
</div>

            </div>
        </div>
    </div>
</body>
</html>
