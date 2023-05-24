import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import AppBoard from "../views/AppBoard";
import AppHouse from "../views/AppHouse";
import AppFavorite from "../views/AppFavorite";

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
        component: () => import("@/components/board/BoardList"),
      },

      {
        path: "write",
        name: "boardwrite",
        component: () => import("@/components/board/BoardWrite"),
      },

      {
        path: "view/:articleNo",
        name: "boardview",
        component: () => import("@/components/board/BoardView"),
      },

      {
        path: "modify/:articleNo",
        name: "boardmodify",
        component: () => import("@/components/board/BoardModify"),
      },

      {
        path: "delete/:articleNo",
        name: "boarddelete",
        component: () => import("@/components/board/BoardDelete"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/AppUser"),
    children: [
      {
        path: "join",
        name: "join",
        component: () => import("@/components/user/UserRegister"),
      },
      {
        path: "login",
        name: "login",
        component: () => import("@/components/user/UserLogin"),
      },
      {
        path: "mypage",
        name: "mypage",
        component: () => import("@/components/user/UserMyPage"),
      },
      {
        path: "modify",
        name: "modify",
        component: () => import("@/components/user/UserModify"),
      },
      {
        path: "register",
        name: "register",
        component: () => import("@/components/user/UserRegister"),
      },
    ],
  },

  {
    path: "/house",
    name: "house",
    component: AppHouse,
  },
  {
    path: "/favorite",
    name: "favorite",
    component: AppFavorite,
  },

  {
    path: "/news",
    name: "news",
    component: () => import("@/components/news/NewsList"),
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
