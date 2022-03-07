package com.mc.main.advanced.designpatterns.behavioural.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GroupPage implements MediaSubject {
	
	private String name;
	private final String creationDate;
	private List<String> posts;

	private List<MediaObserver> observers;
	
	public GroupPage() {
		super();
		this.creationDate = LocalDate.now().toString();
		this.posts = new ArrayList<>();
		this.observers = new ArrayList<>();
	}
	
	public GroupPage(String name) {
		this();
		this.name = name;
	}
	
	public void post(String message) {
		this.posts.add(message);
		notifyObservers(message);
	}

	@Override
	public boolean notifyObservers(String post) {
		try {
			// We could require a certain observer set runs first here
			// this could determine functionality for other observers
			// for example, perhaps this page is added to a ban list
			// of the website - we could prevent the notification process to a group of
			// Observers based on their type.
			for(MediaObserver ob : observers) {
				ob.update(post, this);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean addObserver(MediaObserver ob) {
		return this.observers.add(ob);
	}

	@Override
	public boolean removeObserver(MediaObserver ob) {
		return this.observers.remove(ob);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPosts() {
		return posts;
	}

	public void setPosts(List<String> posts) {
		this.posts = posts;
	}

	public List<MediaObserver> getObservers() {
		return observers;
	}

	public void setObservers(List<MediaObserver> observers) {
		this.observers = observers;
	}

	public String getCreationDate() {
		return creationDate;
	}
	
}
