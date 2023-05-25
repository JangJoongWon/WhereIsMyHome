package com.ssafy.home.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.home.mapper.BoardDao;
import com.ssafy.home.model.BoardDto;
import com.ssafy.home.model.MemoDto;
import com.ssafy.home.util.PageNavigation;
import com.ssafy.home.util.SizeConstant;

@Service @Primary
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
 
	@Override
	@Transactional
	public int writeArticle(BoardDto boardDto) throws Exception {;
		boardDao.writeArticle(boardDto); 
		return 0;
	}

	@Override
	public List<BoardDto> listArticle(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("id".equals(key))
			key = "b.id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt((map.get("pgno") == null||map.get("pgno") == "") ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);

		return boardDao.listArticle(param);
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("id".equals(key))
			key = "id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = boardDao.getTotalArticleCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();

		return pageNavigation;
	}

	@Override
	public BoardDto getArticle(int articleNo) throws Exception {
		return boardDao.getArticle(articleNo);
	}

	@Override
	@Transactional
	public int updateHit(int articleNo) throws Exception {
		return boardDao.updateHit(articleNo);
	}

	@Override
	@Transactional
	public int modifyArticle(BoardDto boardDto) throws Exception {
		// TODO : BoardDaoImpl의 modifyArticle 호출
		return boardDao.modifyArticle(boardDto);
	}

	@Override
	@Transactional
	public int deleteArticle(int articleNo, String path) throws Exception {
		boardDao.deleteArticle(articleNo);
		return 0;
	}
	
	@Override
	@Transactional
	public Integer writeMemo(MemoDto memoDto)throws Exception {
		return boardDao.writeMemo(memoDto);
	}

	@Override
	public List<MemoDto> getMemo(int articleNo) throws Exception {
		return boardDao.getMemo(articleNo);
	}

	@Override
	public List<BoardDto> listAdminArticle() throws Exception {
		return boardDao.listAdminArticle();
	}

	@Override
	public Integer UpdateMemo(MemoDto memoDto) throws Exception {
		return boardDao.UpdateMemo(memoDto);
	}

	@Override
	public int DeleteMemo(int memo_no) throws Exception {
		return boardDao.DeleteMemo(memo_no);
	}
}
