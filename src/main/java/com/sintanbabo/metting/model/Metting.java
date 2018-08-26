package com.sintanbabo.metting.model;

import java.util.Date;

public class Metting {

	private String mettingRoomName;
	private Date date;
	private Date start;
	private Date end;
	private String user;
	private Long cycleCount;

	public String getMettingRoomName() {
		return mettingRoomName;
	}

	public void setMettingRoomName(String mettingRoomName) {
		this.mettingRoomName = mettingRoomName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
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
