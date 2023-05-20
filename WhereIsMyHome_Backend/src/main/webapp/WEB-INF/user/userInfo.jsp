<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="root" value="${pageContext.request.contextPath}"
    scope="session" />

<body style = "background-size: cover; z-index: -1" background = "${root}/resources/background/background.jpg" >
	<c:import url="../include/nav.jsp"></c:import>

	<c:if test="${!empty logOK}">
		<section class="py-5 text-center container">
			<div class="container-fluid vh-100" style="margin-top: 100px">
				<div class="" style="margin-top: 200px">
					<div class="rounded d-flex justify-content-center">
						<div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light"
							style="width: 600px">
							<div class="text-center">
								<h3 class="text-dark">마이페이지</h3>
							</div>
							<div class="p-7">

								<form action="" method="post" style='display: inline'>
									<!-- id -->
									<div class="input-group mb-3">
										<span class="input-group-text"
											style="background-color: #929292;"> <img
											src="../img/user.png" style="width: 20px; height: 20px;">
											<i class="bi bi-person-plus-fill text-white"></i></span> <input
											id="id" type="text" class="form-control" value="${logOK.id}"
											placeholder="${logOK.id}" readonly />
									</div>

									<!-- 비밀번호 -->
									<div class="input-group mb-3">
										<span class="input-group-text"
											style="background-color: #929292;"> <img
											src="../img/user.png" style="width: 20px; height: 20px;">
											<i class="bi bi-person-plus-fill text-white"></i></span> <input
											id="pwd" type="text" class="form-control"
											placeholder="${logOK.pwd}" />
									</div>

									<!-- 이름 -->
									<div class="input-group mb-3">
										<span class="input-group-text"
											style="background-color: #929292;"> <img
											src="../img/name.png" style="width: 20px; height: 20px;">
											<i class="bi bi-person-plus-fill text-white"></i></span> <input
											id="name" type="text" class="form-control" value="${logOK.name}"
											placeholder="${logOK.name}" readonly />
									</div>

									<!-- 주소 -->
									<div class="input-group mb-3">
										<span class="input-group-text"
											style="background-color: #929292;"> <img
											src="../img/address.png" style="width: 20px; height: 20px;">
											<i class="bi bi-person-plus-fill text-white"></i></span> <input
											id="address" type="text" class="form-control"
											placeholder="${logOK.address}" />
									</div>

									<!-- 전화번호 -->
									<div class="input-group mb-3">
										<span class="input-group-text"
											style="background-color: #929292;"> <img
											src="../img/phone.png" style="width: 20px; height: 20px;">
											<i class="bi bi-person-plus-fill text-white"></i></span> <input
											id="phone" type="text" class="form-control"
											placeholder="${logOK.phone}" />
									</div>
									
									
									<input value="수정" id="updateBtn"
										class="btn btn-primary text-center mt-2">
								</form>


								<form action="" method="get" style='display: inline'> 
									<input value="회원탈퇴" id="deleteBtn"
										class="btn btn-danger text-center mt-2">
								</form>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</c:if>

	<script type="text/javascript" src="${root}/assets/js/modify.js"></script>
	<script type="text/javascript" src="${root}/assets/js/delete.js"></script>
</body>
</html>


