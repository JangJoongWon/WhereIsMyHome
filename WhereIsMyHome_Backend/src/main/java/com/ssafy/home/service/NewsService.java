package com.ssafy.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.home.model.NewsDto;


public interface NewsService {

	void updateHit(int newsNo);
	List<NewsDto> getNews();
	void updateNews(List<NewsDto> newsList);

}
