import { sidoList, gugunList, dongList, houseList, houseDealList } from "@/api/house.js";

const houseStore = {
  namespaced: true,
  state: {
    sido: "",
    gugun: "",
    dong: "",
    apartmentName: "",
    sidos: [{ value: null, text: "시/도를 선택하세요" }],
    guguns: [{ value: null, text: "구/군을 선택하세요" }],
    dongs: [{ value: null, text: "동을 선택하세요" }],
    houses: [],
    houseDeals: [],
  },
  getters: {},
  mutations: {
    CLEAR_SIDO(state) {
      state.sido = "";
    },
    CLEAR_GUGUN(state) {
      state.gugun = "";
    },
    CLEAR_DONG(state) {
      state.dong = "";
    },
    CLEAR_APTNAME(state) {
      state.apartmentName = "";
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "시/도를 선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "구/군을 선택하세요" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "동을 선택하세요" }];
    },
    CLEAR_HOUSE_LIST(state) {
      state.houses = [];
    },
    CLEAR_HOUSE_DEAL(state) {
      state.houseDeals = [];
    },
    SET_SIDO(state, sido) {
      state.sido = sido;
    },
    SET_GUGUN(state, gugun) {
      state.gugun = gugun;
    },
    SET_DONG(state, dong) {
      state.dong = dong;
    },
    SET_APTNAME(state, apartmentName) {
      state.apartmentName = apartmentName;
    },
    SET_SIDO_LIST(state, sidos) {
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido, text: sido });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun, text: gugun });
      });
    },
    SET_DONG_LIST(state, dongs) {
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong, text: dong });
      });
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_HOUSE_DEAL(state, houseDeals) {
      state.houseDeals = houseDeals;
    },
  },
  actions: {
    getSidos: ({ commit }) => {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getGuguns: ({ commit }, sido) => {
      gugunList(
        sido,
        ({ data }) => {
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getDongs: ({ commit }, gugun) => {
      dongList(
        gugun,
        ({ data }) => {
          commit("SET_DONG_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseList: ({ commit }, params) => {
      houseList(
        params,
        ({ data }) => {
          commit("SET_HOUSE_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getHouseDealList: ({ commit }, aptCode) => {
      houseDealList(
        aptCode,
        ({ data }) => {
          commit("SET_HOUSE_DEAL", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default houseStore;
