package thread;

import javafx.application.Platform;
import javafx.scene.control.Label;
import model.Structure;
import ui.RaceControllerGUI;

public class AlgoritmThread extends Thread{
	private Structure st;
	private RaceControllerGUI gui;
	
	private char mode;
	private char action;
	private int structure;
	private int input;
	
	public AlgoritmThread(Structure st, RaceControllerGUI gui, char mode, char action, int structure, int input) {
		this.st = st;
		this.gui = gui;
		this.action = action;
		this.mode = mode;
		this.structure = structure;
		this.input = input;
	}
	
	public void run () {
		try {
			while (gui.isRunning()) {
				long[] numeros = st.generateNumbers(input);
				sleep(1000);
				algoritm(mode, action, structure, input, numeros);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void algoritm(char mode, char action, int structure, int input, long [] numeros) {
		if (mode == 'I') {
			if (action == 'A') {
				if (structure == 1) {
					st.addArrayList(input);
				}if (structure == 2) {
					st.addListIterative(input);
				}if (structure == 3) {
					st.addTreeIterative(input);
				}
			}else if (action == 'S') {
				if (structure == 1) {
					st.SearchArrayIterative(input);
				}if (structure == 2) {
					st.searchListIterative(numeros);
				}if (structure == 3) {
					st.searchTreeIterative(numeros);
				}
			}else {
				if (structure == 1) {
					st.removeArrayIterative(numeros);
				}if (structure == 2) {
					st.removeListIterative(numeros);
				}if (structure == 3) {
					st.removeTreeIterative(numeros);
				}
			}
		}else {
			if (action == 'A') {
				if (structure == 1) {
					st.addArrayList(input);
				}if (structure == 2) {
					st.addListRecursive(numeros, st.getFirst());
				}if (structure == 3) {
					st.addTreeRecursive(numeros, st.getRoot());
				}
			}else if (action == 'S') {
				if (structure == 1) {
					st.searchArrayRecursive(numeros, st.getNumbers().size()-1);
				}if (structure == 2) {
					st.searchListRecursive(numeros, st.getFirst());
				}if (structure == 3) {
					st.searchTreeRecursive(numeros, st.getRoot());
				}
			}else {
				if (structure == 1) {
					st.removeArrayRecursive(numeros, st.getNumbers().size()-1);
				}if (structure == 2) {
					st.removeListRecursive(numeros, st.getFirst());
				}if (structure == 3) {
					st.removeTreeRecursive(numeros, st.getRoot());
				}
			}
		}
	}
}
