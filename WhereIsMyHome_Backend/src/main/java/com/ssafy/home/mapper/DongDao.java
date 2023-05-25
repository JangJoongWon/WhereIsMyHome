package com.ssafy.home.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.model.DongDto;

import java.util.List;

@Mapper
public interface DongDao {

    List<String> getSido();
    List<String> getGugun(String sidoName);
    List<String> getDong(String gugunName);
	String getDongCode(DongDto dongDto);
}
