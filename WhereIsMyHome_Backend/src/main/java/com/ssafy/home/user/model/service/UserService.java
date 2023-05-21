package com.ssafy.home.user.model.service;

import org.springframework.stereotype.Service;
import com.ssafy.home.user.model.UserDto;

public interface UserService {
	
	UserDto userLogin(UserDto userDto); // 로그인
	
	int userEnroll(UserDto userDto); // 회원가입
	
	int userModify(UserDto userDto); // 회원 정보 수정
	
	int userDelete(String id); // 회원탈퇴

	String findById(String id); //회원정보 찾기

	Object getUser(String id); //탈퇴한 회원인지 확인
	
}
