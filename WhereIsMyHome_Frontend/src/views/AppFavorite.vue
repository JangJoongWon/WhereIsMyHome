<template>
  <div>
    <div v-if="this.favorites.length == 0">
        <div id="text">
          목록이 비었습니다.
        </div>
      <b-icon icon="exclamation-triangle" font-scale=10></b-icon>
    </div>
    <div v-if="this.favorites.length != 0">
    <div id="title">관심목록</div>
      <table border="2">
        <thead>
          <tr>
            <th>no</th>
            <th>시/도</th>
            <th>구/군</th>
            <th>동</th>
            <th>아파트 이름</th>
            <th>검색</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="( favorite, index ) in this.favorites" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ favorite.sidoName }}</td>
            <td>{{ favorite.gugunName }}</td>
            <td>{{ favorite.dongName }}</td>
            <td>{{ favorite.apartmentName }}</td>
            <td><button class="search" @click="moveHouse(index)">검색</button></td>
            <td><button class="delete" @click="delFavorite(index)">삭제</button></td>
          </tr>
        </tbody>
      </table>
    </div>
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
      if(confirm(`'${this.favorites[index].apartmentName}'을(를) 검색하시겠습니까?`)){
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
      }
    },
    delFavorite(index) {
      if(confirm(`'${this.favorites[index].apartmentName}'을(를) 삭제하시겠습니까?`)){
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
    }
  },
}
</script>

<style scoped>
#text{
  font-size: 20px;
  font-weight: bold;
  margin-top: 30px;
  height: 100px;
}
#title{
  font-size: 40px;
  font-weight: bold;
  margin-top: 30px;
}

table {
  width: 700px;
  text-align: center;
  border: 1px solid #fff;
  border-spacing: 1px;
  font-family: 'Cairo', sans-serif;
  margin: auto;
  margin-top: 30px;
}
table td {
  padding: 10px;
  background-color: #eee;
}

table th {
  background-color: #333;
  color: #fff;
  padding: 10px;
}
.search,
.delete {
  border: none;
  padding: 5px 10px;
  color: #fff;
  font-weight: bold;
}

.search {
  background-color: #03A9F4;
}

.delete {
  background-color: #E91E63;
}
</style>