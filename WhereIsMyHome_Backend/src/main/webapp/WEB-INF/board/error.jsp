<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body style="background-size: cover"
	background="background/background.jpg">
	<c:import url="../include/nav.jsp"></c:import>

	<section class="py-5 text-center container">
		<div class="container-fluid vh-100" style="margin-top: 100px">
			<div class="" style="margin-top: 200px">
				<h2>권한이 없습니다 로그인 후에 다시 이용해주세요</h2>
				<a href="${root }/user/login">로그인 하러가기 </a>
			</div>
		</div>
	</section>
</body>
</html>