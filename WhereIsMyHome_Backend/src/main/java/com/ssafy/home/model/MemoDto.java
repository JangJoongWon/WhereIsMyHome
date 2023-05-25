package com.ssafy.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemoDto {
	private int memo_no;
	private String id;
	private String comment;
	private String memo_time;
	private int article_no;
}
