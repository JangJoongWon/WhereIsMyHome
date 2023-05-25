package com.ssafy.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ssafy.home.mapper.UserDao;
import com.ssafy.home.model.UserDto;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@Service
@Primary
public class UserServiceImpl implements UserService {
	
	
	private final UserDao userDao;
	
	private final JavaMailSender javaMailSender;

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

	@Override
	public String getEmail(String id) {
		return userDao.getEmail(id);
	}

	@Override
	public void mailSend(String id, String email, String pwd) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject(id+"님의 비밀번호 확인 메일입니다");
		simpleMailMessage.setText(id+"님의 비밀번호는 "+pwd+"입니다");

		javaMailSender.send(simpleMailMessage);
	}

}
