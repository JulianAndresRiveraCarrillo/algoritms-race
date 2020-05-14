package thread;

import javafx.application.Platform;
import javafx.scene.shape.Circle;
import model.Structure;
import ui.RaceControllerGUI;

public class CircleThread extends Thread{

	private Structure st;
	private RaceControllerGUI gui;
	
	private Circle circle;
	
	public CircleThread(Structure st, RaceControllerGUI gui, Circle bigCircle) {
		this.st = st;
		this.gui = gui;
		circle = bigCircle;
	}
	
	public void run() {
		
		while (gui.isStarted()) {
			try {
				Platform.runLater(new Runnable() {
					
					@Override
					public void run() {
						gui.upgrade();
					}
				});
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/*private void setRad() {
		if (circle.getRadius() == 50) {
			for (int i = 5; i <= 40 & circle.getRadius() >= 10; i++) {
				circle.setRadius(circle.getRadius() - i);
			}
		}if (circle.getRadius() == 10) {
			for (int i = 5; i <= 40 & circle.getRadius() <= 50; i++) {
				circle.setRadius(circle.getRadius() + i);
			}
		}
	}*/
}
