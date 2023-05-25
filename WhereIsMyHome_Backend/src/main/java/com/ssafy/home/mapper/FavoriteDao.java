package com.ssafy.home.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.model.FavoriteDto;

@Mapper
public interface FavoriteDao {
	int registFavorite(FavoriteDto favoriteDto);
	List<FavoriteDto> listFavorite(String userid);
	Integer checkFavorite(FavoriteDto favoriteDto);
	void deleteFavorite(FavoriteDto favoriteDto);
}
