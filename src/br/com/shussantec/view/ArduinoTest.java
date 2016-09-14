package br.com.shussantec.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ArduinoTest extends Application{
 
    
    public static void main(String[] args) {
        Application.launch(ArduinoTest.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/br/com/shussantec/view/Comunication.fxml"));
        
        stage.setTitle("Arduino Comunication");
        stage.setScene(new Scene(root, 600, 300));
        stage.show();
    }
}
