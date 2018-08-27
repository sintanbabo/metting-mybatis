package com.sintanbabo.metting.controller;

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
import com.sintanbabo.metting.model.MettingList;
import com.sintanbabo.metting.service.MettingService;

@RestController
public class MettingController {

	@Autowired
	private MettingService mettingService;

	// 회의실 예약
	@PostMapping("/metting")
	public ResponseEntity<?> save(@RequestBody Metting metting) throws Exception{
		mettingService.save(metting);
		return ResponseEntity.ok().body("Metting Reservation be saved successfully.");
	}

	// 회의실 예약 확인
	@GetMapping("/metting/{mettingRoomName}/{start}/{end}")
	public ResponseEntity<Metting> get(
			@PathVariable("mettingRoomName") String mettingRoomName,
			@PathVariable("start") String start,
			@PathVariable("end") String end) throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("mettingRoomName", mettingRoomName);
		map.put("start", start);
		map.put("end", end);
		Metting metting = mettingService.get(map);
		return ResponseEntity.ok().body(metting);
	}

	// 일자에 해당하는 회의실 예약 정보 확인
	@GetMapping("/metting/{date}")
	public ResponseEntity<List<MettingList>> list(@PathVariable("date") String date) throws Exception {
		List<MettingList> mettings = mettingService.list(date);
		return ResponseEntity.ok().body(mettings);
	}

	// 일자와 상관없는 모든 회의실 예약 정보 확인
	@GetMapping("/metting")
	public ResponseEntity<List<Metting>> list() throws Exception {
		List<Metting> mettings = mettingService.listAll();
		return ResponseEntity.ok().body(mettings);
	}

	// 회의실 예약 정보 수정
	@PutMapping("/metting")
	public ResponseEntity<?> update(@RequestBody Metting metting) throws Exception {
		mettingService.update(metting);
		return ResponseEntity.ok().body("Metting Reservation has been updated successfully.");
	}

	// 회의실 예약 정보 삭제
	@DeleteMapping("/metting/{mettingRoomName}/{start}/{end}")
	public ResponseEntity<?> delete(
			@PathVariable("mettingRoomName") String mettingRoomName,
			@PathVariable("start") String start,
			@PathVariable("end") String end) throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("mettingRoomName", mettingRoomName);
		map.put("start", start);
		map.put("end", end);
		mettingService.delete(map);
		return ResponseEntity.ok().body("Metting Reservation has been deleted successfully.");
	}
}
