package com.ssafy.home.apt.model.service;

import java.util.List;

import com.ssafy.home.apt.model.FavoriteDto;

public interface FavoriteService {
	public int registFavorite(FavoriteDto favoriteDto);
	public List<FavoriteDto> listFavorite(String userid);
	public Integer checkFavorite(FavoriteDto favoriteDto);
}
