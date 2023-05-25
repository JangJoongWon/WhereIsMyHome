package com.ssafy.home.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.home.model.UserDto;

@Mapper
public interface UserDao {

	UserDto userLogin(UserDto userDto);
	
	int userEnroll(UserDto userDto);

	int userModify(UserDto userDto);

	int userDelete(String id);

	String findById(String id);

	Object getUser(String id);

	String getEmail(String id);
}
