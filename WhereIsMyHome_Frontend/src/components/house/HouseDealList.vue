<template>
  <div>
    <table border="2">
      <thead>
        <tr>
          <th>index</th>
          <th>dealAmount</th>
          <th>dealYear</th>
          <th>dealMonth</th>
          <th>dealDay</th>
          <th>area</th>
          <th>floor</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(houseDeal, index) in this.houseDeals" :key="index">
          <td>{{ index }}</td>
          <td>{{ houseDeal.dealAmount }}</td>
          <td>{{ houseDeal.dealYear }}</td>
          <td>{{ houseDeal.dealMonth }}</td>
          <td>{{ houseDeal.dealDay }}</td>
          <td>{{ houseDeal.area }}</td>
          <td>{{ houseDeal.floor }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseDealList",
  mounted() {
    this.CLEAR_HOUSE_DEAL();
  },
  methods: {
    ...mapMutations(houseStore, ["CLEAR_HOUSE_DEAL"]),
  },
  computed: {
    ...mapState(houseStore, ["houseDeals"]),
  },
}
</script>

<style>

</style>