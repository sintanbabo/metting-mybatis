package com.sintanbabo.metting.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sintanbabo.metting.dao.MettingDao;
import com.sintanbabo.metting.model.Metting;

@Service
@Transactional(readOnly=true)
public class MettingServiceImpl implements MettingService {

	@Autowired
	private MettingDao mettingDao;
	
	@Transactional
	@Override
	public int save(Metting metting) {
		return mettingDao.save(metting);
	}

	@Override
	public Metting get(HashMap<String,Object> map) {
		return mettingDao.get(map);
	}

	@Override
	public List<Metting> list(Date date) {
		return mettingDao.list(date);
	}

	@Override
	public List<Metting> listAll() {
		return mettingDao.listAll();
	}

	@Transactional
	@Override
	public void update(Metting metting) {
		mettingDao.update(metting);
	}

	@Transactional
	@Override
	public void delete(HashMap<String,Object> map) {
		mettingDao.delete(map);
	}
}
