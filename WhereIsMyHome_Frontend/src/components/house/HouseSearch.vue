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

    <div v-show="sido && gugun && dong">{{ sido }} {{ gugun }} {{ dong }} 입니다.</div>
    
    <!-- <tr v-for="house in houses" :key="house.aptCode">
      <td>{{ house.apartmentName }}</td>
    </tr> -->
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
    this.getSido();
  },
  methods: {
    ...mapActions(houseStore, ["getSido", "getGugun", "getDong", "getHouseList"]),
    ...mapMutations(houseStore, ["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST", "CLEAR_DONG_LIST", "CLEAR_HOUSE_LIST", "CLEAR_HOUSE_DEAL"]),
    gugunList() {
      this.CLEAR_GUGUN_LIST();
      this.CLEAR_DONG_LIST();
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      this.gugun = null;
      this.dong = null;
      if (this.sido) this.getGugun(this.sido);
    },
    dongList() {
      this.CLEAR_DONG_LIST();
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      this.dong = null;
      if (this.gugun) this.getDong(this.gugun);
    },
    searchHouse() {
      this.CLEAR_HOUSE_LIST();
      this.CLEAR_HOUSE_DEAL();
      if (this.dong) this.getHouseList({
        dongName: this.dong,
        gugunName: this.gugun,
        sidoName: this.sido,
      });
    }
  }
}
</script>

<style>

</style>