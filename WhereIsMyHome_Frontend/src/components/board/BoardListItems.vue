<template >
  <b-tr>
    <b-td>{{ articleNo }}</b-td>
    <b-th class="text-left">
      <router-link :to="{ name: 'boardview', params: { articleNo: articleNo } }">{{ subject }}</router-link>
    </b-th>
    <b-td>{{ hit }}</b-td>
    <b-td>{{ id }}</b-td>
    <b-td>{{ registerTime }}</b-td>
  </b-tr>
</template>

<script>
//import moment from "moment";

export default {
  name: "BoardListItems",
  props: {
    articleNo: Number,
    id: String,
    subject: String,
    hit: Number,
    registerTime: String
  }
};
</script>

<style></style>
