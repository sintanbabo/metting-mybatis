package com.sintanbabo.metting.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.sintanbabo.metting.dao.MettingDao;
import com.sintanbabo.metting.log.Log;
import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.model.MettingList;

@Service
@Transactional(readOnly = true)
public class MettingServiceImpl implements MettingService {

	private static @Log Logger LOG;
	
	@Autowired
	private MettingDao mettingDao;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Transactional
	@Override
	public void save(Metting metting) throws Exception {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("save-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			// start 날짜 검증
			SimpleDateFormat dtStart = new SimpleDateFormat("yyyyMMddHHmmss");
			dtStart.setLenient(false);
			Date dateStart = dtStart.parse(metting.getStart());
	
			// end 날짜 검증
			SimpleDateFormat dtEnd = new SimpleDateFormat("yyyyMMddHHmmss");
			dtEnd.setLenient(false);
			Date dateEnd = dtEnd.parse(metting.getEnd());
	
			// end-start 가 30분 이상 차이가 있는지 확인
			long diff = (dateEnd.getTime() - dateStart.getTime()) / (1000 * 60);
			if (diff < 30)
				throw new Exception("start 와 end 시간 차이가 30분 미만 입니다.");
	
			// start 날짜 계산 
			Calendar calStart = Calendar.getInstance();
			calStart.setTime(dateStart);
			
			// end 날짜 계산
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(dateEnd);
			
			//cycleCount 저장
			long total = metting.getCycleCount();
			
			for (int i = 0; i < total; i++) {
				if (i != 0) {
					// start 에 7일씩 더한다. (반복)
					calStart.add(Calendar.DATE, 7);
					metting.setStart(dtStart.format(calStart.getTime()));
					
					// end 에 7일씩 더한다. (반복)
					calEnd.add(Calendar.DATE, 7);
					metting.setEnd(dtEnd.format(calEnd.getTime()));
				}
				
				// cycleCount 지정
				metting.setCycleCount((long)i+1);
	
				// start end 를 기준으로 중복된 회의실이 있는지 확인
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("start", metting.getStart());
				map.put("end", metting.getEnd());
				int check = mettingDao.check(map);
				if (check > 0)
					throw new Exception("중복된 예약이 존재합니다.");
	
				mettingDao.save(metting);
			}
			
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public Metting get(HashMap<String, Object> map) throws Exception {
		return mettingDao.get(map);
	}

	@Override
	public List<MettingList> list(String date) throws Exception {
		return mettingDao.list(date);
	}

	@Override
	public List<Metting> listAll() throws Exception {
		return mettingDao.listAll();
	}

	@Transactional
	@Override
	public void update(Metting metting) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("update-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			mettingDao.update(metting);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Transactional
	@Override
	public void delete(HashMap<String, Object> map) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("delete-transaction");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(def);

		try {
			mettingDao.delete(map);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}
}
