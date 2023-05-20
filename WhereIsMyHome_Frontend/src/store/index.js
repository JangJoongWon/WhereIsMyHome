import Vue from "vue";
import Vuex from "vuex";

import houseStore from "@/store/modules/houseStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    houseStore,
  },
});
