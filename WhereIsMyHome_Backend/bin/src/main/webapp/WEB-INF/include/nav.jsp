<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"
	scope="session" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>구해줘 Home!-login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
</head>
	<header>
		<nav class="header-nav fixed-top">
			<nav class="navbar navbar-dark navbar-expand-lg"
				style="background-color: #434343;">
				<div class="container-fluid">
					<a class="navbar-brand text-white" href="${root}">Home</a>
					<button class="navbar-toggler" style="border-color: white;"
						type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">
							<li class="nav-item"><a class="nav-link active text-white"
								aria-current="page" href="${root}">오늘의 뉴스</a></li>
							<li class="nav-item"><a class="nav-link active text-white"
								href="${root}">공지사항</a></li>

							<c:if test="${!empty logOK }">
								<li class="nav-item"><a class="nav-link active text-white"
									href="${root }/user/mypage" id="mypage">마이페이지</a></li>
							</c:if>
						</ul>

						<ul class="navbar-nav mb-lg-0">
							<c:if test="${empty logOK }">
								<button
									class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
									type="submit" id="login"
									onclick="location.href='${root}/user/login';">로그인</button>
								<button
									class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
									type="submit" id="signup"
									onclick="location.href='${root}/user/signup';">회원가입</button>
							</c:if>

							<c:if test="${!empty logOK }">
								<button
									class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
									type="submit" id="logout"
									onclick="location.href = '${root }/user/logout';">로그아웃</button>
							</c:if>

						</ul>
					</div>
				</div>
			</nav>
	</header>