package com.sintanbabo.metting.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sintanbabo.metting.dao.MettingDao;
import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.model.MettingId;

@Service
@Transactional(readOnly=true)
public class MettingServiceImpl implements MettingService {

	@Autowired
	private MettingDao mettingDao;
	
	@Transactional
	@Override
	public MettingId save(Metting metting) {
		return mettingDao.save(metting);
	}

	@Override
	public Metting get(MettingId id) {
		return mettingDao.get(id);
	}

	@Override
	public List<Metting> list(Date date) {
		return mettingDao.list(date);
	}

	@Override
	public List<Metting> list() {
		return mettingDao.list();
	}

	@Transactional
	@Override
	public void update(MettingId id, Metting metting) {
		mettingDao.update(id, metting);
	}

	@Transactional
	@Override
	public void delete(MettingId id) {
		mettingDao.delete(id);
	}
}
