import { apiInstance } from "./index.js";

const api = apiInstance();

async function listNews(success, fail) {
    await api.get(`/news/list`).then(success).catch(fail);
}

async function updateNews(success, fail) {
    await api.post(`/news/`).then(success).catch(fail);
}

export { listNews, updateNews}