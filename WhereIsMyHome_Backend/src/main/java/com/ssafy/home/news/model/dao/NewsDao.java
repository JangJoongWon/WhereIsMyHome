package com.ssafy.home.news.model.dao;

import java.util.List;

import com.ssafy.home.news.model.NewsDto;

public interface NewsDao {

	void updateHit(int newsNo);

	List<NewsDto> getNews();

	void updateNews(List<NewsDto> newsList);
	
}
