<template>
  <div>
    <button v-if="favoriteNum == 0" @click="registFavorite">'{{ this.houses[this.houseIdx].apartmentName }}'을(를) 관심목록으로 등록</button>
    <div v-if="favoriteNum != 0">'{{ this.houses[this.houseIdx].apartmentName }}'을(를) 관심목록으로 등록되었음</div>
  </div>
</template>

<script>
import { registFavorite } from "@/api/favorite.js";
import { mapState } from "vuex";

const houseStore = "houseStore";
const userStore = "userStore";

export default {
  name: "HouseFavoriteButton",
  props: {
    houseIdx: Number,
    favoriteNum: Number,
  },
  computed: {
    ...mapState(houseStore, ["sido", "gugun", "dong", "houses", "houseDeals"]),
    ...mapState(userStore, ["userid", "userInfo"]),
  },
  methods: {
    registFavorite() {
      registFavorite({
        sidoName: this.sido,
        gugunName: this.gugun,
        dongName: this.dong,
        aptCode: this.houses[this.houseIdx].aptCode,
        userid: this.userid,
        apartmentName: this.houses[this.houseIdx].apartmentName,
      },
      ( response ) => {
        console.log(response);
      },
      ( error ) => {
        console.log(error);
      })
    },
  },
}
</script>

<style>

</style>