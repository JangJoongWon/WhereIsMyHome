<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="userid-group" label="작성자:" label-for="userid">
          <b-form-input
            id="id"
            disabled
            v-model="article.id"
            type="text"
            required
            :placeholder="userid"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="subject-group" label="제목:" label-for="subject" description="제목을 입력하세요.">
          <b-form-input
            id="subject"
            v-model="article.subject"
            type="text"
            required
            placeholder="제목 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="내용:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.content"
            placeholder="내용 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>

        <b-button type="submit" variant="primary" class="m-1" v-if="this.type === 'register'">글작성</b-button>
        <b-button type="submit" variant="primary" class="m-1" v-else>글수정</b-button>
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { writeArticle, modifyArticle, getArticle } from "@/api/board";
import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "BoardInputItem",
  data() {
    return {
      article: {
        articleNo: this.article_no,
        id: "",
        subject: "",
        content: ""
      },
      isUserid: false
    };
  },

  computed: {
    ...mapState(userStore, ["userInfo", "userid"])
  },

  props: {
    type: { type: String },
    article_no: Number
  },

  created() {
    if (this.type === "modify") {
      getArticle(
        this.article.articleNo,
        ({ data }) => {
          this.article = data;
        },
        error => {
          console.log(error);
        }
      );
      this.isUserid = true;
    }
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.subject &&
        ((msg = "제목 입력해주세요"),
        (err = false),
        this.$refs.subject.focus());
      err &&
        !this.article.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      else
        this.type === "register" ? this.registArticle() : this.modifyArticle();
    },
    onReset(event) {
      event.preventDefault();
      this.article.articleNo = 0;
      this.article.subject = "";
      this.article.content = "";
      this.moveList();
    },
    registArticle() {
      let param = {
        id: this.userid,
        subject: this.article.subject,
        content: this.article.content
      };

      writeArticle(
        param,
        ({ data }) => {
          let msg = "등록이 실패했습니다.";
          if (data != null) {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        },
        error => {
          console.log(error);
        }
      );
    },
    modifyArticle() {
      let param = {
        articleNo: this.article.articleNo,
        id: this.userid,
        subject: this.article.subject,
        content: this.article.content
      };

      modifyArticle(
        param,
        ({ data }) => {
          let msg = "수정이 실패했습니다.";
          if (data != null) {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.moveList();
        },
        error => {
          console.log(error);
        }
      );
    },
    moveList() {
      this.$router.push({ name: "boardlist" });
    }
  }
};
</script>

<style></style>
