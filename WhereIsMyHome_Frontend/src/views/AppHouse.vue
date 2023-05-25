<template>
  <div>
    <house-search></house-search>
    <div id="main-body">
      <house-map></house-map>
      <house-deal-list v-if="this.houseDeals && this.houseDeals.length != 0"></house-deal-list>
      <div id="test" v-if="!this.dong && this.houseDeals && this.houseDeals.length == 0">
        <div id="text">
          지역을 선택해주세요.
        </div>
        <div>
          <b-icon icon="geo-alt" animation="fade" font-scale=10></b-icon>
        </div>
      </div>
      <div id="test" v-if="this.dong && this.houses && this.houses.length != 0 &&this.houseDeals && this.houseDeals.length == 0">
        <div id="text">
          아파트를 선택해주세요!
        </div>
        <div>
          <b-icon icon="house-door" animation="fade" font-scale=10></b-icon>
        </div>
      </div>
      <div id="test" v-if="this.dong && this.houses && this.houses.length == 0 && this.houseDeals && this.houseDeals.length == 0">
        <div id="text">
          아파트 정보가 없습니다.
        </div>
        <div>
          <b-icon icon="exclamation-triangle" animation="fade" font-scale=10></b-icon>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch";
import HouseMap from "@/components/house/HouseMap";
import HouseDealList from "@/components/house/HouseDealList";
import { mapState } from "vuex";

const houseStore ="houseStore";
const userStore = "userStore";

export default {
  name: "AppHouse",
  created() {
    if (this.userInfo == null) {
      alert("로그인이 필요한 서비스 입니다");
      this.$router.push({ name: "login" });
      return;
    }
  },
  computed: {
    ...mapState(houseStore, ["dong", "houses", "houseDeals"]),
    ...mapState(userStore, ["userInfo"]),
  },
  components: {
    HouseSearch,
    HouseMap,
    HouseDealList
  }
};
</script>

<style scoped>
#main-body {
  width: 100%;
  height: 600px;
  display: flex;
  justify-content: space-evenly;
  font-weight: bold;
  font-size: 20px;
}

#text{
  height: 100px;
}

#test {
  width: 750px;
  height: 500px;
}
</style>