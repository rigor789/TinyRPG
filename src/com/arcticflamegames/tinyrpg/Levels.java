package com.arcticflamegames.tinyrpg;

public enum Levels {
	LEVEL1(1, "/level.png"),
	LEVEL2(2, "/level2.png"),
	LEVEL3(3, "/level3.png"),
	LEVEL4(4, "/level4.trpg");
	
	@SuppressWarnings("unused")
	private int number;
	private String path;
	Levels(int number, String path){
		this.number = number;
		this.path = path;
	}
	
	public String getPath(){
		return path;
		
	}
}
