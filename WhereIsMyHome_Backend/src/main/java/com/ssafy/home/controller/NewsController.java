package com.ssafy.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.model.NewsDto;
import com.ssafy.home.service.NewsService;
import com.ssafy.home.util.NaverSearch;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/news")
@Api(value = "News 컨트롤러 API")
public class NewsController {
	
	private final String SUCCESS = "success";
	
	private final String FAIL = "fail";
	
	private final Logger logger = LoggerFactory.getLogger(NewsController.class);
	
	@Autowired
	private NewsService newsService;

	public NewsController(NewsService newsService) {
		super();
		this.newsService = newsService;
	}
	
	// list
	@ApiOperation(value = "모든 News 반환")
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> getNews(){
		logger.info("NewsList 모두 반환");
		List<NewsDto> newsList;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			newsList = newsService.getNews();
			resultMap.put("message", "success");
			resultMap.put("newsList", newsList);
			return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
		}catch(Exception e) {
			resultMap.put("message", "fail");
			return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.NO_CONTENT);
		}
		 
	}
	
	@Scheduled(cron="0 0 9 * * *") 
	@PostMapping("/")
	public ResponseEntity<String> updateNews(){
		logger.info("뉴스 추가");
		List<NewsDto> newsList = new ArrayList<>();
		JSONObject news = null;
		NewsDto newsDto = null;
		try {
			JSONArray json = NaverSearch.jsonSave();
			for(int i = 0; i < json.length(); i++) {
				newsDto = new NewsDto();
				news = json.getJSONObject(i);
				newsDto.setTitle(news.get("title").toString());
				newsDto.setContext(news.get("description").toString());
				newsDto.setLink(news.get("link").toString());
				newsDto.setPostDate(news.get("pDate").toString());
				newsList.add(newsDto);
			}
			newsService.updateNews(newsList);
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}catch(Exception e) {
			e.hashCode();
			return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
		}
	}
}