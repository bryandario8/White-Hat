/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import Constantes.Settings;
import Escenarios.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Flores
 */
public class SceneOrganizer {

    Scene scene;
    Boolean state = true;
    Timeline timeline;
    MenuInicio menuInicio;
    Login login;
    SearchPerson searchperson;
    Cita cita;
    Inventario inventario;
    Proveedores proveedores;
    Usuarios usuarios;

    public SceneOrganizer(Stage stage) {
        menuInicio = new MenuInicio();
        cita = new Cita();
        login = new Login();
        searchperson = new SearchPerson(stage);
        inventario = new Inventario(stage);
        proveedores = new Proveedores();
        usuarios = new Usuarios(stage);
        login.setState(Boolean.TRUE);
        scene = new Scene(login.getRootPane(), Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        this.setupTimeline();
    }

    public Scene getScene() {
        return scene;
    }

    public void setupTimeline() {
        KeyFrame kf = new KeyFrame(Duration.millis(100), new changWindow());
        timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class changWindow implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (!login.getState()) {
                login.setState(true);
                menuInicio.setState(true);
                scene.setRoot(menuInicio.getRootPane());
                
            }
            if (menuInicio.getState()) {
                if (menuInicio.getPanepersonas()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPanepersonas(Boolean.FALSE);
                    scene.setRoot(searchperson.getRootPane());
                }
                if (menuInicio.getPanecita()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPanecita(Boolean.FALSE);
                    scene.setRoot(cita.getRootPane());

                }
                if (menuInicio.getPaneinventario()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPaneinventario(Boolean.FALSE);
                    scene.setRoot(inventario.getRootPane());

                }
                if (menuInicio.getPaneproveedores()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPaneproveedores(Boolean.FALSE);
                    scene.setRoot(proveedores.getRootPane());

                }
                if (menuInicio.getPaneusuarios()) {
                    menuInicio.setState(Boolean.FALSE);
                    menuInicio.setPaneusuarios(Boolean.FALSE);
                    scene.setRoot(usuarios.getRootPane());

                }

                if (menuInicio.getExit()) {
                    state = false;
                    System.exit(0);
                }
            }
            if (!searchperson.getState()) {
                searchperson.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getRootPane());
            }
            if (!cita.getState()) {
                cita.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getRootPane());
            }
            if (!inventario.getState()) {
                inventario.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getRootPane());
            }
            if (!proveedores.getState()) {
                proveedores.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getRootPane());
            }
            if (!usuarios.getState()) {
                usuarios.setState(true);
                menuInicio.setState(Boolean.TRUE);
                scene.setRoot(menuInicio.getRootPane());
            }
        }
    }

}
