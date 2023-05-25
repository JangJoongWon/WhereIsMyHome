package com.ssafy.home.service;

import java.util.List;

import com.ssafy.home.model.FavoriteDto;

public interface FavoriteService {
	public int registFavorite(FavoriteDto favoriteDto);
	public List<FavoriteDto> listFavorite(String userid);
	public Integer checkFavorite(FavoriteDto favoriteDto);
	public void deleteFavorite(FavoriteDto favoriteDto);
}
