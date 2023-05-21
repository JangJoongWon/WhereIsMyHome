<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body style = "background-size: cover" background = "../background/background.jpg" >
<c:import url="../include/nav.jsp"></c:import>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
	<section class="py-5 text-center container">
		<div class="container-fluid vh-100" style="margin-top: 100px">
			<div class="" style="margin-top: 100px">
				<div class="rounded d-flex justify-content-center">
					<div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
						<div class="text-center">
							<h3 class="text-dark">Sign Up</h3>
						</div>
						<div class="p-4">

							<%-- 							<form action="${root }/member" method="post">

								<input type="hidden" name="action" value="insertmember">

								<table border="0" width="300" align="center">
									<tr>
										<td>아이디</td>
										<td><input type="text" name="id"></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="text" name="pwd"></td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input type="text" name="name"></td>
									</tr>
									<tr>
										<td>주소</td>
										<td><input type="text" name="address"></td>
									</tr>
									<tr>
										<td>휴대폰 번호</td>
										<td><input type="text" name="phone"></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><input type="submit"
											value="추가"> <input type="reset" value="취소"></td>
									</tr>
								</table>
							</form> --%>

							<form action="${root }/user" method="post">
								<input type="hidden" name="action" value="signup">
								<!-- id -->
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-person-plus-fill text-white"></i></span> <input
										id="userid" type="text" class="form-control" placeholder="아이디"
										name="id">
								</div>

								<!-- password-->
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-key-fill text-white"></i></span> <input id="userpwd"
										type="password" class="form-control" placeholder="비밀번호"
										name="pwd">
								</div>
								<!-- 이름 -->
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-person-plus-fill text-white"></i></span> <input
										id="username" type="text" class="form-control"
										placeholder="이름" name="name">
								</div>

								<!-- 주소 -->
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-person-plus-fill text-white"></i></span> <input
										id="address" type="text" class="form-control" placeholder="주소"
										name="address">
								</div>

								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-person-plus-fill text-white"></i></span> <input
										id="phoneNum" type="tel" class="form-control"
										title="전화번호를 입력하세요." placeholder="전화번호"
										pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{3,4}" maxlength="13"
										name="phone">
									<!-- <input id="phoneNum" type="text" class="form-control" placeholder="전화번호"> -->
								</div>

								<button class="btn btn-primary text-center mt-2" type="submit">Sign
									Up</button>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	</main>
</body>
</html>