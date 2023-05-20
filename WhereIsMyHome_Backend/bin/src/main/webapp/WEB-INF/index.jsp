<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"
    scope="session" />

<body style = "background-size: cover; z-index: -1" background = "${root}/background/background.jpg" >
<%@ include file="include/nav.jsp"%>

<section class="py-5 text-center container vh-100">
  <div style = "margin-top:150px">
	<h1 style = "font-size:80px "><b>Where is My Home</b></h1>
  </div>
  <%-- start: 시, 구, 동을 선택하고 버튼을 누르면 검색결과를 보여준다 --%>
  <form style = "margin-bottom:50px" action="${root}/house" method="GET">
    <div class="py-lg-5">
      <div class="row col-md-12 justify-content-center mb-2">
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="sido" name="sido">
            <option value="">시도 선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="gugun" name="gugun">
            <option value="">구군 선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="dong" name="dong">
            <option value="">동 선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <button type="submit" id="list-btn" class="btn btn-dark">
            아파트매매정보
          </button>
        </div>
      </div>
    </div>
  </form>
  <%-- end: 시, 구, 동을 선택하고 버튼을 누르면 검색결과를 보여준다 --%>
</section>

<c:import url="include/footer.jsp"></c:import>


<script type="text/javascript" src="${root}/assets/js/get_City_Value.js"></script>
</body>
</html>