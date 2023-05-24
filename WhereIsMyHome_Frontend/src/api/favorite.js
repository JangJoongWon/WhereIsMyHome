import { apiInstance } from "./index.js";

const api = apiInstance();

function registFavorite(params, success, fail) {
  api
    .post(`/favorite/regist`, {
      sidoName: params.sidoName,
      gugunName: params.gugunName,
      dongName: params.dongName,
      aptCode: params.aptCode,
      userid: params.userid,
      apartmentName: params.apartmentName,
    })
    .then(success)
    .catch(fail);
}

function getFavorites(userid, success, fail) {
  api.get(`/favorite/list/${userid}`).then(success).catch(fail);
}

function checkFavorites(params, success, fail) {
  api
    .post(`/favorite/check`, {
      aptCode: params.aptCode,
      userid: params.userid,
    })
    .then(success)
    .catch(fail);
}

function deleteFavorites(params, success, fail) {
  api
    .delete(`/favorite/delete`, {
      params: {
        aptCode: params.aptCode,
        userid: params.userid,
      },
    })
    .then(success)
    .catch(fail);
}

export { registFavorite, getFavorites, checkFavorites, deleteFavorites };
