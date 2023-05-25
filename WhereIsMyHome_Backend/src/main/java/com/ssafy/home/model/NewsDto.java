package com.ssafy.home.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDto {
	String title;
	String context;
	String link;
	String postDate;
	
	@Override
	public String toString() {
		return "NewsDto [title=" + title + ", context=" + context + ", link=" + link + ", postDate=" + postDate + "]";
	}
	
}
