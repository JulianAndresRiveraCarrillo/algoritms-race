package thread;

import model.Structure;
import ui.RaceControllerGUI;

public class ChronoThread extends Thread {

	private Structure st;
	private RaceControllerGUI gui;
	
	public ChronoThread(Structure st, RaceControllerGUI gui) {
		this.st = st;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		boolean stop = false;
		while (!stop) {
			long time = System.currentTimeMillis();
			
		}
	}
	
	
}
