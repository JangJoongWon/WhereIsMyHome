<template>
  <div>
    <button v-if="isRegist == 0" @click="regist">'{{ this.houses[this.houseIdx].apartmentName }}'을(를) 관심목록으로 등록</button>
    <div v-if="isRegist != 0">'{{ this.houses[this.houseIdx].apartmentName }}'을(를) 관심목록으로 등록되었음</div>
  </div>
</template>

<script>
import { registFavorite, checkFavorites } from "@/api/favorite.js";
import { mapState } from "vuex";

const houseStore = "houseStore";
const userStore = "userStore";

export default {
  name: "HouseFavoriteButton",
  data() {
    return {
      isRegist: null,
    };
  },
  props: {
    houseIdx: Number,
  },
  created() {
    checkFavorites({
      aptCode: this.houses[this.houseIdx].aptCode,
      userid: this.userid,
    },
    ( response ) => {
      this.isRegist = response.data;
    },
    ( error ) => {
      console.log(error);
    })
  },
  watch: {
    houseIdx() {
      checkFavorites({
          aptCode: this.houses[this.houseIdx].aptCode,
          userid: this.userid,
        },
        ( response ) => {
          this.isRegist = response.data;
        },
        ( error ) => {
          console.log(error);
        })
    }
  },
  computed: {
    ...mapState(houseStore, ["sido", "gugun", "dong", "houses", "houseDeals"]),
    ...mapState(userStore, ["userid", "userInfo"]),
  },
  methods: {
    regist() {
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
        checkFavorites({
          aptCode: this.houses[this.houseIdx].aptCode,
          userid: this.userid,
        },
        ( response ) => {
          this.isRegist = response.data;
        },
        ( error ) => {
          console.log(error);
        })
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