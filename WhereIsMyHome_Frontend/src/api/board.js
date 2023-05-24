import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(param,success, fail) {
    api.get(`/board/list`, { params: param }).then(success).catch(fail);
  }

function writeArticle(article, success, fail) {
  api.post(`/board/write`, JSON.stringify(article)).then(success).catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/board/view/${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  api.put(`/board`, JSON.stringify(article)).then(success).catch(fail);
}

function deleteArticle(articleno, success, fail) {
  api.delete(`/board/delete/${articleno}`).then(success).catch(fail);
}

function writeMemo(articleno, memo, success, fail) {
    //alert(memo);
    api.post(`/board/view/${articleno}`, JSON.stringify(memo)).then(success).catch(fail);
}

function modifyMemo(memo, success, fail) { 
  api.put(`/board/modifyMemo`, JSON.stringify(memo)).then(success).catch(fail);
}

function deleteMemo(memo_no, success, fail) { 
  api.post(`/board/deleteMemo`, JSON.stringify(memo_no)).then(success).catch(fail);
}

function updateHit(articleno, success, fail) { 
  api.get(`/board/updateHit/${articleno}`).then(success).catch(fail);
}

export  { listArticle, writeArticle, getArticle, modifyArticle, deleteArticle,writeMemo,modifyMemo, deleteMemo,updateHit };
