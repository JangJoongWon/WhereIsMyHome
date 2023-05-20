package com.ssafy.home.dong.model.service;

import java.util.List;

import com.ssafy.home.dong.model.DongDto;

public interface DongService {
    public List<String> getSido();
    public List<String> getGugun(String sidoName);
    public List<String> getDong(String gugunName);
    public String getDongCode(DongDto dongDto);
}
