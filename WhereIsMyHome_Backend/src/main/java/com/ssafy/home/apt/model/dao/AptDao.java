package com.ssafy.home.apt.model.dao;

import com.ssafy.home.apt.model.AptDealDto;
import com.ssafy.home.apt.model.AptDto;
import com.ssafy.home.dong.model.DongDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AptDao {
    List<AptDto> getAptList(String dongCode);
	List<AptDealDto> getAptDealList(String aptCode);
}
