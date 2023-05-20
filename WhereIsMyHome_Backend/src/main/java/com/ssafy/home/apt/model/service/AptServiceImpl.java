package com.ssafy.home.apt.model.service;

import com.ssafy.home.apt.model.AptDealDto;
import com.ssafy.home.apt.model.AptDto;
import com.ssafy.home.apt.model.dao.AptDao;
import com.ssafy.home.dong.model.DongDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AptServiceImpl implements AptService {

    @Autowired
    private AptDao aptDao;

    @Override
    public List<AptDto> getAptList(String dongCode) {
        return aptDao.getAptList(dongCode);
    }

	@Override
	public List<AptDealDto> getAptDealList(String aptCode) {
		return aptDao.getAptDealList(aptCode);
	}
    
}
