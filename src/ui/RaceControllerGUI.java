package ui;

import java.io.IOException;
import java.util.Optional;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RaceControllerGUI {

	
	public RaceControllerGUI() {
		// TODO Auto-generated constructor stub
	}
	
	 @FXML
	    private BorderPane principal;
	@FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    void run(ActionEvent event) throws IOException {
    	
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
		}else {
    	    
    	}
    	
    	return number;
    }
    
}
