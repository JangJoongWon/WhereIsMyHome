<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<title>구해줘 Home!</title>
</head>

<body>
    <header>
        <nav class="header-nav">
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
                            <li class="nav-item"><a class="nav-link active text-white "
                                aria-current="page" href="${root}">오늘의 뉴스</a></li>
                            <li class="nav-item"><a class="nav-link active text-white"
                                href="${root}">공지사항</a></li>
                                
                            <c:if test="${!empty logOK }">
                                <li class="nav-item"><a class="nav-link active text-white"
                                href="${root }/member/memberInsert.jsp" id="mypage">마이페이지</a></li>
                            </c:if>
                            
                            
                        </ul>
                        <ul class="navbar-nav mb-lg-0">
                            <c:if test="${empty logOK }">
                                <button
                                    class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
                                    type="submit" id="login1"
                                    onclick="location.href='${root}/login';">로그인</button>
                                <button
                                    class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
                                    type="submit" id="signup1"
                                    onclick="location.href='${root }/user/signup';">회원가입</button>
                            </c:if>
                            
                            <c:if test="${!empty logOK }">
                                
                                <button
                                    class="btn btn-default btn-sm btn-outline-light btn-lg col-auto m-2"
                                    type="submit" id="logout" onclick="location.href = '${root }/logout';">로그아웃</button>
                                    <%-- <a href="${root }/member?action=memberinfo">내 정보</a> --%>
                            </c:if>
            
                        </ul>
                    </div>
                </div>
                </div>
            </nav>
    </header>