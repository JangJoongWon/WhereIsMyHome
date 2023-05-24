<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show>
          <h3>로그인</h3>
        </b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="LoginError">아이디 또는 비밀번호를 확인하세요.</b-alert>
            <b-form-group label="아이디:" label-for="id">
              <b-form-input id="id" v-model="user.id" required placeholder="아이디 입력...."></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="pwd">
              <b-form-input
                type="password"
                id="pwd"
                v-model="user.pwd"
                required
                placeholder="비밀번호 입력...."
              ></b-form-input>
            </b-form-group>
            <b-button type="button" variant="primary" class="m-1" @click="confirm">로그인</b-button>
            <b-button type="button" variant="success" class="m-1" @click="movePage">회원가입</b-button>
            <b-button type="button" class="m-1" @click="findId">비밀번호 찾기</b-button>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
import { getUser, sendEmail } from "@/api/user";

const userStore = "userStore";

export default {
  name: "UserLogin",
  data() {
    return {
      LoginError: false,
      user: {
        id: null,
        pwd: null
      }
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"])
  },
  methods: {
    ...mapActions(userStore, ["userConfirm"]),
    async confirm() {
      getUser(
        this.user.id,
        ({ data }) => {
          if (data != 0) {
            const msg = "탈퇴한 회원입니다";
            alert(msg);
          }
        },
        error => {
          console.log(error);
        }
      );

      await this.userConfirm(this.user);

      if (this.isLogin) {
        this.$router.push({ name: "home" });
      } else {
        this.LoginError = true;
      }
    },

    findId() {
      var input = prompt("Id를 입력해주세요");
      if (input != null) {
        sendEmail(
          input,
          ({ data }) => {
            if (data == 1) {
              alert("이메일로 비밀번호가 전송되었습니다");
            } else {
              alert("해당 아이디로 가입된 적이 없습니다");
            }
          },
          error => {
            console.log(error);
          }
        );
      }

      alert(input);
    },

    movePage() {
      this.$router.push({ name: "join" });
    }
  }
};
</script>

<style></style>
