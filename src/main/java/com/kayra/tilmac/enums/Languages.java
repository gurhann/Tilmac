package com.kayra.tilmac.enums;

public enum Languages {
	TR("tr"), ENG("eng");
	
	private String desc;
	
	private Languages(String desc) {
		this.desc = desc;
	}
	
	public String getDesc() {
		return this.desc;
	}
}
