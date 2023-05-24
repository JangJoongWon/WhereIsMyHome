package com.ssafy.home.apt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.apt.model.FavoriteDto;
import com.ssafy.home.apt.model.dao.FavoriteDao;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    
	@Autowired
	private FavoriteDao favoriteDao;
	
	@Override
	public int registFavorite(FavoriteDto favoriteDto) {
		return favoriteDao.registFavorite(favoriteDto);
	}

	@Override
	public List<FavoriteDto> listFavorite(String userid) {
		return favoriteDao.listFavorite(userid);
	}

	@Override
	public Integer checkFavorite(FavoriteDto favoriteDto) {
		return favoriteDao.checkFavorite(favoriteDto);
	}

	@Override
	public void deleteFavorite(FavoriteDto favoriteDto) {
		favoriteDao.deleteFavorite(favoriteDto);
	}

}
