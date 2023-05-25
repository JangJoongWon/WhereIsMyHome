package com.ssafy.home.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.model.BoardDto;
import com.ssafy.home.model.MemoDto;

@Mapper
public interface BoardDao {
	int writeArticle(BoardDto boardDto) throws SQLException;
	
	int writeMemo(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle(Map<String, Object> map) throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	int updateHit(int articleNo) throws SQLException;

	int modifyArticle(BoardDto boardDto) throws SQLException;

	int deleteArticle(int articleNo) throws SQLException;

	int writeMemo(MemoDto memoDto)throws Exception;

	List<MemoDto> getMemo(int articleNo)throws Exception;

	List<BoardDto> listAdminArticle()throws Exception;

	Integer UpdateMemo(MemoDto memoDto)throws Exception;

	int DeleteMemo(int memo_no)throws Exception;
}
