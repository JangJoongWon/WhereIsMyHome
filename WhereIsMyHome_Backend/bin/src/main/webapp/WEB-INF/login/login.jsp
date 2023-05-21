<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body style = "background-size: cover" background = "../background/background.jpg" >
<%@ include file="../include/nav.jsp"%>

<!-- start -->
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
</head>

<body>
	<main>
	<section class="py-5 text-center container">
		<div class="container-fluid vh-100" style="margin-top: 150px">
			<div class="" style="margin-top: 100px">
				<div class="rounded d-flex justify-content-center">
					<div class="col-md-4 col-sm-12 shadow-lg p-5 bg-light">
						<div class="text-center">
							<h3 class="text-dark">Sign In</h3>
						</div>

						<div class="p-4">
							<form action="${root }/login" method="post">
								<input type="hidden" name="action" value="login">
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-person-plus-fill text-white"></i></span> <input
										id="userid" type="text" class="form-control" placeholder="ID"
										name="id">
								</div>
								<div class="input-group mb-3">
									<span class="input-group-text"
										style="background-color: #929292;"><i
										class="bi bi-key-fill text-white"></i></span> <input id="userpwd"
										type="password" class="form-control" placeholder="password"
										name="pwd">
								</div>
								<button type="submit" class="btn btn-primary text-center mt-2">Login</button>
							</form>
							<p class="text-center mt-5">
								Don't have an account? <a href="${root }/user/signup.jsp">Sign Up</a>
							</p>
							Forgot your password? <a href="${root }/user/userPwdSearch.jsp">Find Password</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	</main>
	
<script type="text/javascript" src="${root}/assets/js/login.js"></script>
</body>
</html>
