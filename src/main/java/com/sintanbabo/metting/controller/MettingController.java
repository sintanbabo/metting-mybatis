package com.sintanbabo.metting.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintanbabo.metting.model.Metting;
import com.sintanbabo.metting.service.MettingService;

@RestController
public class MettingController {

	@Autowired
	private MettingService mettingService;

	// 회의실 예약
	@PostMapping("/metting")
	public ResponseEntity<?> save(@RequestBody Metting metting) {
		int result = mettingService.save(metting);
		return ResponseEntity.ok()
				.body("Metting Reservation be saved. Metting Room : " + metting.getMettingRoomName()
						+ " Metting Date : " + metting.getDate() + " Metting Start : " + metting.getStart()
						+ " Metting End : " + metting.getEnd());
	}

	// 회의실 예약 확인
	@GetMapping("/metting/{mettingRoomName}/{date}/{from}/{to}")
	public ResponseEntity<Metting> get(@PathVariable("mettingRoomName") String mettingRoomName,
			@PathVariable("date") Date date, @PathVariable("start") Date start, @PathVariable("end") Date end) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("mettingRoomName", mettingRoomName);
		map.put("date",date);
		map.put("start", start);
		map.put("end", end);
		Metting metting = mettingService.get(map);
		return ResponseEntity.ok().body(metting);
	}

	// 일자에 해당하는 회의실 예약 정보 확인
	@GetMapping("/metting/{date}")
	public ResponseEntity<List<Metting>> list(Date date) {
		List<Metting> mettings = mettingService.list(date);
		return ResponseEntity.ok().body(mettings);
	}

	// 일자와 상관없는 모든 회의실 예약 정보 확인
	@GetMapping("/metting")
	public ResponseEntity<List<Metting>> list() {
		List<Metting> mettings = mettingService.listAll();
		return ResponseEntity.ok().body(mettings);
	}

	// 회의실 예약 정보 수정
	@PutMapping("/metting/{mettingRoomName}/{date}/{from}/{to}")
	public ResponseEntity<?> update(@PathVariable("mettingRoomName") String mettingRoomName,
			@PathVariable("date") Date date, @PathVariable("start") Date start, @PathVariable("end") Date end,
			@RequestBody Metting metting) {
		mettingService.update(metting);
		return ResponseEntity.ok().body("Metting Reservation has been updated successfully.");
	}

	// 회의실 예약 정보 삭제
	@DeleteMapping("/metting")
	public ResponseEntity<?> delete(@PathVariable("mettingRoomName") String mettingRoomName,
			@PathVariable("date") Date date, @PathVariable("start") Date start, @PathVariable("end") Date end) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("mettingRoomName", mettingRoomName);
		map.put("date",date);
		map.put("start", start);
		map.put("end", end);
		mettingService.delete(map);
		return ResponseEntity.ok().body("Metting Reservation has been deleted successfully.");
	}
}
