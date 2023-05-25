<template>
  <section v-if="this.houseDeals != 0">
    <div class="title">아파트 거래내역</div>
    <div class="tbl-header">
      <table cellpadding="0" cellspacing="0" border="0">
        <thead>
          <tr>
            <th>no</th>
            <th>거래 금액</th>
            <th>년도</th>
            <th>월</th>
            <th>일</th>
            <th>면적</th>
            <th>층수</th>
          </tr>
        </thead>
      </table>
    </div>
    <div class="tbl-content">
      <table cellpadding="0" cellspacing="0" border="0">
        <tbody>
          <tr v-for="(houseDeal, index) in this.houseDeals" :key="index">
            <td>{{ index + 1 }}</td>
            <td>{{ houseDeal.dealAmount }}원</td>
            <td>{{ houseDeal.dealYear }}</td>
            <td>{{ houseDeal.dealMonth }}</td>
            <td>{{ houseDeal.dealDay }}</td>
            <td>{{ houseDeal.area }}</td>
            <td>{{ houseDeal.floor }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </section>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import $ from 'jquery';

const houseStore = "houseStore";

export default {
  name: "HouseDealList",
  mounted() {
    $(window).on("load resize", function() {
      var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
      $('.tbl-header').css({'padding-right':scrollWidth});
    }).resize();
  },
  methods: {
    ...mapMutations(houseStore, ["CLEAR_HOUSE_DEAL"]),
  },
  computed: {
    ...mapState(houseStore, ["houseDeals"]),
  },
}

</script>

<style scoped>
.title{
  height: 40px;
}

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
section{
  width: 750px;
  height: 500px;
  background: -webkit-linear-gradient(left, #ffffff, #ffffff);
  background: linear-gradient(to right, #ffffff, #ffffff);
  font-family: 'Roboto', sans-serif;
  font-weight: bold;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
}
.tbl-content{
  height:400px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500 bold;
  font-size: 17px;
  color: #000000;
  background-color: rgb(209, 209, 209);
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300 bold;
  font-size: 15px;
  color: #000000;
  background-color: rgb(255, 243, 227);
  border-bottom: solid 1px rgba(255,255,255,0.1);
}
::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
</style>