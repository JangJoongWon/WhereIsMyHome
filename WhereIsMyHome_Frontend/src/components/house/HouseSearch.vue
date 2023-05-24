<template>
  <div>
    <b-row class="mt-4 mb-4 text-center">
      <b-col class="sm-3">
        <b-form-select v-model="sido" :options="sidos" @change="gugunList"></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select v-model="gugun" :options="guguns" @change="dongList"></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select v-model="dong" :options="dongs" @change="searchHouse"></b-form-select>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";

export default {
  name: 'HouseSearch',
  data() {
    return {
      sido: null,
      gugun: null,
      dong: null,
    };
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs"]),
  },
  created() {
    this.CLEAR_SIDO_LIST();
    this.CLEAR_GUGUN_LIST();
    this.CLEAR_DONG_LIST();
    this.CLEAR_HOUSE_LIST();
    this.CLEAR_HOUSE_DEAL();
    this.getSidos();
  },
  methods: {
    ...mapActions(houseStore, ["getSidos", "getGuguns", "getDongs", "getHouseList"]),
    ...mapMutations(houseStore, ["SET_SIDO", 
                                "SET_GUGUN", 
                                "SET_DONG", 
                                "CLEAR_SIDO", 
                                "CLEAR_GUGUN", 
                                "CLEAR_DONG", 
                                "CLEAR_APTNAME",
                                "CLEAR_SIDO_LIST", 
                                "CLEAR_GUGUN_LIST", 
                                "CLEAR_DONG_LIST", 
                                "CLEAR_HOUSE_LIST", 
                                "CLEAR_HOUSE_DEAL"]),
    gugunList() {
      this.CLEAR_GUGUN();
      this.CLEAR_DONG();
      this.gugun = null;
      this.dong = null;
      this.CLEAR_APTNAME();
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      if (this.sido) this.getGuguns(this.sido);
    },
    dongList() {
      this.CLEAR_DONG();
      this.dong = null;
      this.CLEAR_APTNAME();
      this.CLEAR_DONG_LIST();
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      if (this.gugun) this.getDongs(this.gugun);
    },
    searchHouse() {
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      this.SET_SIDO(this.sido);
      this.SET_GUGUN(this.gugun);
      this.SET_DONG(this.dong);
      if (this.dong) this.getHouseList({
        sidoName: this.sido,
        gugunName: this.gugun,
        dongName: this.dong,
      });
    }
  },
}
</script>

<style>

</style>