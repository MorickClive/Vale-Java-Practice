package com.mc.main.advanced.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminPostChecker implements MediaObserver {
	
	private static List<MediaSubject> banList;
	
	public AdminPostChecker() {
		super();
		banList = new ArrayList<>();
	}

	@Override
	public void update(String post, MediaSubject target) {
		if(filter(post)) {
			banList.add(target);
			System.out.println("!!!\nDetected inappropriate term, adding \"" + ((GroupPage)target).getName() + "\" to ban list\n!!!");
		}
	}
	
	private boolean filter(String post) {
		Pattern filter = Pattern.compile(".*dog");
		Matcher check = filter.matcher(post);
		
		return check.find();
	}
	
	public static List<MediaSubject> retrieveBanList() {
		if(banList == null) {
			banList = new ArrayList<>();		
		}
		return banList;
	}

}
