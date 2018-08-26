package com.sintanbabo.metting.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sintanbabo.metting.mapper.MettingMapper;
import com.sintanbabo.metting.model.Metting;

@Repository
public class MettingDaoImpl implements MettingDao {

	@Autowired
	private MettingMapper mettingMapper;

	@Override
	public int save(Metting metting) {
		return mettingMapper.save(metting);
	}

	@Override
	public Metting get(HashMap<String,Object> map) {
		return mettingMapper.get(map);
	}

	@Override
	public List<Metting> list(Date date) {
		List<Metting> result = new ArrayList<Metting>();
		result = mettingMapper.list(date);
		return result;
	}

	@Override
	public List<Metting> listAll() {
		List<Metting> result = new ArrayList<Metting>();
		result = mettingMapper.listAll();
		return result;
	}

	@Override
	public void update(Metting metting) {
		mettingMapper.update(metting);
	}

	@Override
	public void delete(HashMap<String,Object> map) {
		mettingMapper.delete(map);
	}	
}
