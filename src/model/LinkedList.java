package model;

public class LinkedList {

	private long number;
	
	private LinkedList prev;
	private LinkedList next;
	
	public LinkedList(long number) {
		this.number = number;
		prev = null;
		next = null;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public LinkedList getPrev() {
		return prev;
	}

	public void setPrev(LinkedList prev) {
		this.prev = prev;
	}

	public LinkedList getNext() {
		return next;
	}

	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	
}
