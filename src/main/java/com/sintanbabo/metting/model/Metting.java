package com.sintanbabo.metting.model;

import java.util.Date;

public class Metting {

	private String mettingRoomName;
	private String start;
	private String end;
	private String user;
	private Long cycleCount;

	public String getMettingRoomName() {
		return mettingRoomName;
	}

	public void setMettingRoomName(String mettingRoomName) {
		this.mettingRoomName = mettingRoomName;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Long getCycleCount() {
		return cycleCount;
	}

	public void setCycleCount(Long cycleCount) {
		this.cycleCount = cycleCount;
	}

}
