package com.ssafy.home.service;

import com.ssafy.home.mapper.AptDao;
import com.ssafy.home.model.AptDealDto;
import com.ssafy.home.model.AptDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Primary
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
