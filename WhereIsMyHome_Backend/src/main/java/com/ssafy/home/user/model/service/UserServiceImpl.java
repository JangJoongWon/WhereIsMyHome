package com.ssafy.home.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.user.model.UserDto;
import com.ssafy.home.user.model.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	
	@Override
	public UserDto userLogin(UserDto userDto) {
		return userDao.userLogin(userDto);
	}


	@Override
	public int userEnroll(UserDto userDto) {
		return userDao.userEnroll(userDto);
	}


	@Override
	public int userModify(UserDto userDto) {
		return userDao.userModify(userDto);
	}


	@Override
	public int userDelete(String id) {
		return userDao.userDelete(id);
	}


	@Override
	public String findById(String id) {
		return userDao.findById(id);
	}


	@Override
	public Object getUser(String id) {
		return userDao.getUser(id);
	}
	
}
