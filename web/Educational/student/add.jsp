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
                <span style="float:left">当前位置是：教务中心-》学生管理-》新增</span>
                <span style="float:right;margin-right: 8px;font-weight: bold"></span>
            </span>
        </div>
</div>
<div class="cztable">
    <form action="AddStuServlet" method="post" id="form">
	<table border="1" width="100%" class="table_a">
        <input type="hidden" value="${pageIndex}" name="pageIndex" />
                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuNo" value="" onblur="ckeckStuNo(this)"/>
                        <p id="stuNoErr" style="display:none;color:red;"></p>
					</td>
                </tr>

                <tr  width="120px;">
                    <td>姓名<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuName" value="杨XX" />
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
                        <input type="radio" name="sex" checked value="1" />男 <input type="radio" name="sex" value="0"/>女
                    </td>
                </tr>


				<tr>
                    <td>EMAIL：</td>
                    <td>
                        <input type="text" name="email" value="1332@126.com" onblur="checkEmail(this)"/>
                        <p id="emailErr" style="display:none;color:red;"></p>
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="13333333333" onblur="checkPhone(this)"/>
                        <p id="phoneErr" style="display:none;color:red;"></p>
                    </td>                
                </tr>

				<tr>
                    <td>户口所在地：</td>
                    <td>
                        <input type="text" name="registered" value="北京"  />
                    </td>                
                </tr>

				<tr>
                    <td>住址：</td>
                    <td>
                        <input type="text" name="address" value="朝阳" />
                    </td>                
                </tr>
				<tr>
                    <td>政治面貌：</td>
                    <td>
                        <input type="text" name="politics" value="党员" />
                    </td>                
                </tr>
				<tr>
                    <td>身份证号：</td>
                    <td>
                        <input type="text" name="idNumber" value="1101111111111111" onblur="checkIdNumber(this)"/>
                        <p id="idNumberErr" style="display:none;color:red;"></p>
                    </td>                
                </tr>
				
				<tr>
                    <td>专业：</td>
                    <td>
                        <input type="text" name="profession" value="java" />
                    </td>                
                </tr>
					
				
				<tr>
                    <td>简介<span style="color:red">*</span>：</td>
                    <td>
                        <textarea name="introduction">一个新开辟领域的探讨，探讨摸索</textarea>
                    </td>
                </tr>
				<tr>
					<td colspan=2 align="center">
						<input type="button" value="添加" onclick="ckeckInfo()" />
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
