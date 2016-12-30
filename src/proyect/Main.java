/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Flores
 */
public class Main extends Application {
    
    SceneOrganizer organizer;
    @Override
    public void start(Stage primaryStage) {
        organizer = new SceneOrganizer(primaryStage);
        primaryStage.setScene(organizer.getScene());
        primaryStage.setTitle("Clinica Odontologica");
       // primaryStage.getIcons().add(new Image("file:shark-icon-png-4.png"));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
