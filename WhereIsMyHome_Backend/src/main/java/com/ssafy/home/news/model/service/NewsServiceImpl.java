package com.ssafy.home.news.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.news.model.NewsDto;
import com.ssafy.home.news.model.dao.NewsDao;

@Service
public class NewsServiceImpl implements NewsService{
		
	@Autowired
	private NewsDao newsDao;
	
	@Override
	public void updateHit(int newsNo) {
		newsDao.updateHit(newsNo);
	}

	@Override
	public List<NewsDto> getNews() {
		return newsDao.getNews();
	}

	@Override
	public void updateNews(List<NewsDto> newsList) {
		newsDao.updateNews(newsList);
	}

}
