package com.ssafy.home.user.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.home.user.model.UserDto;

@Mapper
public interface UserDao {

	UserDto userLogin(UserDto userDto);
	
	int userEnroll(UserDto userDto);

	int userModify(UserDto userDto);

	int userDelete(String id);
}
