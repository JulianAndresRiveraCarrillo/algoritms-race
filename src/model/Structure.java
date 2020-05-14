package model;

import java.util.ArrayList;

import javax.swing.plaf.multi.MultiButtonUI;

public class Structure {

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
	
	public boolean SearchArrayIterative(int input) {
		boolean found = false;
		long[] n = generateNumbers(input);
		
		if (getNumbers() == null) {
			addArrayList(input);
		}
		
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
		
		if (getNumbers() == null) {
			addArrayList(n.length);
		}
		
		while (i < n.length & pos >= 0) {
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
		
		if (getNumbers() == null) {
			addArrayList(n.length);
		}
		
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
		
		if (getNumbers() == null) {
			addArrayList(n.length);
		}
		
		while (i < n.length & pos >=0) {
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
		int n0 = n.length;
		long[] n2 = new long[n.length-1];
		int n00 = n2.length;
		for (int j = 0; j < n2.length && n2.length >= 1; j++) {
			if (n2.length == 1) {
				n2[0] = n[0];
			}
			n2[i] = n[i];
		}
		while (i < n.length & n2.length >0) {
			LinkedList lk = new LinkedList(n[i]);
			
			if (temp == null) {
				temp = lk;
				i++;
			}else {
				if (temp.getNext() == null) {
					temp.setNext(lk);
					lk.setPrev(temp);
					i = i+1;
				
				}else {
					temp = temp.getNext();
					addListRecursive(n2,temp);
				}
			}
		}
	}
	
	public boolean searchListIterative(long[] n) {
		boolean found = false;
		
		if (first == null) {
			addListIterative(n.length);
		}if(first != null){
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
		if (temp == null) {
			addListRecursive(generateNumbers(n.length), temp);
		}else {
			for (int i = 0; i < n.length; i++) {
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
		if(first == null) {
			addListIterative(n.length);
		}if (first != null) {
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
		
		if (root == null) {
			addListRecursive(generateNumbers(n.length), temp);
		}
		if(root != null) {
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
		}
		return lk;
	}
	
	public void addTreeIterative(int input) {
		boolean add = false, rigth = false, left =false;
		long[] n = generateNumbers(input);
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
				if (bt.getNumber() <= temp.getNumber()) {
					if (temp.getLeft() == null) {
						temp.setLeft(bt);
						bt.setUp(temp);
					}else {
						temp = temp.getLeft();	
					}
				}
				if (bt.getNumber() > temp.getNumber()) {
						if (temp.getRight() == null) {
					temp.setRight(bt);
					bt.setUp(temp);
					}
				}else {
					temp = temp.getRight();
				}
					addTreeRecursive(n,temp);
			}
		}
	}
	
	public boolean searchTreeIterative(long[] n) {
		boolean found = false;
		BinaryTree temp = root;
		
		if (temp == null) {
			addTreeIterative(n.length);
		}if (temp != null) {
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
		if (temp == null) {
			addTreeRecursive(generateNumbers(n.length), temp);
		}if(temp != null) {
			for (int i = 0; i < n.length; i++) {
				if (temp != null && temp.getNumber() == n[i]) {
					found = true;
				}else if (temp.getNumber() < n[i]) {
					return searchTreeRecursive(n, temp.getLeft());
				}else {
					return searchTreeRecursive(n, temp.getRight());
				}
			}
		}
		return found;
	}
	
	public BinaryTree removeTreeIterative(long[]n) {
		BinaryTree bt = null;
		boolean removed = false;
		BinaryTree temp = null;
		
		if(root == null) {
			addTreeIterative(n.length);
			temp = root;
		}if (temp != null) {
			for(int i = 1; i < n.length; i++){
				while(!removed) {
					if (n[i] == temp.getNumber()) {
						if (temp.getLeft() != null & temp.getRight() != null) {
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
						}else if (temp.getLeft() != null & temp.getRight() == null) {
							BinaryTree aux = temp.getLeft();
							aux.setUp(temp.getUp());
							temp.getUp().setLeft(aux);
							temp.setUp(null);
							temp.setLeft(null);
							removed = true;
						}else if (temp.getRight() != null & temp.getLeft() == null) {
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
						}else {
							removed = true;
						}
					}else if(n[i] <= temp.getNumber()){
						if (temp.getLeft() != null) {
							temp = temp.getLeft();
						}else {
							removed = true;
						}
					}
				}
			}
		}
		return bt;
	}
	
	public BinaryTree removeTreeRecursive(long[] n, BinaryTree temp) {
		BinaryTree aux = null;
		
		if (temp == null) {
			addTreeRecursive(generateNumbers(n.length), temp);
		}
		if (temp != null) {
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
		return aux;
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

	
	public ArrayList<Numbers> getNumbers() {
		return numbers;
	}

	public BinaryTree getRoot() {
		return root;
	}

	public LinkedList getFirst() {
		return first;
	}

}
