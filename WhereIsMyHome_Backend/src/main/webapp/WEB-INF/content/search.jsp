<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:import url="../include/head.jsp"/> --%>
<body style = "background-size: cover" background = "background/background.jpg" >
<c:import url="../include/nav.jsp"/>
	<!-- 선택 정보 확  -->
	<section class="py-5 text-center container">
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
          <button type="submit" id="aptListBtn" class="btn btn-dark">
            아파트매매정보
          </button>
        </div>
      </div>
    </div>
</section>
	<div style="text-align: center">
			<h1> 🐢 ${param.sido} ${param.gugun} ${param.dong}의 거래내역입니당 😎 </h1>
	</div>
	<!-- 지도 -->
	<section>
        <div class="row justify-content-center vh-100">
          <div id="map" class="col-md-6" style="width: 700px; height: 400px"></div>
          <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c8ec7c3f5bc53da924cb2b104e021a64"></script>
          <div
            id="scroll-box"
            class="col-md-6"
            style="width: 400px; height: 400px; overflow-y: scroll; background-color: white"; 
          >
           <ul id="apt-list">
              <!-- 여기는 데이터 들어오면 JS에서 li태그 만들어주기 -->
            </ul>
          </div>
        </div>
      </section>
	<!-- 지도 끝 -->
<c:import url="../include/footer.jsp"/>
<script type="text/javascript" src="${root}/assets/js/search.js"></script>
<script type="text/javascript" src="${root}/assets/js/get_City_Value.js"></script>
<script type="text/javascript" src="${root}/assets/js/aptList.js"></script>
<script type="text/javascript" src="${root}/assets/js/aptSearchBtn.js"></script>
</body>
</html>