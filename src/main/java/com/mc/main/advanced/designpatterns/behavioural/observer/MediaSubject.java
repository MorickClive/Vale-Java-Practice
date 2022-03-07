package com.mc.main.advanced.designpatterns.behavioural.observer;

public interface MediaSubject {
	
	public boolean notifyObservers(String post);
	public boolean addObserver(MediaObserver ob);
	public boolean removeObserver(MediaObserver ob);
	
}
