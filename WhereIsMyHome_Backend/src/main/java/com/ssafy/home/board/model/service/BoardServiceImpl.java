package com.ssafy.home.board.model.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.home.board.model.BoardDto;
import com.ssafy.home.board.model.FileInfoDto;
import com.ssafy.home.board.model.MemoDto;
import com.ssafy.home.board.model.dao.BoardDao;
import com.ssafy.home.util.PageNavigation;
import com.ssafy.home.util.SizeConstant;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	@Transactional
	public int writeArticle(BoardDto boardDto) throws Exception {
		System.out.println("글입력 전 dto : " + boardDto);
		boardDao.writeArticle(boardDto);
		System.out.println("글입력 후 dto : " + boardDto);
		List<FileInfoDto> fileInfos = boardDto.getFileInfos();
		if (fileInfos != null && !fileInfos.isEmpty()) {
			return boardDao.registerFile(boardDto);
		}else return 0;
	}

	@Override
	public List<BoardDto> listArticle() throws Exception {
//		Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key");
//		if("id".equals(key))
//			key = "b.id";
//		param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int pgNo = Integer.parseInt((map.get("pgno") == null||map.get("pgno") == "") ? "1" : map.get("pgno"));
//		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
//		param.put("start", start);
//		param.put("listsize", SizeConstant.LIST_SIZE);

		return boardDao.listArticle();
	}
	
	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		//int currentPage = Integer.parseInt(map.get("pgno"));
		int currentPage = 0;

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
		// TODO : BoardDaoImpl의 deleteArticle 호출
		List<FileInfoDto> fileList = boardDao.fileInfoList(articleNo);
		boardDao.deleteFile(articleNo);
		boardDao.deleteArticle(articleNo);
		for(FileInfoDto fileInfoDto : fileList) {
			File file = new File(path + File.separator + fileInfoDto.getSaveFolder() + File.separator + fileInfoDto.getSaveFile());
			file.delete();
		}
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
}
