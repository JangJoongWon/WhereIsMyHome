package com.ssafy.home.controller;

import com.ssafy.home.model.UserDto;
import com.ssafy.home.service.UserService;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8080")
@Api("사용자 컨트롤러  API V1")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody UserDto userDto) throws Exception {
		
		UserDto userInfo =  userService.userLogin(userDto);
		//ResponseEntity<UserDto> entity = new ResponseEntity<UserDto>(userService.userLogin(userDto), HttpStatus.OK);
		
		if(userInfo == null)return new ResponseEntity<UserDto>(userInfo, HttpStatus.NO_CONTENT);
		else return new ResponseEntity<UserDto>(userInfo, HttpStatus.OK);

	}


	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<?> register(@RequestBody UserDto userDto) throws Exception{
		try {
			return new ResponseEntity<Integer>(userService.userEnroll(userDto), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/findById")
	public ResponseEntity<?> findById(@RequestBody String id) throws Exception {
		String check = userService.findById(id);
		if(check!=null) return new ResponseEntity<String>(check, HttpStatus.OK);
		return new ResponseEntity<String>("NO", HttpStatus.OK);
	}
	
	@PostMapping("/getUser")
	public ResponseEntity<?> getUser(@RequestBody String id) throws Exception {
		
		//0이거나 null이면 정상회원
		if(userService.getUser(id)==null||(int)userService.getUser(id)==0) {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
		//1이면 탈퇴환 회원
		else return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}
	

	@PutMapping("/modify")
	public ResponseEntity<?> modify(@RequestBody UserDto userDto) throws Exception{
		try {
			userService.userModify(userDto);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody String id) throws Exception{
		try {
			return new ResponseEntity<Integer>(userService.userDelete(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody String id)throws Exception{
	    String email = userService.getEmail(id);
	    String pwd = userService.findById(id);
	    
	    userService.mailSend(id, email,pwd);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);

	}
	
}
