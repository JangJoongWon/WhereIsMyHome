import { apiInstance } from "./index.js";

const api = apiInstance();

async function listNews(success, fail) {
    console.log("뉴스 가져오기");
    await api.get(`/news/list`).then(success).catch(fail);
}

async function updateNews(success, fail) {
    console.log("뉴스 추가");
    await api.post(`/news/`).then(success).catch(fail);
}

export { listNews, updateNews}