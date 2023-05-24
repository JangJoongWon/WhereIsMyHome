<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>뉴스목록</h3>
        </b-alert>
      </b-col>
    </b-row>

    <b-row>
      <b-col v-if="newses.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>제목</b-th>
              <b-th>링크</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>

          <tbody>
            <!-- 하위 component인 NewsListItem에 데이터 전달(props) -->
            <news-list-items v-for="news in newses" :key="news.link" v-bind="news" class="news" />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
    <!-- <div class="d-flex justify-content-center">
      <b-pagination
        class="paging"
        v-model="currentPage"
        :total-rows="pageNavigation.totalCount-adminArticles.length"
        :per-page="perPage"
        @change="pageClick"
      ></b-pagination>
    </div>-->
  </b-container>
</template>

<script>
import { listNews, updateNews } from "@/api/news";
import NewsListItems from "@/components/news/NewsListItems";

export default {
  name: "NewsList",
  components: {
    NewsListItems
  },

  data() {
    return {
      newses: []
    };
  },

  created() {
    updateNews(
      ({ data }) => {
        console.log(data);
      },
      error => {
        console.log(error);
      }
    ),
      listNews(
        ({ data }) => {
          this.newses = data.newsList;
        },
        error => {
          console.log(error);
        }
      );
  },

  computed: {},

  method: {}
};
</script>