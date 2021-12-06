package model.service;

public interface Subject {
	public static void register(Observer ob) {
		// register
	}
	
	public static void contactOwner() {
		// contact
	}
	
	public static void remove(Observer ob) {
		// remove
	}
	
	public static void notifyObserver() {
		// notify (subscribe/unsubcribe)
	}
}
