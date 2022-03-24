package com.mc.main.advanced.designpatterns.behavioural.observer;

import java.util.HashMap;
import java.util.Map.Entry;

import com.mc.main.util.StringConst;

public class Subscriber implements MediaObserver {
	
	private String username;
	
	private HashMap<Integer, String> inbox;

	public Subscriber() {
		super();
		this.inbox = new HashMap<>();
	}
	
	public Subscriber(String username) {
		this();
		this.username = username;
	}

	@Override
	public void update(String post, MediaSubject targ) {		
		String groupName = ((GroupPage)targ).getName();
		String alert = String.format(
				"%s - a new post from \"%s\" has been released, check your inbox for more!",
				username, groupName
				);
		
		inbox.put(inbox.size()+1, "GROUP \"" + groupName + "\": \n\t\t" + post);
		
		System.out.println(alert);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public HashMap<Integer, String> getInbox() {
		return inbox;
	}

	public void setInbox(HashMap<Integer, String> inbox) {
		this.inbox = inbox;
	}
	
	public String getMessage(int key) {
		return this.inbox.get(key);
	}
	
	public boolean editMessage(int key, String message) {
		if(getMessage(key) == null) {
			return false;
		}
		
		this.inbox.put(key, message);
		return true;
	}

	public void printInbox() {		
		System.out.println(username + "'s Inbox:\n" + StringConst.DIV);
		
		for(Entry<Integer, String> message : inbox.entrySet()) {
			System.out.println("Message #" + message.getKey() + ":\n\t" + message.getValue());
		}

		System.out.println(StringConst.DIV);
	}
}
