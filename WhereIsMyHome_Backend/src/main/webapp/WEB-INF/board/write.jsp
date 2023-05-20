<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/nav.jsp"%>

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
<title>구해줘 Home!-board-write</title>
</head>
<body>
	<div class="container-fluid vh-100" style="margin-top: 150px">
		<div class="" style="margin-top: 100px">
			<div class="rounded d-flex justify-content-center">
				<div class="vw-100 shadow-lg p-5 bg-light">
					<div class="h-100">
						<h2 class="my-3 py-3 shadow-sm bg-light text-center">
							<mark class="sky">글쓰기</mark>
						</h2>
						<div class="col-lg-8 col-md-10 col-sm-12">
							<form id="form-register" method="POST"
								enctype="multipart/form-data" action="">
								<input type="hidden" name="pgno" value="1"> <input
									type="hidden" name="key" value=""> <input type="hidden"
									name="word" value="">
								<div class="mb-3">
									<label for="subject" class="form-label">제목 : </label> <input
										type="text" class="form-control" id="subject" name="subject"
										placeholder="제목..." />
								</div>
								<div class="mb-3">
									<label for="content" class="form-label">내용 : </label>
									<textarea class="form-control" id="content" name="content"
										rows="7"></textarea>
								</div>
								<div class="mb-3">
									<label for="upfile" class="form-label">파일:</label> <input
										type="file" class="form-control border" id="upfile"
										name="upfile" multiple="multiple">
								</div>
								<div class="col-auto text-center">
									<button type="button" id="btn-register"
										class="btn btn-outline-primary mb-3">글작성</button>
									<button type="button" id="btn-list"
										class="btn btn-outline-danger mb-3">목록으로이동...</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
 <form id="form-param" method="get" action="">
		<input type="hidden" id="pgno" name="pgno" value="${pgno}"> <input
			type="hidden" id="key" name="key" value="${key}"> <input
			type="hidden" id="word" name="word" value="${word}">
	</form>
	<script>
		document.querySelector("#btn-register").addEventListener("click",
				function() {
					if (!document.querySelector("#subject").value) {
						alert("제목 입력!!");
						return;
					} else if (!document.querySelector("#content").value) {
						alert("내용 입력!!");
						return;
					} else {
						let form = document.querySelector("#form-register");
						form.setAttribute("action", "${root}/board/write");
						form.submit();
					}
				});

		document.querySelector("#btn-list").addEventListener("click",
				function() {
					if (confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
						let form = document.querySelector("#form-param");
						form.setAttribute("action", "${root}/board/list");
						form.submit();
					}
				});
	</script> 
	<%@ include file="../include/footer.jsp"%>
</body>
</html>