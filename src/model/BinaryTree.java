package model;

public class BinaryTree {

	private long number;
	
	private BinaryTree up;
	private BinaryTree right;
	private BinaryTree left;
	
	public BinaryTree(long n) {
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

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getUp() {
		return up;
	}

	public void setUp(BinaryTree up) {
		this.up = up;
	}
	
	
}
