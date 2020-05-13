package model;

import java.util.ArrayList;

import javax.swing.plaf.multi.MultiButtonUI;

public class Structure {
	
	public final static char ITERATIVE = 'I';
	public final static char RECURSIVE = 'R';

	public ArrayList<Numbers>numbers;
	public BinaryTree root;
	public LinkedList first;
	
	public Structure() {
		numbers = new ArrayList<Numbers>();
	}
	
	public long[] generateNumbers(int n) {
		long[] numeros = new long[n];
		long num = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			num = (long)(Math.random()*n+1);
			numeros[i] = num;
		}
		
		return numeros;
	}
	
	public void addArrayList(int n) {
		long[] numeros = generateNumbers(n);
		Numbers number = null;
		
		for (int i = 0; i < numeros.length; i++) {
			number = new Numbers(numeros[i]);
			numbers.add(number);
		}
	}
	
	public boolean SearchArrayIterative(long[] n) {
		boolean found = false;
		
		for(int i = 0; i < n.length; i++) {
			for (int j = 0; j < numbers.size() && !found; j++) {
				if (n[i] == numbers.get(j).getNumber()) {
					found = true;
				}
			}
		}	
		return found;
	}
	
	public boolean searchArrayRecursive(long[] n, int pos) {
		boolean found = false;
		int i = 0;
		
		while (i < n.length) {
			if (n[i] == numbers.get(pos).getNumber() ) {
				found = true;
				i = i + 1;
				return searchArrayRecursive(n, numbers.size()-1);
			}else {
				return searchArrayRecursive(n, pos-1);
			}
		}
		return found;
	}
	
	public Numbers removeArrayIterative(long[] n) {
		Numbers temp = null;
		boolean removed = false;
		for (int i = 0; i < n.length; i++) {
			for (int j = 0; j < numbers.size() && !removed; j++) {
				if (n[i] == numbers.get(j).getNumber()) {
					temp = numbers.get(j);
					numbers.remove(j);
					removed = true;
				}
			}
		}
		return temp;
	}
	
	public Numbers removeArrayRecursive(long[] n, int pos) {
		Numbers temp = null;
		int i = 0;
		
		while (i < n.length) {
			if (n[i] == numbers.get(pos).getNumber()) {
				temp = numbers.get(pos);
				i = i+1;
				return removeArrayRecursive(n, numbers.size() - 1);
			}else {
				return removeArrayRecursive(n, pos - 1);
			}
			
		}
		
		return temp;
	}
	
	public void addListIterative(int input) {
		LinkedList lk = null;
		long[] n = generateNumbers(input);
		
		for (int i = 0; i < n.length; i++) {
			if (first == null) {
				lk = new LinkedList(n[i]);
			}else {
				LinkedList temp = first;
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				lk = new LinkedList(n[i]);
				temp.setNext(lk);
				lk.setPrev(temp);
			}
		}
	}
	
	public void addListRecursive(long[] n, LinkedList temp) {
		int i = 0;
		
		while (i < n.length) {
			LinkedList lk = new LinkedList(n[i]);
			
			if (first == null) {
				first = lk;
			}else {
				if (temp.getNext() == null) {
					temp.setNext(lk);
					lk.setPrev(temp);
				
				}else {
					temp = temp.getNext();
					addListRecursive(n,temp);
				}
			}
		}
	}
	
	public boolean searchListIterative(long[] n) {
		boolean found = false;
		if (first != null) {
			LinkedList temp = first;
			for (int i = 0; i < n.length; i++) {
				while (temp.getNext() != null && !found) {
					if (n[i] == temp.getNumber()) {
						found = true; 
					}
					temp = temp.getNext();
				}
			}
		}
		return found; 
	}
	
	public boolean searchListRecursive(long[] n, LinkedList temp) {
		boolean found = false;
		
		for (int i = 0; i < n.length; i++) {
			if (temp != null) {
				if (temp.getNumber() == n[i]) {
					found = true;
				}else {
					temp = temp.getNext();
					return searchListRecursive(n, temp);
					
				}
			}
		}
		return found;
	}
	public LinkedList removeListIterative(long[] n) {
		LinkedList lk = null;
		
		if (first != null) {
			LinkedList temp = first;
			for (int i = 0; i < n.length; i++) {
				while (temp != null) {
					if (n[i] == temp.getNumber()) {
						lk = temp;
						LinkedList aux = temp.getPrev();
						LinkedList aux2 = temp.getNext();
						
						aux.setNext(aux2);
						aux2.setPrev(aux);
						temp.setNext(null);
						temp.setPrev(null);
					}
					temp = temp.getNext();
				}
			}
		}
		return lk;
	}
	
	public LinkedList removeListRecursive(long[]  n, LinkedList temp) {
		LinkedList lk = null;
		int i = 0;
		
		while (i < n.length) {
			if (temp != null && temp.getNumber() == n[i]) {
				
				temp = lk;
				LinkedList aux = temp.getPrev();
				LinkedList aux2 = temp.getNext();
				
				aux.setNext(aux2);
				aux2.setPrev(aux);
				temp.setNext(null);
				temp.setPrev(null);
				
			}else {
				temp = temp.getNext();
				return removeListRecursive(n, temp);
			}
		}
		
		return lk;
	}
	
	public void addTreeIterative(long[] n) {
		boolean add = false, rigth = false, left =false;
		
		for (int i = 0; i < n.length; i++) {
			BinaryTree bt = new BinaryTree(n[i]);
			
			if (root == null) {
				root = bt;
			}else {
				BinaryTree temp = root;
				while (!add) {
					if (bt.getNumber() > temp.getNumber()) {
						if (temp.getRight() == null) {
							add = true;
							rigth = true;
						}else {
							temp = temp.getRight();
						}
					}else {
						if (temp.getLeft() == null) {
							add = true;
							left = true;
						}else {
							temp = temp.getLeft();
						}
					}
				}
				if (left) {
					temp.setLeft(bt);
					bt.setUp(temp);
				}else if (rigth) {
					temp.setRight(bt);
					bt.setUp(temp);
				}			
			}
		}
	}
	
	
	public void addTreeRecursive(long[] n, BinaryTree temp) {
		for (int i = 0; i < n.length; i++) {
			BinaryTree bt = new BinaryTree(n[i]);
			if (temp == null) {
				temp = bt;
			}else {
				if (temp.getNumber() <= bt.getNumber()) {
					if (temp.getLeft() == null) {
						temp.setLeft(bt);
						bt.setUp(temp);
					}else {
						addTreeRecursive(n,temp.getLeft());
					}
				}else {
					if (temp.getRight() == null) {
						temp.setRight(bt);
						bt.setUp(temp);
					}else {
						addTreeRecursive(n, temp.getRight());
					}
				}
			}
		}
	}
	
	public boolean searchTreeIterative(long[] n) {
		boolean found = false;
		BinaryTree temp = root;
		if (temp != null) {
			for (int i = 0; i < n.length; i++) {
				while (!found) {
					if (n[i] > temp.getNumber()) {
						if (temp.getRight() != null) {
							temp = temp.getRight();
						}
					}else if (n[i] < temp.getNumber()) {
						if (temp.getLeft() != null) {
							temp = temp.getLeft();
						}
					}else {
						found = true;
					}
				}
			}
		}
		return found;
	}
	
	public boolean searchTreeRecursive(long[] n , BinaryTree temp) {
		boolean found = false;
		for (int i = 0; i < n.length; i++) {
			if (temp != null && temp.getNumber() == n[i]) {
				found = true;
			}else if (temp.getNumber() < n[i]) {
					return searchTreeRecursive(n, temp.getLeft());
			}else {
				return searchTreeRecursive(n, temp.getRight());
			}
		}
		return found;
	}
	
	public BinaryTree removeTreeIterative(long[]n) {
		BinaryTree bt = null;
		boolean removed = false;
		BinaryTree temp = root;

		if (root != null) {
			for(int i = 0; i < n.length; i++){
				while(!removed) {
					if (n[i] == temp.getNumber()) {
						if (temp.getLeft() != null && temp.getRight() != null) {
							BinaryTree aux = temp.getLeft();
							boolean min = false;
							while (!min) {
								if (aux.getRight() != null) {
									aux = aux.getRight();
								}else {
									min = true;
								}
							}
							temp.setNumber(aux.getNumber());
							if (aux.getLeft() != null) {
								BinaryTree aux2 = aux.getLeft();
								aux2.setUp(aux.getUp());
								aux.getUp().setRight(aux);
								aux.setUp(null);
								aux.setLeft(null);
								removed = true;
							}
						}else if (temp.getLeft() != null && temp.getRight() == null) {
							BinaryTree aux = temp.getLeft();
							aux.setUp(temp.getUp());
							temp.getUp().setLeft(aux);
							temp.setUp(null);
							temp.setLeft(null);
							removed = true;
						}else if (temp.getRight() != null && temp.getLeft() == null) {
							BinaryTree aux = temp.getRight();
							aux.setUp(temp.getUp());
							temp.getUp().setRight(aux);
							temp.setUp(null);
							temp.setRight(null);
							removed = true;
						}else {
							BinaryTree aux = temp.getUp();
							if (temp.equals(aux.getLeft())) {
								aux.setLeft(null);
								temp.setUp(null);
								removed = true;
							}else {
								aux.setRight(null);
								temp.setUp(null);
								removed = true;
							}
						}
					}
					if (n[i] > temp.getNumber()) {
						if (temp.getRight() != null) {
							temp = temp.getRight();
						}
					}else {
						if (temp.getLeft() != null) {
							temp = temp.getLeft();
						}
					}
				}
			}
		}
		return bt;
	}
	
	public BinaryTree removeTreeRecursive(long[] n, BinaryTree temp) {
		BinaryTree aux = null;
		for (int i = 0; i < n.length; i++) {
			if (temp != null && (temp.getLeft() == null & temp.getRight() == null)) {
				aux = removeCase1(temp, n[i]);
			}else if (temp != null && (temp.getClass() != null & temp.getRight() == null)) {
				aux =  removeCase2(temp, n[i]);
			}else if (temp != null && (temp.getLeft() == null & temp.getRight() != null)) {
				aux = removeCase2(temp, n[i]);
			}else {
				aux = removeCase3(temp, n[i]);
			}
		}
		
	}
	
	public BinaryTree removeCase1(BinaryTree r, long n) {
		BinaryTree temp = null;
		
		if(r.getNumber() == n) {
			if (r.getUp().getNumber() > r.getNumber()) {
				r.getUp().setLeft(null);
				temp = r;
				r.setUp(null);
			}else {
				r.getUp().setRight(null);
				temp = r;
				r.setUp(null);
			}
		}
		
		return temp;
	}
	
	public BinaryTree removeCase2(BinaryTree r, long n) {
		BinaryTree temp = null;
		BinaryTree sheet = r.getLeft() != null ? r.getLeft() : r.getRight();
		
		if(r.getNumber() == n && r.getUp().getLeft().equals(r)) {
			temp = r;
			temp.getUp().setLeft(sheet);
			sheet.setUp(temp.getUp());
			temp.setUp(null);
		}else if (r.getNumber() == n && r.getUp().getRight().equals(r)) {
			temp = r;
			temp.getUp().setRight(sheet);
			sheet.setUp(temp);
			temp.setUp(null);
		}
		return temp;
	}
	
	public BinaryTree removeCase3 (BinaryTree r, long n) {
		BinaryTree temp = null;
		
		if (getMaxRight(r) != null) {
			r.setNumber(getMaxRight(r).getNumber());
			temp = getMaxRight(r);
			
			if (r.getLeft() == null && r.getRight() == null) {
				removeCase1(r, r.getNumber());
			}else {
				if (r.getLeft() != null & r.getRight() == null) {
					removeCase2(r, r.getNumber());
				}else if(r.getLeft() == null & r.getRight() != null) {
					removeCase2(r, r.getNumber());
				}
			}
		}
		return temp;
	}
	
	public BinaryTree getMaxRight(BinaryTree r) {
		BinaryTree returned = null;
		
		if (r.getRight() != null) {
			return getMaxRight(r.getRight());
		}else {
			return returned = r;
		}
	}

}
