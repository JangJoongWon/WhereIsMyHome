import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

import AppBoard from "../views/AppBoard";
import BoardList from "@/components/board/BoardList";
import AppHouse from "../views/AppHouse";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/board",
    name: "board",
    redirect: "board/list",
    component: AppBoard,
    children: [
      {
        path: "list",
        name: "boardlist",
        component: BoardList,
      },
    ],
  },
  {
    path: "/house",
    name: "house",
    component: AppHouse,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
