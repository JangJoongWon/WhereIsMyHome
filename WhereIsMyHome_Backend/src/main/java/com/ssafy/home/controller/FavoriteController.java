package com.ssafy.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.model.FavoriteDto;
import com.ssafy.home.service.FavoriteService;

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
    
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteFavorite(@RequestParam String aptCode, @RequestParam String userid, Model model) throws Exception {
    	try {
    		FavoriteDto favoriteDto = new FavoriteDto();
    		favoriteDto.setAptCode(aptCode);
    		favoriteDto.setUserid(userid);
    		serviceFavorite.deleteFavorite(favoriteDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("서버 오류", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
