<template >
  <b-tr>
    <b-td>{{ articleNo }}</b-td>
    <b-td>
      <a href @click="update">{{ subject }}</a>
    </b-td>
    <b-td>{{ hit }}</b-td>
    <b-td>{{ id }}</b-td>
    <b-td>{{ registerTime }}</b-td>
  </b-tr>
</template>

<script>
//import moment from "moment";
import { updateHit } from "@/api/board";
export default {
  name: "BoardListItems",
  props: {
    articleNo: Number,
    id: String,
    subject: String,
    hit: Number,
    registerTime: String
  },
  methods: {
    update(e) {
      e.preventDefault();
      updateHit(this.articleNo, ({ data }) => {
        console.log(data);
        this.$router.push({
          name: "boardview",
          params: { articleNo: this.articleNo }
        });
      });
      error => {
        console.log(error);
      };
    }
  }
};
</script>

<style>
a {
  color: black;
  font-weight: bold;
  text-decoration: underline;
}
a:hover {
  color: blue;
}
</style>
