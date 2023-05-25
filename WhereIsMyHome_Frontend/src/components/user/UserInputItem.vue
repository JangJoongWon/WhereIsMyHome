<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group id="id-group" label="아이디:" label-for="id" description="아이디를 입력하세요.">
          <span class="badge badge-danger mt-1" v-if="!available">동일한 아이디가 존재합니다</span>
          <span class="badge mt-1" v-if="available && user.id">사용가능한 아이디입니다</span>
          <b-form-input
            id="id"
            type="text"
            required
            v-model="user.id"
            :placeholder="userid"
            @keyup="checkVaild"
            v-if="userInfo"
          ></b-form-input>

          <b-form-input
            id="id"
            v-model="user.id"
            type="text"
            required
            placeholder="아이디를 입력하세요"
            @keyup="checkVaild"
            v-else
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="password-group"
          label="비밀번호:"
          label-for="password"
          description="비밀번호를 입력하세요."
        >
          <b-form-input id="pwd" v-model="user.pwd" type="text" required placeholder="비밀번호 입력..."></b-form-input>
        </b-form-group>

        <b-form-group id="name-group" label="이름:" label-for="subject" description="이름을 입력하세요.">
          <b-form-input
            id="name"
            v-model="user.name"
            type="text"
            :placeholder="userInfo.name"
            v-if="userInfo"
          ></b-form-input>
          <b-form-input id="name" v-model="user.name" type="text" placeholder="이름 입력" v-else></b-form-input>
        </b-form-group>

        <b-form-group id="address-group" label="이메일:" label-for="address" description="이메일을 입력하세요.">
          <b-form-input
            id="content"
            v-model="user.email"
            type="text"
            :placeholder="userInfo.email"
            v-if="userInfo"
          ></b-form-input>
          <b-form-input
            id="content"
            v-model="user.email"
            type="text"
            placeholder="이메일을 입력하세요"
            v-else
          ></b-form-input>
        </b-form-group>
        <b-form-group id="phone-group" label="전화번호:" label-for="content" description="전화번호를 입력하세요.">
          <b-form-input
            id="content"
            v-model="user.phone"
            type="text"
            :placeholder="userInfo.phone"
            v-if="userInfo"
          ></b-form-input>
          <b-form-input id="content" v-model="user.phone" type="text" placeholder="전화번호 입력" v-else></b-form-input>
        </b-form-group>

        <b-button variant="primary" class="mr-1" @click="register" v-if="!userInfo">회원가입</b-button>
        <b-button variant="primary" class="mr-1" @click="modify" v-else>정보수정</b-button>
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { modifyUser, registerUser, findById } from "@/api/user";
import { mapState, mapActions } from "vuex";
const userStore = "userStore";

export default {
  name: "UserInputItem",
  data() {
    return {
      user: {
        id: "",
        pwd: "",
        name: "",
        email: "",
        phone: ""
      },
      isUserid: false,
      available: true
    };
  },
  props: {
    type: { type: String }
  },

  created() {
    this.id = this.userid;
  },

  computed: {
    ...mapState(userStore, ["userInfo", "userid"])
  },

  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.user.id &&
        ((msg = "아이디를 입력해주세요"), (err = false), this.$refs.id.focus());
      err &&
        !this.user.pwd &&
        ((msg = "비밀번호를 입력해주세요"),
        (err = false),
        this.$refs.pwd.focus());
      err &&
        !this.user.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.name.focus());
      err &&
        !this.user.email &&
        ((msg = "이메일을 입력해주세요"),
        (err = false),
        this.$refs.name.focus());
      err &&
        !this.user.phone &&
        ((msg = "전화번호를 입력해주세요"),
        (err = false),
        this.$refs.name.focus());

      if (!err) alert(msg);
      else this.type === "modify" ? this.modifyUser() : this.registerUser();
    },
    onReset(event) {
      event.preventDefault();
      this.user.id = "";
      this.user.pwd = "";
      this.user.name = "";
      this.user.email = "";
      this.user.phone = "";
      this.moveList();
    },

    ...mapActions(userStore, ["userModify"]),
    modify() {
      let user = {
        id: this.userInfo.id,
        pwd: this.user.pwd,
        name: this.user.name,
        email: this.user.email,
        phone: this.user.phone
      };

      user.id = this.userid;

      modifyUser(
        user,
        ({ data }) => {
          let msg = "수정이 실패했습니다.";
          if (data != null) {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          this.userModify(this.user);
          this.moveList();
        },
        error => {
          console.log(error);
        }
      );
    },

    register() {
      let user = {
        id: this.user.id,
        pwd: this.user.pwd,
        name: this.user.name,
        email: this.user.email,
        phone: this.user.phone
      };

      registerUser(
        user,
        ({ data }) => {
          let msg = "회원가입이 실패했습니다.";
          if (data != null) {
            msg = "회원가입이 완료되었습니다.";
          }
          alert(msg);
          this.moveList();
        },
        error => {
          console.log(error);
        }
      );
    },

    //유효성
    checkVaild() {
      if (this.type != "modify") {
        findById(
          this.user.id,
          ({ data }) => {
            if (data != "NO") {
              this.available = false;
            } else {
              this.available = true;
            }
          },
          error => {
            console.log(error);
          }
        );
      }
    },

    moveList() {
      this.$router.push({ name: "home" });
    }
  }
};
</script>

<style></style>
