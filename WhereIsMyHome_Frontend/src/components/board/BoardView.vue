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
          v-if="article.id == userid || userid == 'admin'"
        >글수정</b-button>
        <b-button
          variant="outline-danger"
          size="sm"
          @click="deleteArticle"
          v-if="article.id == userid || userid == 'admin'"
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

    <b-card header="댓글 목록">
      <div class="comment-line" v-for="memoItem in memoList" :key="memoItem.memo_no" style>
        <div class="writer" style="display:inline-block">작성자: {{ memoItem.id}}</div>
        <div class="comment" style="display:inline-block">댓글: {{ memoItem.comment }}</div>
        <div class="time" style="display:inline-block">작성시간: {{ memoItem.memo_time}}</div>
        <div v-if="memoItem.id == userid||userid=='admin'">
          <b-button
            class="edit-button"
            size="sm"
            variant="outline-success"
            @click="ableInput(memoItem.memo_no)"
            style="display:inline-block"
          >댓글수정</b-button>
          <b-button
            class="delete-button"
            size="sm"
            variant="outline-danger"
            @click="deleteComment(memoItem.memo_no)"
            style="display:inline-block"
          >댓글삭제</b-button>
        </div>
      </div>
      <div v-show="commentMod" class="upMemo">
        <b-form>
          <b-form-group id="memo-group" label-for="memo">
            <b-form-textarea
              id="memo"
              v-model="comment2"
              placeholder="수정할 댓글을 입력하세요..."
              rows="2"
              max-rows="4"
            ></b-form-textarea>
          </b-form-group>
          <b-button @click="modifyComment()" class="BUpButton">수정</b-button>
          <b-button @click="UnableInput()">취소</b-button>
        </b-form>
      </div>
    </b-card>

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
import { getArticle, writeMemo, modifyMemo, deleteMemo } from "@/api/board";
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
      memoList: [],
      commentMod: false,
      modifyMemoNum: 0,
      comment2: ""
    };
  },

  created() {
    let param = this.$route.params.articleNo;
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

    modifyComment() {
      this.memo_no = this.modifyMemoNum;
      this.memo.comment = this.comment2;

      let memo = {
        id: this.userid,
        comment: this.memo.comment,
        article_no: this.article.articleNo,
        memo_no: this.memo_no
      };

      let param = this.$route.params.articleNo;

      modifyMemo(
        memo,
        ({ data }) => {
          let msg = "댓글 수정에 실패했습니다";
          if (data == 1) {
            msg = "댓글 수정에 성공했습니다";
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
            this.comment2 = "";
            this.commentMod = false;
          }
          alert(msg);
        },
        error => {
          console.log(error);
        }
      );
    },

    ableInput(num) {
      this.modifyMemoNum = num;
      this.commentMod = true;
    },

    deleteComment(memo_no) {
      let param = this.$route.params.articleNo;
      confirm("댓글을 삭제하시겠습니까?");
      deleteMemo(memo_no, ({ data }) => {
        let msg = "댓글 삭제에 실패했습니다";
        if (data == 1) {
          msg = "댓글 삭제에 성공했습니다";
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
          this.comment2 = "";
        }
        alert(msg);
      });
    },
    UnableInput() {
      this.commentMod = false;
    }
  }
};
</script>

<style scopred lang="css">
.comment-line {
  display: flex;
  margin-bottom: 5px;
}
.writer {
  width: 240px;
  text-align: left;
  margin-left: 50px;
}
.comment {
  width: 300px;
  text-align: left;
}
.time {
  width: 300px;
  text-align: left;
}
.upMemo {
  margin-top: 50px;
}
.BUpButton {
  margin-right: 10px;
}
</style>
