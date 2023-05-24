package com.ssafy.home.apt.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.apt.model.FavoriteDto;

@Mapper
public interface FavoriteDao {
	int registFavorite(FavoriteDto favoriteDto);
	List<FavoriteDto> listFavorite(String userid);
	Integer checkFavorite(FavoriteDto favoriteDto);
	void deleteFavorite(FavoriteDto favoriteDto);
}
