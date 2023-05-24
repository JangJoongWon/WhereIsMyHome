import router from "@/router";
//import { login, findById, logout } from "@/api/user";
import { login } from "@/api/user";

const userStore = {
  namespaced: true,
  state: {
    isLoginError: false,
    userInfo: null,
    userid:"",
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.userInfo = userInfo;
    },
    SET_USER_ID: (state, userid) => {
      state.userid = userid;
    },
  },
  actions: {
    async userConfirm({ commit }, user) {
      await login(
        user,
        ({ data }) => {
          if (data.id) {
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            commit("SET_USER_INFO", data);
            commit("SET_USER_ID", data.id);
            alert("로그인 성공");
          } else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    
    async userLogout({ commit }) {

      commit("SET_IS_LOGIN", false);
      commit("SET_USER_INFO", null);
      sessionStorage.clear();
    },

    //회원탈퇴 
    async quit({ commit }) {

      commit("SET_IS_LOGIN", false);
      commit("SET_USER_INFO", null);
      sessionStorage.clear();
      
      router.push({ name: "login" });
    },

    //회원정보 수정
    async userModify({ commit }, user) {
      commit("SET_USER_INFO", user);
    },

  },
};

export default userStore;
