package com.ssafy.home.mapper;

import java.util.List;

import com.ssafy.home.model.NewsDto;

public interface NewsDao {

	void updateHit(int newsNo);

	List<NewsDto> getNews();

	void updateNews(List<NewsDto> newsList);
	
}
