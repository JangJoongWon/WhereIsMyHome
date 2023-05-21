import { houseInstance } from "./index.js";

const house = houseInstance();

function sidoList(success, fail) {
  house.get(`/dong/sido`).then(success).catch(fail);
}

function gugunList(param, success, fail) {
  house.get(`/dong/gugun?sido=${param}`).then(success).catch(fail);
}

function dongList(param, success, fail) {
  house.get(`/dong/dong?gugun=${param}`).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house
    .post(`/house/search`, {
      dongName: params.dongName,
      gugunName: params.gugunName,
      sidoName: params.sidoName,
    })
    .then(success)
    .catch(fail);
}

function houseDealList(aptCode, success, fail) {
  house.post(`/house/search/deal`, aptCode).then(success).catch(fail);
}

export { sidoList, gugunList, dongList, houseList, houseDealList };
