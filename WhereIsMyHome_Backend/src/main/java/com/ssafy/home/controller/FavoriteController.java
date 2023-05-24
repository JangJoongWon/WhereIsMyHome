package com.ssafy.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.apt.model.FavoriteDto;
import com.ssafy.home.apt.model.service.FavoriteService;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = "http://localhost:8080")
public class FavoriteController {
	
	@Autowired
	private FavoriteService serviceFavorite;
    
    @PostMapping("/regist")
    public ResponseEntity<?> registFavorite(@RequestBody FavoriteDto favoriteDto, Model model) throws Exception {
    	try {
            return new ResponseEntity<Integer>(serviceFavorite.registFavorite(favoriteDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/list/{userid}")
    public ResponseEntity<?> listFavorite(@PathVariable String userid, Model model) throws Exception {
    	try {
            return new ResponseEntity<List<FavoriteDto>>(serviceFavorite.listFavorite(userid), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/check")
    public ResponseEntity<?> checkFavorite(@RequestBody FavoriteDto favoriteDto, Model model) throws Exception {
    	try {
            return new ResponseEntity<Integer>(serviceFavorite.checkFavorite(favoriteDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}