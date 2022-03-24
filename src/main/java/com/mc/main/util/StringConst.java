package com.mc.main.util;

public enum StringConst {
	
	DIV("=".repeat(40));

	String val;
	
	StringConst(String x){
		val = x;
	}
	
	@Override
	public String toString() {
		return val;
	}

}
