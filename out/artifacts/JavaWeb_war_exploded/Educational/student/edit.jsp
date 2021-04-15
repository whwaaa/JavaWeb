﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <input type="hidden" name="pageIndex" value="${pageIndex}" />
        <input type="hidden" name="stuId" value="${stu.stuId}" />

                <tr  width="120px;">
                    <td width="10%">学号：<span style="color:red">*</span>：</td>
                    <td>
						<input type="text"  name="stuNo" value="${stu.stuNo}" />
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

                            <c:choose>

                                <c:when test="${stu.gid==1}">
                                    <option name="gid" selected value="1">一班</option>
                                    <option name="gid" value="2">二班</option>
                                    <option name="gid" value="3">三班</option>
                                </c:when>
                                <c:when test="${stu.gid==2}">
                                    <option name="gid" value="1">一班</option>
                                    <option name="gid" selected value="2">二班</option>
                                    <option name="gid" value="3">三班</option>
                                </c:when>
                                <c:when test="${stu.gid==3}">
                                    <option name="gid" value="1">一班</option>
                                    <option name="gid" value="2">二班</option>
                                    <option name="gid" selected value="3">三班</option>
                                </c:when>

                            </c:choose>

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
                        <input type="text" name="email" value="${stu.email}" />
                    </td>                
                </tr>

				<tr>
                    <td>联系电话：</td>
                    <td>
                        <input type="text" name="phone" value="${stu.phone}" />
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
                        <input type="text" name="idNumber" value="${stu.idNumber}" />
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
