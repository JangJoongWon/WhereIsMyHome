<template >
  <b-tr>
    <b-td v-html="title"></b-td>
    <b-td>
      <a :href="link">{{ link }}</a>
    </b-td>
    <b-td>{{ postDate|yyyyMMdd }}</b-td>
  </b-tr>
</template>

<script>
export default {
  name: "NewsListItems",
  props: {
    title: String,
    context: String,
    link: String,
    postDate: String
  },

  filters: {
    // filter로 쓸 filter ID 지정
    yyyyMMdd: function(value) {
      if (value == "") return "";

      // 현재 Date 혹은 DateTime 데이터를 javaScript date 타입화
      var js_date = new Date(value);

      // 연도, 월, 일 추출
      var year = js_date.getFullYear();
      var month = js_date.getMonth() + 1;
      var day = js_date.getDate();

      // 월, 일의 경우 한자리 수 값이 있기 때문에 공백에 0 처리
      if (month < 10) {
        month = "0" + month;
      }

      if (day < 10) {
        day = "0" + day;
      }

      // 최종 포맷 (ex - '2021-10-08')
      return year + "-" + month + "-" + day;
    }
  }
};
</script>

<style>
</style>
