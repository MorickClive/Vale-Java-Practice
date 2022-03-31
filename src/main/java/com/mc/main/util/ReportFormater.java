package com.mc.main.util;

public class ReportFormater {
	
	public static void reportHeader(String header) {
		System.out.format("%1$s%2$s\n%1$s", StringConst.DIV + "\n", header);
	}
	
	public static void reportDivided(String header, String... contents) {
		System.out.format("%1$s%2$s\n", StringConst.DIV + "\n", header);
		
		for(String content : contents) {
			System.out.format("%1$s%2$s\n", StringConst.DIV + "\n", content);
		}
		
		System.out.format("%s", StringConst.DIV + "\n");
	}

}
