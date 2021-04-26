package com.voc.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PartyType {

	Company(1, "운송사"),
	Driver(2, "기사");
	
	private Integer id;
	private String desc;
}
