package model;

public class BinaryThree {

	private long number;
	
	private BinaryThree up;
	private BinaryThree right;
	private BinaryThree left;
	
	public BinaryThree(long n) {
		number = n;
		up = null;
		right = null;
		left = null;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public BinaryThree getRight() {
		return right;
	}

	public void setRight(BinaryThree right) {
		this.right = right;
	}

	public BinaryThree getLeft() {
		return left;
	}

	public void setLeft(BinaryThree left) {
		this.left = left;
	}

	public BinaryThree getUp() {
		return up;
	}

	public void setUp(BinaryThree up) {
		this.up = up;
	}
	
	
}
