package com.ssafy.home.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.home.model.AptDealDto;
import com.ssafy.home.model.AptDto;

import java.util.List;

@Mapper
public interface AptDao {
    List<AptDto> getAptList(String dongCode);
	List<AptDealDto> getAptDealList(String aptCode);
}
