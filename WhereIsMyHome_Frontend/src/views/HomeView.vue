
<template>
  <div style="height: calc(100vh - 60px)">
    <div class="box01">
      <div class="container1">
        <div class="part-1">아파트 실거래가 조회</div>
        <div class="part-2">
          <img class="img" src="@/assets/logo.png" alt="My Image" />
        </div>
      </div>
      <div class="container2">
        <div class="part-3">집이 없으신가요? 저희가 찾아드리죠</div>
        <div class="part-4">#아파트 #즐겨찾기 #뉴스 #주변정보 #정보 게시판</div>
        <div class="part-5">
          <router-link :to="{ name: 'house' }">아파트 보러가기</router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView"
};
</script>


<style scoped>
.box01 {
  width: 100%;
  height: 100%;
  text-align: center;
  position: relative;
  z-index: 1;
}
.box01::after {
  width: 100%;
  height: 100%;
  content: "";
  background: url("@/assets/city.jpg");
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
  filter: brightness(60%);
}
.container1 {
  /* border: 1px solid red; */
  margin-bottom: 100px;
  width: 100%;
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}

.container2 {
  /* border: 1px solid red; */

  margin-top: 100px;
  width: 100%;
  position: absolute;
  top: 55%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
}

.right {
  width: 50%;
}
.part-1 {
  font-size: 18px;
  font-weight: bold;
  margin: 10px;
}
.part-2 {
  font-size: 60px;
  font-weight: bold;
  margin: 20px;
}
.part-3 {
  font-size: 34px;
  font-weight: bold;
  margin: 10px;
}
.part-4 {
  font-size: 20px;
  margin: 20px 10px 30px 10px;
}
a {
  font-size: 16px;
  border: 2px solid white;
  border-radius: 10px;
  padding: 10px;
  cursor: pointer;
  text-decoration: none;
  color: white;
}
a:hover {
  text-decoration: none;
  color: white;
}

img {
  height: 250px;
  width: 450px;
}
</style>