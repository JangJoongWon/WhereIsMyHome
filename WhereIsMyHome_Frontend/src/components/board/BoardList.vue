<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>글목록</h3>
        </b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button variant="outline-primary" @click="moveWrite()">글쓰기</b-button>
      </b-col>
    </b-row>
    <b-row>
      <b-col v-if="articles.length||adminArticles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>제목</b-th>
              <b-th>조회수</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>

          <tbody>
            <!-- 하위 component인 BoardListItem에 데이터 전달(props) -->
            <board-list-item
              v-for="adarticle in adminArticles"
              :key="adarticle.articleno"
              v-bind="adarticle"
              class="adarticle"
            />

            <board-list-item v-for="article in listP" :key="article.articleno" v-bind="article" />
          </tbody>
        </b-table-simple>
      </b-col>
      <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
    </b-row>
    <div class="d-flex justify-content-center">
      <b-pagination
        class="paging"
        v-model="currentPage"
        :total-rows="pageNavigation.totalCount-adminArticles.length"
        :per-page="perPage"
        @change="pageClick"
      ></b-pagination>
    </div>
  </b-container>
</template>

<script>
import { listArticle } from "@/api/board";
import BoardListItem from "@/components/board/BoardListItems";
import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "BoardList",
  components: {
    BoardListItem
  },
  data() {
    return {
      adminArticles: [],
      articles: [],
      pageNavigation: [],
      listP: [],
      perPage: 8,
      currentPage: 1
    };
  },

  created() {
    if (this.userInfo == null) {
      alert("로그인이 필요한 서비스 입니다");
      this.$router.push({ name: "login" });
    }
    let param = {
      pgno: 1,
      spp: 20,
      key: null,
      word: null
    };

    listArticle(
      param,
      ({ data }) => {
        this.articles = data.boardlist;
        this.adminArticles = data.adminboardlist;
        this.pageNavigation = data.pageNavigation;
        this.makePage(this.currentPage);
      },
      error => {
        console.log(error);
      }
    );
  },

  computed: {
    ...mapState(userStore, ["userInfo"]),
    rows() {
      return this.articles.length;
    },

    totalRows() {
      console.log(this.pageNavigation.totalCount);
      return this.pageNavigation.totalCount;
    }
  },

  methods: {
    moveWrite() {
      this.$router.push({ name: "boardwrite" });
    },

    pageClick(page) {
      this.currentPage = page;
      this.makePage(this.currentPage);
    },

    makePage(pageNum) {
      this.listP = this.articles.slice(
        (pageNum - 1) * this.perPage,
        pageNum * this.perPage
      );
    }
  }
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
.adarticle {
  background-color: rgb(254, 221, 198);
}
</style>
