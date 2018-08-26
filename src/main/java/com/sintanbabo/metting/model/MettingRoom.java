package com.sintanbabo.metting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="MettingRoom")
@Table(name="TB_METTING_ROOM", schema="metting")
public class MettingRoom {

	@Id
	private String mettingRoomName;
}
