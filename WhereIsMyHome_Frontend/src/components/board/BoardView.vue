<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show>
          <h3>글보기</h3>
        </b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="moveList">목록</b-button>
      </b-col>
      <!-- <b-col class="text-right" v-if="userInfo.id === article.id"> -->
      <b-col class="text-right">
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          v-if="article.id == userid"
        >글수정</b-button>
        <b-button
          variant="outline-danger"
          size="sm"
          @click="deleteArticle"
          v-if="article.id == userid"
        >글삭제</b-button>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.articleNo}.
          ${article.subject} [조회수: ${article.hit}]</h3><div><h6>${article.id}</div><div>${article.registerTime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>

    <br />
    <br />
    <br />
    <br />

    <b-card header="댓글 목록">
      <div v-for="memoItem in memoList" :key="memoItem.id">
        댓글 작성자: {{ memoItem.id}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 댓글: {{ memoItem.comment }} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 작성시간: {{ memoItem.memo_time}}
        <b-button variant="success" class="m-1" @click="modifyComment(memoItem.memo_no)">댓글수정</b-button>
        <b-button variant="danger" class="m-1" @click="deleteComment">댓글삭제</b-button>
      </div>
    </b-card>

    <br />
    <br />
    <br />
    <br />

    <b-card header="댓글 작성">
      <b-form>
        <b-form-group id="memo-group" label-for="memo">
          <b-form-textarea
            id="memo"
            v-model="memo.comment"
            placeholder="댓글을 입력하세요..."
            rows="3"
            max-rows="3"
          ></b-form-textarea>
        </b-form-group>
        <b-button variant="primary" class="m-1" @click="writeM">댓글작성</b-button>
      </b-form>
    </b-card>
  </b-container>
</template>

<script>
// import moment from "moment";
import { getArticle, writeMemo, modifyMemo } from "@/api/board";
import { mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "BoardDetail",
  data() {
    return {
      article: {},
      memo: {
        memo_no: 0,
        id: "",
        comment: "",
        article_no: 0
      },
      memoList: []
    };
  },

  created() {
    let param = this.$route.params.articleNo;
    getArticle(
      param,
      ({ data }) => {
        this.article = data.article;
        this.memoList = data.memos;
        console.log(this.memoList);
      },
      error => {
        console.log(error);
      }
    );
  },
  computed: {
    ...mapState(userStore, ["userid", "userInfo"]),
    message() {
      if (this.article.content)
        return this.article.content.split("\n").join("<br>");
      return "";
    }
  },
  methods: {
    moveModifyArticle() {
      this.$router.replace({
        name: "boardmodify",
        params: { articleNo: this.article.articleNo }
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "boarddelete",
          params: { articleNo: this.article.articleNo }
        });
      }
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    },

    //댓글 작성
    writeM() {
      let memo = {
        id: this.userid,
        comment: this.memo.comment,
        article_no: this.article.articleNo,
        memo_no: this.memo_no
      };

      let param = this.$route.params.articleNo;

      writeMemo(
        param,
        memo,
        ({ data }) => {
          let msg = "댓글 등록에 실패했습니다";
          if (data == 1) {
            msg = "댓글 등록에 성공했습니다";
            getArticle(
              param,
              ({ data }) => {
                this.article = data.article;
                this.memoList = data.memos;
              },
              error => {
                console.log(error);
              }
            );
            this.memo.comment = "";
          }
          alert(msg);
        },
        error => {
          console.log(error);
        }
      );
    },

    modifyComment(memo_no) {
      console.log(memo_no);
      modifyMemo(
        memo_no,
        ({ data }) => {
          let msg = "댓글 수정에 실패했습니다";
          if (data == null) {
            msg = "댓글 수정에 성공했습니다";
          }
          alert(msg);
        },
        error => {
          console.log(error);
        }
      );
    },

    deleteComment() {}
  }
};
</script>

<style></style>
