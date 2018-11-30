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
	public void updateAllotHap(Integer staffId,Integer handleId,Integer chanceId) {
		hapDao.updateAllotHap(staffId,handleId, chanceId);
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
	public Integer addHap(Hap hap) {
		// TODO Auto-generated method stub
		return hapDao.addHap(hap);
	}

}
