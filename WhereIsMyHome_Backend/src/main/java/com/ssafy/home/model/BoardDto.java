package com.ssafy.home.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private int articleNo;
	private String id;
	private String name;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	
	
	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", id=" + id + ", name=" + name + ", subject=" + subject
				+ ", content=" + content + ", hit=" + hit + ", registerTime=" + registerTime + "]";
	}
	
}
