<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <b-navbar-brand>
      <router-link to="/">HomeGuys</router-link>
    </b-navbar-brand>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/favorite" style="color:#999b9c;">관심목록</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/news" style="color:#999b9c;">부동산뉴스</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/board" style="color:#999b9c;">자유게시판</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/house" style="color:#999b9c;">아파트정보</router-link>
        </li>
      </ul>
    </div>

    <!-- after login -->
    <b-navbar-nav class="ml-auto" v-if="userInfo">
      <div class="collapse navbar-collapse" id="navbarText">
        <li class="nav-item" style="text-align:center">
          <b-avatar class="avatar" variant="primary"></b-avatar>
          {{ userInfo.name }}({{ userInfo.id }})님 환영합니다.
        </li>
        <ul class="navbar-nav">
          <li class="nav-item"></li>
          <router-link :to="{ name: 'mypage' }" style="color:#999b9c;text-align: center;">내정보보기</router-link>
        </ul>
        <b-button
          variant="danger"
          class="nav-item"
          @click.prevent="onClickLogout"
          style="font-weight:bold;text-align: center; "
        >로그아웃</b-button>
      </div>
    </b-navbar-nav>

    <!-- before login -->
    <b-navbar-nav class="ml-auto" v-else>
      <router-link :to="{ name: 'register' }" class="link" style="margin-right:20px">
        <b-icon icon="person-circle"></b-icon>회원가입
      </router-link>
      <router-link :to="{ name: 'login' }" class="link">
        <b-icon icon="key"></b-icon>로그인
      </router-link>
    </b-navbar-nav>
  </nav>
</template>
<script>
import { mapState, mapGetters, mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "HeaderNavbar",
  data() {
    return {};
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"])
  },
  methods: {
    ...mapActions(userStore, ["userLogout"]),
    onClickLogout() {
      this.userLogout();
      if (this.$route.path != "/") this.$router.push({ name: "home" });
    }
  }
};
</script>

<style scoped>
#logo {
  width: 120px;
}

.link {
  text-decoration: none;
}
.navbar.navbar-expand-lg.navbar-light.bg-light {
  background-color: #e3f2fd !important;
}
.nav-item {
  margin-left: 20px;
}
.avatar {
  margin-top: 0%;
}
.ml-auto {
  padding: 5px;
}
</style>
