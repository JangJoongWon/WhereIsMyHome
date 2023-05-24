<template>
  <div>
    <house-search></house-search>
    <house-map></house-map>
    <house-deal-list></house-deal-list>
  </div>
</template>

<script>
import HouseSearch from "@/components/house/HouseSearch";
import HouseMap from "@/components/house/HouseMap";
import HouseDealList from "@/components/house/HouseDealList";
import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "AppHouse",
  created() {
    if (this.userInfo == null) {
      alert("로그인이 필요한 서비스 입니다");
      this.$router.push({ name: "login" });
    }
  },
  computed: {
    ...mapState(userStore, ["userInfo"])
  },
  components: {
    HouseSearch,
    HouseMap,
    HouseDealList
  }
};
</script>

<style>
</style>