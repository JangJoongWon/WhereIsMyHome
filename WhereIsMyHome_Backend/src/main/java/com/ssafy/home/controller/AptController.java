package com.ssafy.home.controller;

import com.ssafy.home.apt.model.AptDealDto;
import com.ssafy.home.apt.model.AptDto;
import com.ssafy.home.apt.model.service.AptService;
import com.ssafy.home.dong.model.DongDto;
import com.ssafy.home.dong.model.service.DongService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/house")
@CrossOrigin(origins = "http://localhost:8080")
public class AptController {

    @Autowired
    private AptService service;
    
    @Autowired
    private DongService serviceDong;

    @GetMapping("/search")
    public String aptSearch() throws Exception {
        return "content/search";
    }

    @PostMapping("/search")
    @ResponseBody
    public ResponseEntity<?> aptSearch(@RequestBody DongDto dongDto, Model model) throws Exception {
        try {
        	String dongCode = serviceDong.getDongCode(dongDto);
        	
            return new ResponseEntity<List<AptDto>>(service.getAptList(dongCode), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/search/deal")
    @ResponseBody
    public ResponseEntity<?> aptDealSearch(@RequestBody String aptCode, Model model) throws Exception {
        try {
            return new ResponseEntity<List<AptDealDto>>(service.getAptDealList(aptCode), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}