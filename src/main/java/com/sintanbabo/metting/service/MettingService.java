package com.sintanbabo.metting.service;

import java.util.HashMap;
import java.util.List;

import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.model.MettingList;

public interface MettingService {
	// 회의실 예약
	void save(Metting metting) throws Exception;

	// 회의실 예약 세부 확인
	Metting get(HashMap<String,Object> map) throws Exception;

	// 회의실 예약 확인
	List<MettingList> list(String date) throws Exception;

	// 회의실 예약 모두 확인
	List<Metting> listAll() throws Exception;

	// 회의실 예약 변경
	void update(Metting metting) throws Exception;

	// 회의실 예약 취소
	void delete(HashMap<String,Object> map) throws Exception;
}
