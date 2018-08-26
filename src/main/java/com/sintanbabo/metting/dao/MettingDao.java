package com.sintanbabo.metting.dao;

import java.util.Date;
import java.util.List;

import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.model.MettingId;

/*
 * 회의실 예약을 위한 Dao
 */
public interface MettingDao {

	// 회의실 예약 
	MettingId save(Metting metting);
	
	// 회의실 예약 세부 확인 
	Metting get(MettingId id);
	
	// 회의실 예약 확인 
	List<Metting> list(Date date);
	
	// 회의실 예약 모두 확인 
	List<Metting> list();
	
	// 회의실 예약 변경
	void update(MettingId id, Metting metting);
	
	// 회의실 예약 취소
	void delete(MettingId id);
}
