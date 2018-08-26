package com.sintanbabo.metting.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/*
 * Metting 에 대한 복합키 정의  
 */
@Embeddable
public class MettingId implements Serializable {

	private String mettingRoomName;
	private Date date;
	private Date start;
	private Date end;
	
	public MettingId() {}
	
	public MettingId(String mettingRoomName, Date date, Date start, Date end) {
		this.mettingRoomName = mettingRoomName;
		this.date = date;
		this.start = start;
		this.end = end;
	}

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

	/*
	 * equals
	 * 
	 * 입력하는 키와 완전히 같은 값을 찾아야 하지만, 회의실 예약은 개념이 다르다.
	 * 1. 이전 회의실과 일부가 곂치는 경우 (from 이 다른 회의실 예약의 중간에 있을 경우)
	 * 2. 이전 회의실 예약과 일부가 곂치는 경우 (to 가 다른 회의실 예약의 중간에 있을 경우)
	 * 3. 이전 회의실 예약을 전부 포함하는 경우 (from 이 이전 회의실 예약보다 빠르고, to 가 이전 회의실 예약보다 느릴 경우)
	 * 4. 이전 회의실 예약과 시작과 끝이 모두 같은 경
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if(this == o) return true;
		if( !(o instanceof MettingId) ) return false;
		MettingId temp = (MettingId)o;
		
		//1 . case
		if (getStart().compareTo(temp.getStart()) < 0 && temp.getStart().compareTo(getEnd()) < 0) {
			return true;
		}
		// 2. case 
		else if (getStart().compareTo(temp.getEnd()) < 0 && temp.getEnd().compareTo(getEnd()) < 0) {
			return true;
		}
		// 3. case
		else if (temp.getStart().compareTo(getStart()) < 0 && getEnd().compareTo(temp.getEnd()) < 0) {
			return true;
		}
		// 4. case
		else if (temp.getStart().compareTo(getStart()) == 0 && getEnd().compareTo(temp.getEnd()) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int hashCode() {
		return Objects.hash(getStart(), getEnd(), getMettingRoomName());
	}
}
