package com.znsd.client.service.impl;

import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.znsd.client.bean.Hap;
import com.znsd.client.dao.HapDao;
import com.znsd.client.service.HapService;


@WebServiceClient

@Service
public class HapServiceImpl implements HapService {
	
	
	@Autowired
	private HapDao hapDao;
	
	@Override
	public List<Map<String, Object>> selectHapByPage(String chanceName) {
		return hapDao.selectHapByPage(chanceName);
	}

	@Override
	public void updateAllotHap(Integer staffId, Integer chanceId) {
		// TODO Auto-generated method stub
		hapDao.updateAllotHap(staffId, chanceId);
	}

	@Override
	public Map<String,Object> getHapData(Integer chanceId) {
		// TODO Auto-generated method stub
		return hapDao.getHapData(chanceId);
	}

	@Override
	public void updateHap(Hap hap) {
		// TODO Auto-generated method stub
		hapDao.updateHap(hap);
	}

	@Override
	public void addHap(Hap hap) {
		// TODO Auto-generated method stub
		hapDao.addHap(hap);
	}

}
