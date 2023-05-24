<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>글수정</h3>
        </b-alert>
      </b-col>
    </b-row>
    <board-input-item :type="modify" :article_no="articleNo" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/BoardInputItem";

export default {
  name: "BoardModify",
  created() {
    let articleNo = this.$route.params.articleNo;
    this.articleNo = articleNo;
  },
  components: {
    BoardInputItem
  },
  data() {
    return {
      articleNo: 0
    };
  }
};
</script>

<style></style>
