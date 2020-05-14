package ui;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import model.Structure;
import thread.AlgoritmThread;
import thread.ChronoThread;
import thread.CircleThread;

public class RaceControllerGUI {

	int hour = 0;
	int minute = 0;
	int second = 0;
	
	private boolean started = true;
	boolean running = false;
	
	private Structure st;
	
	public RaceControllerGUI() {
		st = new Structure();
	}
	
    @FXML
    private BorderPane principal;

    @FXML
    private TextField input;

    @FXML
    private Label timeKeeper;

    @FXML
    private ImageView image1;

    @FXML
	public Label timeArrayList;

    @FXML
    private ImageView image2;

    @FXML
	public Label TimeLinkedList;

    @FXML
    private ImageView image3;

    @FXML
	public Label timeABB;

    @FXML
    private RadioButton add;

    @FXML
    private ToggleGroup algorithms;

    @FXML
    private RadioButton search;

    @FXML
    private RadioButton delete;

    @FXML
    private RadioButton iterative;

    @FXML
    private ToggleGroup mode;

    @FXML
    private RadioButton recursive;

    @FXML
    private Circle BigCircle;

    @FXML
    private Circle SmallCircle;
    
    @FXML
    private Canvas canva;
    
    public void initialize() {
    	add.setToggleGroup(algorithms);
    	search.setToggleGroup(algorithms);
    	delete.setToggleGroup(algorithms);
    	
    	iterative.setToggleGroup(mode);
    	recursive.setToggleGroup(mode);
    	
    	BigCircle = new Circle(50);
    }
    
    @FXML
    void run(ActionEvent event) throws InterruptedException  {
    	char m = iterative.isSelected()?'I':'R';
    	char a = ' ';
    	if (add.isSelected()) {
			a = 'A';
		}else if (search.isSelected()) {
			a = 'S';
		}else if (delete.isSelected()) {
			a = 'D';
		}
    	int i = Integer.parseInt(input.getText());
    	
    	if (running == false) {
			setStarted(true);
			setRunning(true);
			chronometer();
			action(m, a, i);
			//setRad(BigCircle);
		}/*else if (running == true) {
			setStarted(false);
			setRunning(false);
		}*/
    }
    
    
    private void chronometer() {
		if (isStarted()) {
			ChronoThread ct = new ChronoThread(st, this, timeKeeper);
			ct.setDaemon(true);
			ct.start();
			
			ChronoThread c1 = new ChronoThread(st, this, timeArrayList);
			ChronoThread c2 = new ChronoThread(st, this, TimeLinkedList);
			ChronoThread c3 = new ChronoThread(st, this, timeABB);
			
			c1.setDaemon(true);
			c2.setDaemon(true);
			c3.setDaemon(true);
			
			c1.start();
			c2.start();
			c3.start();
		}
	}


    
    public Scene showImages() throws IOException {
    	FXMLLoader fxml = new FXMLLoader(getClass().getResource("Images.fxml"));
    	fxml.setController(this);
    	Parent root = fxml.load();
    	Scene scene = new Scene(root);
    	return scene;
    }
    
    public boolean changeImage() {
    	Image[] images = new Image[3]; 
    	for (int i = 0; i < 3; i++) {
    		images[i] = image(alertImage());
		}
    	
    	image1.setImage(images[0]);
    	image2.setImage(images[1]);
    	image3.setImage(images[2]);
    	
    	return true;
    	
    }
    
    public Image image(int n) {
    	Image img = null;
    	if (n == 1) {
    		img = new Image("images/Avatar1.jpeg");
		}else if(n == 2) {
			img = new Image("images/Avatar2.jpeg");
		}else if (n == 3) {
			img = new Image("images/Avatar3.jpeg");
		}else if (n == 4) {
			img = new Image("images/Avatar4.jpeg");
		}
    	return img;
    }
    
    public int alertImage() {
    	int number = 0;
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("THE AVATAR");
    	alert.setHeaderText("Choose an avatar for your race");
    	alert.setContentText("Choose your option.");

    	ButtonType buttonTypeOne = new ButtonType("One");
    	ButtonType buttonTypeTwo = new ButtonType("Two");
    	ButtonType buttonTypeThree = new ButtonType("Three");
    	ButtonType buttonTypeFour = new ButtonType("Four");
    	ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

    	alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree, buttonTypeFour, buttonTypeCancel);

    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get() == buttonTypeOne){
    	    number = 1;
    	} else if (result.get() == buttonTypeTwo) {
    	    number = 2;
    	} else if (result.get() == buttonTypeThree) {
    	    number = 3;
    	} else if (result.get() == buttonTypeFour) {
			number = 4;
    	}
    	
    	return number;
    }

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void action(char mode, char action, int input) throws InterruptedException {
	//	AlgoritmThread at1 = new AlgoritmThread(st, this, mode, action, 1, input);
//		AlgoritmThread at2 = new AlgoritmThread(st, this, mode, action, 2, input);
		AlgoritmThread at3 = new AlgoritmThread(st, this, mode, action, 3, input);
		
		//at1.setDaemon(true);
		//at1.setDaemon(true);
		//at1.setDaemon(true);
		
		//at1.start();
		//at2.start();
		at3.start();
		
		
	}
	
	private void setRad(Circle circle) {
		if (circle.getRadius() == 50) {
			for (int i = 5; i <= 40 & circle.getRadius() >= 10; i++) {
				circle.setRadius(circle.getRadius() - i);
			}
		}if (circle.getRadius() == 10) {
			for (int i = 5; i <= 40 & circle.getRadius() <= 50; i++) {
				circle.setRadius(circle.getRadius() + i);
			}
		}
	}
	public void upgrade() {
		setRad(BigCircle);
	}
	
}
