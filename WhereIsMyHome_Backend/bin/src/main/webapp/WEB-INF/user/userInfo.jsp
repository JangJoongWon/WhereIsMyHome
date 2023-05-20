<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body style = "background-size: cover" background = "background/background.jpg" >
<c:import url="../include/nav.jsp"></c:import>

<c:if test="${!empty userinfo}">
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


                            <!-- id -->
                            <div class="input-group mb-3">
                                <span class="input-group-text"
                                    style="background-color: #929292;"> <img
                                    src="../img/user.png" style="width: 20px; height: 20px;">
                                    <i class="bi bi-person-plus-fill text-white"></i></span> <input
                                    id="userid" type="text" class="form-control"
                                    placeholder="${userinfo.userId}" disabled>
                            </div>

                            <!-- 비밀번호 -->
                            <div class="input-group mb-3">
                                <span class="input-group-text"
                                    style="background-color: #929292;"> <img
                                    src="../img/user.png" style="width: 20px; height: 20px;">
                                    <i class="bi bi-person-plus-fill text-white"></i></span> <input
                                    id="userid" type="text" class="form-control"
                                    placeholder="${userinfo.userPwd}" disabled>
                            </div>

                            <!-- 이름 -->
                            <div class="input-group mb-3">
                                <span class="input-group-text"
                                    style="background-color: #929292;"> <img
                                    src="../img/name.png" style="width: 20px; height: 20px;">
                                    <i class="bi bi-person-plus-fill text-white"></i></span> <input
                                    id="username" type="text" class="form-control"
                                    placeholder="${userinfo.userName}" disabled>
                            </div>

                            <!-- 주소 -->
                            <div class="input-group mb-3">
                                <span class="input-group-text"
                                    style="background-color: #929292;"> <img
                                    src="../img/address.png" style="width: 20px; height: 20px;">
                                    <i class="bi bi-person-plus-fill text-white"></i></span> <input
                                    id="address" type="text" class="form-control"
                                    placeholder="${userinfo.userAddress}" disabled>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text"
                                    style="background-color: #929292;"> <img
                                    src="../img/phone.png" style="width: 20px; height: 20px;">
                                    <i class="bi bi-person-plus-fill text-white"></i></span> <input
                                    id="phoneNum" type="text" class="form-control"
                                    placeholder="${userinfo.userPhone}" disabled>
                            </div>


                            <form action="${root}/user/userUpdate.jsp" method="post"
                                style='display: inline'>
                                <input type="hidden" name="id" value="${userinfo.userId}">
                                <input type="hidden" name="pwd" value="${userinfo.userPwd}">
                                <input type="hidden" name="name" value="${userinfo.userName}">
                                <input type="hidden" name="address"
                                    value="${userinfo.userAddress}"> <input type="hidden"
                                    name="phone" value="${userinfo.userPhone}"> <input
                                    type="submit" value="수정"
                                    class="btn btn-primary text-center mt-2">
                            </form>


                            <form action="${root}/user" method="post" style='display: inline'>
                                <input type="hidden" name="action" value="deleteuser"> <input
                                    type="hidden" name="id" value="${userinfo.userId}"> <input
                                    type="submit" value="회원탈퇴" onclick="return confirm('탈퇴할까요?')"
                                    class="btn btn-danger text-center mt-2">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>
</body>
</html>


