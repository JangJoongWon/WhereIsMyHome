package com.ssafy.home.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.home.board.model.BoardDto;
import com.ssafy.home.board.model.MemoDto;
import com.ssafy.home.util.PageNavigation;

public interface BoardService {                      

	int writeArticle(BoardDto boardDto) throws Exception;
	List<BoardDto> listArticle(Map<String, String> map) throws Exception;
	List<BoardDto> listAdminArticle()throws Exception;
	
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	BoardDto getArticle(int articleNo) throws Exception;
	int updateHit(int articleNo) throws Exception;
	
	int modifyArticle(BoardDto boardDto) throws Exception;
	int deleteArticle(int articleNo, String path) throws Exception;
	Integer writeMemo(MemoDto memoDto)throws Exception;
	List<MemoDto> getMemo(int articleNo)throws Exception;
	
	
}
