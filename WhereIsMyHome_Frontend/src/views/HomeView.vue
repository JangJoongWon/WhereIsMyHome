
<template>
  <div style="height: calc(100vh - 60px)">
    <div class="box01">
      <div class="container">
        <div class="part-1">아파트 실거래가 조회</div>
        <div class="part-2">WhereIsMyHome?</div>
        <div class="part-3">우리집처럼 느껴지는 편안한 서비스를 선보입니다.</div>
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
  filter: brightness(50%);
}
.container {
  /* border: 1px solid red; */
  justify-content: center;
  align-items: center;
  width: 100%;
  position: absolute;
  top: 50%;
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
</style>