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
		int i = 0;
		Numbers number = null;
		
		while (i < numeros.length) {
			number = new Numbers(numeros[i]);
			numbers.add(number);
		}
	}
	
	public boolean SearchArrayIterative(long n) {
		boolean found = false;
		
		for (int j = 0; j < numbers.size() && !found; j++) {
			if (n == numbers.get(j).getNumber()) {
				found = true;
			}
		}
		return found;
	}
	
	public boolean searchArrayRecursive(long n, int pos) {
		boolean found = false;
		
		if (n == numbers.get(pos).getNumber()) {
			return found;
		}else {
			return searchArrayRecursive(n, pos-1);
		}
	}
	
	public Numbers removeArrayIterative(long n) {
		Numbers temp = null;
		
		for (int i = 0; i < numbers.size(); i++) {
			if (n == numbers.get(i).getNumber()) {
				temp = numbers.get(i);
				numbers.remove(i);
			}
		}
		return temp;
	}
	
	public Numbers removeArrayRecursive(long n, int pos) {
		Numbers temp = null;
		
		if (n == numbers.get(pos).getNumber()) {
			temp = numbers.get(pos);
			numbers.remove(pos);
			return temp;
		}else {
			return removeArrayRecursive(n, pos-1);
		}
	}
	public void searchArrayList(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == ITERATIVE ) {
			for (int i = 0; i < numeros.length; i++) {
				SearchArrayIterative(numeros[i]);
			}
		}else {
			int pos = numbers.size()-1;
			for (int i = 0; i < numeros.length; i++) {
				searchArrayRecursive(numeros[i], pos);
			}
		}
	}
	
	public void removeArryList(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == ITERATIVE) {
			for (int i = 0; i < numeros.length; i++) {
				removeArrayIterative(numeros[i]);
			}
		}else {
			int pos = numbers.size()-1;
			for (int i = 0; i < numeros.length; i++) {
				removeArrayRecursive(n, pos);
			}
		}
	}
	
	public void addListIterative(long n ) {
		LinkedList lk = null;
		
		if (first == null) {
			lk = new LinkedList(n);
			first = lk;
		}else {
			LinkedList temp = first;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			lk = new LinkedList(n);
			temp.setNext(lk);
			lk.setPrev(temp);
		}
	}
	
	public void addListRecursive(long n, LinkedList temp) {
		LinkedList lk = new LinkedList(n);
		
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
	
	public boolean searchListIterative(long n) {
		boolean found = false;
		if (first != null) {
			LinkedList temp = first;
			while (temp.getNext() != null && !found) {
				if (n == temp.getNumber()) {
					found = true; 
				}
				temp = temp.getNext();
			}
			
		}
		return found; 
	}
	
	public boolean searchListRecursive(long n, LinkedList temp) {
		boolean found = false;
			if (temp.getNumber() == n && temp != null) {
				found = true;
				return found;
			}else {
				temp = temp.getNext();
				return searchListRecursive(n, temp);
				
			}
	}
	public LinkedList removeListIterative(long n) {
		LinkedList lk = null;
		boolean removed = false;
		if (first != null) {
			LinkedList temp = first;
			while (temp.getNext() != null && !removed) {
				if (n == temp.getNumber()) {
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
		return lk;
	}
	
	public LinkedList removeListRecursive(long n, LinkedList temp) {
		LinkedList lk = null;
		
		if (temp != null && temp.getNumber() == n) {
			
			temp = lk;
			LinkedList aux = temp.getPrev();
			LinkedList aux2 = temp.getNext();
			
			aux.setNext(aux2);
			aux2.setPrev(aux);
			temp.setNext(null);
			temp.setPrev(null);
			
			return lk; 
		}else {
			temp = temp.getNext();
			return removeListRecursive(n, temp);
		}
	}
	
	public void addLinkedList(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == ITERATIVE) {
			for (int i = 0; i < numeros.length; i++) {
				addListIterative(numeros[i]);
			}
		}else {
			for (int i = 0; i < numeros.length; i++) {
				addListRecursive(numeros[i], first);
			}
		}
	}
	
	public void searchLinkedList(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == ITERATIVE) {
			for (int i = 0; i < numeros.length; i++) {
				searchListIterative(numeros[i]);
			}
		}else {
			for (int i = 0; i < numeros.length; i++) {
				searchListRecursive(numeros[n], first);
			}
		}
			
	}
	
	public void removeLinkedList(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == ITERATIVE) {
			for (int i = 0; i < numeros.length; i++) {
				removeArrayIterative(numeros[i]);
			}
		}else {
			for (int i = 0; i < numeros.length; i++) {
				removeListRecursive(n, first);
			}
		}
	}
	
	public void addTreeIterative(long n) {
		BinaryTree bt = new BinaryTree(n);
		boolean add = false, rigth = false, left =false;
		if (root == null) {
			root = bt;
		}else {
			BinaryTree temp = root;
			while(!add) {
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
	
	
	public void addTreeRecursive(long n, BinaryTree temp) {
		BinaryTree bt = new BinaryTree(n);
		
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
	
	public boolean searchTreeIterative(long n) {
		boolean found = false;
		BinaryTree temp = root;
		
		if (temp != null) {
			while (!found) {
				if (n > temp.getNumber()) {
					if (temp.getRight() != null) {
						temp = temp.getRight();
					}
				}else if (n < temp.getNumber()) {
					if (temp.getLeft() != null) {
						temp = temp.getLeft();
					}
				}else {
					found = true;
				}
			}
		}
		return found;
	}
	
	public boolean searchTreeRecursive(long n , BinaryTree temp) {
		
		if (temp != null) {
			if (temp.getNumber() == n) {
				return true; 
			}else if (temp.getNumber() < n) {
					return searchTreeRecursive(n, temp.getLeft());
			}else {
				return searchTreeRecursive(n, temp.getRight());
			}
		}
	}
	
	public BinaryTree removeTreeIterative(long n) {
		BinaryTree bt = null;
		boolean removed = false;
		BinaryTree temp = root;
		
		if (temp != null) {
			while(!removed) {
				if (n == temp.getNumber()) {
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
						}
					}else if (temp.getLeft() != null && temp.getRight() == null) {
						BinaryTree aux = temp.getLeft();
						aux.setUp(temp.getUp());
						temp.getUp().setLeft(aux);
					}else if (temp.getRight() != null && temp.getLeft() == null) {
						BinaryTree aux = temp.getRight();
						aux.setUp(temp.getUp());
						temp.getUp().setRight(aux);
					}else {
						BinaryTree aux = temp.getUp();
						if (temp.equals(aux.getLeft())) {
							aux.setLeft(null);
							temp.setUp(null);
						}else if (temp.equals(aux.getRight())) {
							aux.setRight(null);
							temp.setUp(null);
						}else {
							temp = null;
						}
					}
				}
			}
		}
		
		return bt;
	}
	
	public void addBinaryTree(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == RECURSIVE) {
			for (int i = 0; i < numeros.length; i++) {
				addTreeRecursive(numeros[i], root);
			}
		}else {
			for (int i = 0; i < numeros.length; i++) {
				addTreeIterative(numeros[i]);
			}
		}
	}
	
	public void searchBinaryTree(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == RECURSIVE) {
			for (int i = 0; i < numeros.length; i++) {
				searchTreeRecursive(numeros[i], root);
			}
		}else {
			for (int i = 0; i < numeros.length; i++) {
				searchTreeIterative(numeros[i]);
			}
		}
	}
	
	public void removeBinaryTree(int n, char mode) {
		long[] numeros = generateNumbers(n);
		
		if (mode == RECURSIVE) {
			//metodo recursivo
		}else {
			for (int i = 0; i < numeros.length; i++) {
				removeTreeIterative(numeros[i]);
			}
		}
	}
}
