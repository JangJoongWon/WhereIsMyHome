<template>
  <div>
    <table border="2">
      <thead>
        <tr>
          <th>index</th>
          <th>sidoName</th>
          <th>gugunName</th>
          <th>dongName</th>
          <th>apartmentName</th>
          <th>search</th>
          <th>delete</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="( favorite, index ) in this.favorites" :key="index">
          <td>{{ index }}</td>
          <td>{{ favorite.sidoName }}</td>
          <td>{{ favorite.gugunName }}</td>
          <td>{{ favorite.dongName }}</td>
          <td>{{ favorite.apartmentName }}</td>
          <td><button @click="moveHouse(index)">검색</button></td>
          <td><button @click="delFavorite(index)">삭제</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { getFavorites, deleteFavorites } from "@/api/favorite.js";
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";
const userStore = "userStore";

export default {
  name: "AppFavorite",
  data() {
    return{
      favorites: [],
    };
  },
  mounted() {
    if (this.userInfo == null) {
      alert("로그인이 필요한 서비스 입니다");
      this.$router.push({ name: "login" });
      return;
    }

    getFavorites(
      this.userid,
      ({ data }) => {
        this.favorites = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  computed: {
    ...mapState(userStore, ["userid", "userInfo"]),
  },
  methods: {
    ...mapActions(houseStore, ["getHouseList", "getHouseDealList"]),
    ...mapMutations(houseStore, ["SET_SIDO", "SET_GUGUN", "SET_DONG", "SET_APTNAME"]),
    moveHouse(index) {
      this.$router.push(`/house`, () => {
        this.getHouseList({
          sidoName: this.favorites[index].sidoName,
          gugunName: this.favorites[index].gugunName,
          dongName: this.favorites[index].dongName,
        });
        this.getHouseDealList(this.favorites[index].aptCode);

        this.SET_SIDO(this.favorites[index].sidoName);
        this.SET_GUGUN(this.favorites[index].gugunName);
        this.SET_DONG(this.favorites[index].dongName);
        this.SET_APTNAME(this.favorites[index].apartmentName);
      });
    },
    delFavorite(index) {
      deleteFavorites({
        aptCode: this.favorites[index].aptCode,
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
      },
      ( error ) => {
        console.log(error);
      })
    }
  },
}
</script>

<style>

</style>