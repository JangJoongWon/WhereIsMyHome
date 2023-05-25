<template>
  <b-container class="mt-4" v-if="userInfo">
    <b-row>
      <b-col></b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <template #header>My Page</template>

          <template #lead>내 정보 확인페이지입니다.</template>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col>
              <b-col cols="4" align-self="start">{{ userInfo.id }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col>
              <b-col cols="4" align-self="start">{{ userInfo.name }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col>
              <b-col cols="4" align-self="start">{{ userInfo.email }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">전화번호</b-col>
              <b-col cols="4" align-self="start">{{ userInfo.phone }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button variant="primary" class="mr-1" @click="moveModifyUser">정보수정</b-button>
          <b-button variant="danger" class="mr-1" @click="quitUS">회원탈퇴</b-button>
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { quitUser } from "@/api/user";
import { mapState, mapActions } from "vuex";
const userStore = "userStore";

export default {
  name: "UserMyPage",
  // data() {
  //   return {
  //     userinfo: null
  //   };
  // },

  data() {
    return {
      userinfo: {
        id: "",
        pwd: "",
        name: "",
        email: "",
        phone: ""
      }
    };
  },

  created() {
    this.userInfo = this.$store.getters.checkUserInfo;
  },

  methods: {
    ...mapActions(userStore, ["quit"]),
    quitUS() {
      let out = confirm("탈퇴하시겠습니까?");
      if (out == true) {
        quitUser(
          this.userInfo.id,
          ({ data }) => {
            let msg = "탈퇴 실패하였습니다";
            if (data != null) {
              msg = "탈퇴가 완료되었습니다.";
            }
            alert(msg);
            this.quit();
          },
          error => {
            console.log(error);
          }
        );
      }
    },

    moveModifyUser() {
      this.$router.replace({
        name: "modify"
      });
    }
  },

  computed: {
    ...mapState(userStore, ["userInfo"])
  }
};
</script>

<style></style>



