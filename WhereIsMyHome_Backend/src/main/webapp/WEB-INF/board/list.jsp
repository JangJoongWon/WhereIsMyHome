<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<%@ include file="../include/nav.jsp"%>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<title>구해줘 Home!-board</title>
</head>

<body>
	<div class="container-fluid vh-100" style="margin-top: 150px">
		<div class="" style="margin-top: 100px">
			<div class="rounded d-flex justify-content-center">
				<div class="vw-100 shadow-lg p-5 bg-light">
					<div class="h-100">
						<!-- <div class="col-md-12 col-sm-12 shadow-lg p-5 bg-light">  -->
						<div class="text-center">
							<h3 class="text-dark">게시판</h3>
						</div>
						<div class="col-lg-8 col-md-10 col-sm-12">
							<div class="row align-self-center mb-2">
								<div class="col-md-2 text-start">
									<button type="button" id="btn-mv-register"
										class="btn btn-outline-primary btn-sm">글쓰기</button>
								</div>
								<div class="col-md-7 offset-3">
									<form class="d-flex" id="form-search" action="">
										<input type="hidden" name="pgno" value="1" /> <select
											name="key" id="key"
											class="form-select form-select-sm ms-5 me-1 w-50"
											aria-label="검색조건">
											<!--  <option selected>검색조건</option>-->
											<option value="subject">제목</option>
											<option value="id">작성자</option>
										</select>
										<div class="input-group input-group-sm">
											<input type="text" name="word" id="word" class="form-control"
												placeholder="검색어..." />
											<button id="btn-search" class="btn btn-dark" type="button">검색</button>
										</div>
									</form>
								</div>
							</div>
							<table class="table table-hover">
								<thead>
									<tr class="text-center">
										<th scope="col">글번호</th>
										<th scope="col">제목</th>
										<th scope="col">작성자</th>
										<th scope="col">조회수</th>
										<th scope="col">작성일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="article" items="${articles}">
										<tr class="text-center">
											<th scope="row">${article.articleNo}</th>
											<td class="text-start"><a href="#"
												class="article-title link-dark"
												data-no="${article.articleNo}" style="text-decoration: none">
													${article.subject} </a></td>
											<td>${article.id}</td>
											<td>${article.hit}</td>
											<td>${article.registerTime}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="row">${navigation.navigator}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="form-param" method="get" action="">
		<input type="hidden" name="pgno" id="pgno" value="${pgno}"> <input
			type="hidden" name="key" value="${key}"> <input type="hidden"
			name="word" value="${word}">
	</form>
	<form id="form-no-param" method="get" action="${root}/board/view">
		<input type="hidden" name="pgno" value="${pgno}"> <input
			type="hidden" name="key" value="${key}"> <input type="hidden"
			name="word" value="${word}"> <input type="hidden"
			id="articleno" name="articleno" value="">
	</form>
	<script>
		let titles = document.querySelectorAll(".article-title");
		titles.forEach(function(title) {
			title.addEventListener("click", function() {
				document.querySelector("#articleno").value = this
						.getAttribute("data-no");
				document.querySelector("#form-no-param").submit();
			});
		});

		document.querySelector("#btn-mv-register").addEventListener("click",
				function() {
					let form = document.querySelector("#form-param");
					form.setAttribute("action", "${root}/board/write");
					form.submit();
				});

		document.querySelector("#btn-search").addEventListener("click",
				function() {
					let form = document.querySelector("#form-search");
					form.setAttribute("action", "${root}/board/list");
					form.submit();
				});

		let pages = document.querySelectorAll(".page-link");
		pages.forEach(function(page) {
			page.addEventListener("click", function() {
				document.querySelector("#pgno").value = this.parentNode
						.getAttribute("data-pg");
				let form = document.querySelector("#form-param");
				form.setAttribute("action", "${root}/board/list");
				form.submit();
			});
		});
	</script>
</body>
<%@ include file="../include/footer.jsp"%>


