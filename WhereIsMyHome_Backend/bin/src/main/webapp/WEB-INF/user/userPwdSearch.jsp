<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<body style = "background-size: cover" background = "background/background.jpg" >
<%@ include file="../include/nav.jsp" %>

<form action="${root }/user"  method="post">
<input type="hidden" name="action" value="searchpwd">

<table border="0" align="center" width="350">
    <tr>
        <td>아이디</td>
        <td><input type="text" name="id"></td>
    </tr>
    <tr>
        <td>이름</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>전화번호</td>
        <td><input type="text" name="phone"></td>
    </tr>
    <tr>
        <td colspan="2" align="center">

            <input type="submit" value="비밀번호찾기">
            <c:if test="${!empty pwd }">
      Response.Write("<script>alert("비밀번호는 ${pwd}입니다.");</script>");
      Response.Write("<script>location.href='${root}/login/login.jsp';</script>");
      </c:if>

 
       </td>
    </tr>
</table>
</form>
</body>
</html>