package model.service;

public interface Subject {
	public void register(Observer ob);
	
	public void contactOwner();
	
	public void remove(Observer ob);
	
	public void notifyObserver();
}
