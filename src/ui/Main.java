package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	RaceControllerGUI controller;
	
	
	public Main() {
		controller = new RaceControllerGUI();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Race.fxml"));
		
		fxmlLoader.setController(controller);
		
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(controller.showImages());
		primaryStage.show();
		
		if (controller.changeImage()) {
			primaryStage.setScene(scene);
			primaryStage.setTitle("Basic Algorithms Race");
			primaryStage.show();
		}
	}

}
