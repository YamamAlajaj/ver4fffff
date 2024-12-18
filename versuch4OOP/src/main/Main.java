package main;

import gui.Teppich.BodenbelaegeControl;
import gui.guiTeppiche.TeppichControl;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeppichControl(primaryStage);
		Stage fensterTeppich = new Stage(); 
	    new  BodenbelaegeControl(fensterTeppich);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}