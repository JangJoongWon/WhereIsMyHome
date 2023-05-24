import { apiInstance } from "./index.js";

const api = apiInstance();

//로그인
async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

//이메일로 비밀번호 찾기 
async function findById(id, success, fail) {
  await api.post(`/user/findById`, JSON.stringify(id)).then(success).catch(fail);
}

//이메일로 비밀번호 찾기 
async function sendEmail(id, success, fail) {
  await api.post(`/user/sendEmail`, JSON.stringify(id)).then(success).catch(fail);
}

//회원 탈퇴
async function quitUser(id, success, fail) { 
  await api.put(`/user/delete`, JSON.stringify(id)).then(success).catch(fail);
}

//회원 정보 수정 
async function modifyUser(user, success, fail) { 
  await api.put(`/user/modify`,JSON.stringify(user)).then(success).catch(fail);
}


//회원가입 
async function registerUser(user, success, fail) { 
  await api.post(`/user/register`,JSON.stringify(user)).then(success).catch(fail);
}

//회원 정보 찾기
async function getUser(id, success, fail) { 
  await api.post(`/user/getUser`, JSON.stringify(id)).then(success).catch(fail);
}

export { login, findById, quitUser, modifyUser, registerUser, getUser,sendEmail };
  
