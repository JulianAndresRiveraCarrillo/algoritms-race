package model;

import java.util.ArrayList;

public class Structure {

	public ArrayList<Numbers>numbers;
	public BinaryThree firstAbb;
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
	
	public void addLinkedListIterative(int n) {
		long[] numeros = generateNumbers(n);
		LinkedList lk = null;
		for (int i = 0; i < numeros.length; i++) {
			if (first == null) {
				lk = new LinkedList(numeros[i]);
				first = lk;
			}else {
				LinkedList temp = first;
				while (temp.getNext() == null) {
					temp= temp.getNext();
				}
				lk = new LinkedList(numeros[i]);
				temp.setNext(lk);
				lk.setPrev(temp);
			}
		}
	}
	
	/*public void addAbbIterative(int n) {
		long[] numeros = generateNumbers(n);
		BinaryThree bt = null;
		
	}
	
	*/
}
