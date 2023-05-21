package com.ssafy.home.board.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.board.model.BoardDto;
import com.ssafy.home.board.model.FileInfoDto;
import com.ssafy.home.board.model.MemoDto;

@Mapper
public interface BoardDao {
	int writeArticle(BoardDto boardDto) throws SQLException;
	
	int registerFile(BoardDto boardDto) throws Exception;
	
	int writeMemo(BoardDto boardDto) throws Exception;

	List<BoardDto> listArticle() throws SQLException;

	int getTotalArticleCount(Map<String, Object> param) throws SQLException;

	BoardDto getArticle(int articleNo) throws SQLException;

	int updateHit(int articleNo) throws SQLException;

	int modifyArticle(BoardDto boardDto) throws SQLException;

	int deleteFile(int articleNo) throws Exception;

	int deleteArticle(int articleNo) throws SQLException;

	List<FileInfoDto> fileInfoList(int articleNo) throws Exception;

	int writeMemo(MemoDto memoDto)throws Exception;

	List<MemoDto> getMemo(int articleNo)throws Exception;
}
