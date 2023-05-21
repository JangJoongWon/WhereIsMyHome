package com.ssafy.home.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.home.board.model.BoardDto;
import com.ssafy.home.board.model.FileInfoDto;
import com.ssafy.home.board.model.MemoDto;
import com.ssafy.home.board.model.service.BoardService;
import com.ssafy.home.user.model.UserDto;

import io.swagger.annotations.Api;

@RestController
@Controller
@RequestMapping("/board")
@Api("사용자 컨트롤러  API V1")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Value("${file.path}")
	private String uploadPath;

	@Value("${file.imgPath}")
	private String uploadImgPath;

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/write")
	@ResponseBody
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write boardDto : {}", boardDto.toString());
		
		return new ResponseEntity<Integer>(boardService.writeArticle(boardDto), HttpStatus.OK);

	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<?> list() throws Exception {
		ResponseEntity<List<BoardDto>> entity = new ResponseEntity<List<BoardDto>>(boardService.listArticle(),
				HttpStatus.OK);
		return entity;
	}


//	@GetMapping("/view/{articleno}")
//	@ResponseBody
//	public ResponseEntity<?> view(@PathVariable(value = "articleno") int articleNo) throws Exception {
//
//		logger.debug("view articleNo : {}", articleNo);
//		
//		boardService.updateHit(articleNo);
//  
//    		BoardDto boardDto = boardService.getArticle(articleNo);
//            return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
//            
//       
//	}
	
	
	@GetMapping("/view/{articleno}")
	@ResponseBody
	public ResponseEntity<?> view(@PathVariable(value = "articleno") int articleNo) throws Exception {

		logger.debug("view articleNo : {}", articleNo);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		boardService.updateHit(articleNo);
        try {
            resultMap.put("message", "success");
            List<MemoDto>memoList = boardService.getMemo(articleNo);
    		BoardDto boardDto = boardService.getArticle(articleNo);	
    		//System.out.println(memoList.size());
    		resultMap.put("article",boardDto);
    		resultMap.put("memos",memoList);
            return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
            
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("message", "fail");
            return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.NO_CONTENT);
        }
	}
	

	@PutMapping
	public ResponseEntity<?> modify(@RequestBody BoardDto boardDto,  @RequestParam(value = "map",required = false) Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		
		logger.debug("modify boardDto : {}", boardDto);

		return new ResponseEntity<Integer>(boardService.modifyArticle(boardDto), HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{articleno}")
	public ResponseEntity<?> delete(@PathVariable(value = "articleno") int articleNo, @RequestParam(value = "map",required = false) Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("delete articleNo : {}", articleNo);
		
		return new ResponseEntity<Integer>(boardService.deleteArticle(articleNo, uploadPath), HttpStatus.OK);
	}

	
//	@GetMapping("/download")
//	public ModelAndView downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
//			@RequestParam("sfile") String sfile) {
//		Map<String, Object> fileInfo = new HashMap<String, Object>();
//		fileInfo.put("sfolder", sfolder);
//		fileInfo.put("ofile", ofile);
//		fileInfo.put("sfile", sfile);
//		return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
//	}
	
	@GetMapping("/download")
	public ResponseEntity<?> downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
			@RequestParam("sfile") String sfile) {
		Map<String, Object> fileInfo = new HashMap<String, Object>();
		fileInfo.put("sfolder", sfolder);
		fileInfo.put("ofile", ofile);
		fileInfo.put("sfile", sfile);
		//return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
		return new ResponseEntity<Map>(fileInfo, HttpStatus.OK);
	}
	
	@PostMapping("/view/{articleno}")
	public ResponseEntity<?> writeMemo(@PathVariable(value = "articleno")int articleNo, @RequestBody MemoDto memoDto) throws Exception{
		memoDto.setArticle_no(articleNo);
		return new ResponseEntity<Integer>(boardService.writeMemo(memoDto), HttpStatus.OK);
	}
}