package com.sintanbabo.metting.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

@Entity(name="Metting")
@Table(name="TB_METTING", schema="metting")
@SQLInsert(
		sql = "insert into TB_METTING(mettingRoomName,date,start,end,user,cycleCount) value(?,?,?,?,?,?)")
public class Metting {
	
	@EmbeddedId
	private MettingId id;
	private String user; 
	private Long cycleCount;
	
	public MettingId getId() {
		return id;
	}
	public void setId(MettingId id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public long getCycleCount() {
		return cycleCount;
	}
	public void setCycleCount(long cycleCount) {
		this.cycleCount = cycleCount;
	}
}
