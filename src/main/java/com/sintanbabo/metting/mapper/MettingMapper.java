package com.sintanbabo.metting.mapper;

import java.util.HashMap;
import java.util.List;

import com.sintanbabo.metting.model.Metting;

public interface MettingMapper {
	// 회의실 예약
	int save(Metting metting);

	// 회의실 예약 세부 확인
	Metting get(HashMap<String,Object> map);
	
	// 중복된 예약 확인
	int check(HashMap<String,Object> map);

	// 회의실 예약 확인
	List<Metting> list(String date);

	// 회의실 예약 모두 확인
	List<Metting> listAll();

	// 회의실 예약 변경
	void update(Metting metting);

	// 회의실 예약 취소
	void delete(HashMap<String,Object> map);
}