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
import com.ssafy.home.board.model.service.BoardService;
import com.ssafy.home.user.model.UserDto;

@RestController
@Controller
@RequestMapping("/board")
public class BoardController {

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Value("${file.path}")
	private String uploadPath;

	@Value("${file.imgPath}")
	private String uploadImgPath;

	@Autowired
	private BoardService boardService;

//	@GetMapping("/write")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		
//		logger.debug("write call parameter {}", map);
//		return "board/write";
//	}

	@PostMapping("/write")
	@ResponseBody
	public ResponseEntity<?> write(@RequestBody BoardDto boardDto, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write boardDto : {}", boardDto.toString());

		// 나중에 주석풀고 해결해야함
		// UserDto userDto = (UserDto) session.getAttribute("logOK");
		// boardDto.setId(userDto.getId());

		boardDto.setId("admin"); // 얘는 주석 처리 해줘야 함
		return new ResponseEntity<Integer>(boardService.writeArticle(boardDto), HttpStatus.OK);

	}

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<?> list() throws Exception {
		ResponseEntity<List<BoardDto>> entity = new ResponseEntity<List<BoardDto>>(boardService.listArticle(),
				HttpStatus.OK);
		return entity;
	}

	
	@GetMapping("/view/{articleno}")
	@ResponseBody
	public ResponseEntity<?> view(@PathVariable(value = "articleno") int articleNo,
			@RequestParam(value = "map", required = false) Map<String, String> map, Model model) throws Exception {

		logger.debug("view articleNo : {}", articleNo);

		boardService.updateHit(articleNo);
		return new ResponseEntity<BoardDto>(boardService.getArticle(articleNo), HttpStatus.OK);

	}

//	@GetMapping("/modify/{articleno}")
//	public String modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		logger.debug("modify articleNo : {}", articleNo);
//		BoardDto boardDto = boardService.getArticle(articleNo);
//		return "board/modify";
//	}

	@PutMapping("/modify/{articleno}")
	public ResponseEntity<?> modify( BoardDto boardDto, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		
		logger.debug("modify boardDto : {}", boardDto);

		return new ResponseEntity<Integer>(boardService.modifyArticle(boardDto), HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{articleno}")
	public ResponseEntity<?> delete(@RequestParam("articleno") int articleNo, @RequestParam(value = "map",required = false) Map<String, String> map,
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
}