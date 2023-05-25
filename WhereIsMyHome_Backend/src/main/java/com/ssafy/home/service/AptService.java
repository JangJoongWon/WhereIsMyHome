package com.ssafy.home.service;

import com.ssafy.home.model.AptDealDto;
import com.ssafy.home.model.AptDto;
import com.ssafy.home.model.DongDto;
import com.ssafy.home.model.FavoriteDto;

import java.util.List;

public interface AptService {
    public List<AptDto> getAptList(String dongCode);
    public List<AptDealDto> getAptDealList(String aptCode);
}
