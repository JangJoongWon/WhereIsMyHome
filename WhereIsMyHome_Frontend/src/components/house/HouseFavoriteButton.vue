<template>
  <span>
    <b-icon v-if="isRegist==0" @click="regist" icon="star" variant="warning" font-scale=2></b-icon>
    <b-icon v-if="isRegist!=0" @click="del" icon="star-fill" variant="warning" font-scale=2></b-icon>
  </span>
</template>

<script>
import { registFavorite, getFavorites, checkFavorites, deleteFavorites } from "@/api/favorite.js";
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
    del() {
      deleteFavorites({
        aptCode: this.houses[this.houseIdx].aptCode,
        userid: this.userid,
      },
      ( response ) => {
        console.log(response);
        getFavorites(
          this.userid,
          ({ data }) => {
            this.favorites = data;
          },
          (error) => {
            console.log(error);
          }
        );
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