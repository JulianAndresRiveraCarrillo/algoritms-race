package thread;

import javafx.application.Platform;
import javafx.scene.control.Label;
import model.Structure;
import ui.RaceControllerGUI;

public class ChronoThread extends Thread {

	private Structure st;
	private RaceControllerGUI gui;
	private Label etiqueta;
	
	public ChronoThread(Structure st, RaceControllerGUI gui, Label time ) {
		this.st = st;
		this.gui = gui;
		etiqueta = time;
	}
	
	@Override
	public void run() {
		try {
			int num = 0;
			
			while(gui.isStarted()) {
				sleep(100);
				chrono(num);
			}
		} catch (Exception e) {
		System.err.println(e.getMessage());
		}
	}
	
	public void chrono(int n) {
		gui.setSecond(gui.getSecond() + 1);
		
		if (gui.getSecond() > 59) {
			gui.setSecond(0);
			gui.setMinute(gui.getMinute() + 1);
		}
	
		if (gui.getMinute() > 59) {
			gui.setMinute(0);
			gui.setHour(gui.getHour() + 1);
		}
		
		if (gui.getHour() > 24) {
			gui.setRunning(false);
		}
		
		String sec = "";
		String min = "";
		String hr = "";
		
		if (gui.getSecond() < 10) {
			sec = "0"+ gui.getSecond();
		}else {
			sec = String.valueOf(gui.getSecond());
		}
		
		if (gui.getMinute() <10) {
			min = "0" + gui.getMinute();
		}else {
			min = String.valueOf(gui.getMinute());
		}
		
		if (gui.getHour() <10) {
			hr = "0"+gui.getHour();
		}else {
			 hr = String.valueOf(gui.getHour());
		}
		
		String time = hr + ":" + min + ":" + sec;
		
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				etiqueta.setText(time);
			}
		});
	}
}
