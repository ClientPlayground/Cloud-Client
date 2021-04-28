package pofou.event.impl;

import pofou.event.EventCancelable;

public class KeyEvent extends EventCancelable {

public final int key;
	
	public KeyEvent(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}
	
	
	
}
