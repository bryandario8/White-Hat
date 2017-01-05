/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Flores
 */
public class MenuInicio {

    Boolean state = false;
    StackPane rootPane;
    Button personas;
    Boolean panepersonas = false;
    Button cita;
    Boolean panecita = false;
    Button inventario;
    Boolean paneinventario = false;
    Button proveedores;
    Boolean paneproveedores=false;
    Button usuarios;
    Boolean paneusuarios=false;
    HBox botones1;
    Boolean exit = false;
    ImageView fondo;

    public MenuInicio() {
        this.rootPane = new StackPane();
        
        fondo = new ImageView();
        fondo.setImage(new Image("Img/fondo.jpg"));
        fondo.setFitWidth(Settings.SCENE_WIDTH + 20);
        fondo.setFitHeight(Settings.SCENE_HEIGHT + 20);
        rootPane.getChildren().add(fondo);
        
        this.personas = new Button("Pacientes");
        this.cita = new Button(" Cita ");
        this.inventario = new Button("Inventario");
        this.proveedores=new Button("Proveedores");
        usuarios=new Button("Usuarios");
        this.botones1 = new HBox();
        this.botones1.getChildren().addAll(this.personas, this.cita, this.inventario,this.proveedores,usuarios);
        this.botones1.setAlignment(Pos.CENTER);
        this.botones1.setSpacing(80);
        
        this.rootPane.getChildren().addAll(this.botones1);
        setupButton();
    }

    private void setupButton() {
        personas.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            panepersonas=true;
            }
        });

        cita.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            panecita = true;
            }
        });
        inventario.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            paneinventario = true;
            }
        });
        proveedores.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            paneproveedores = true;
            }
        });
        usuarios.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            paneusuarios = true;
            }
        });
    }

    public StackPane getRootPane() {
        return rootPane;
    }

    public Boolean getPanepersonas() {
        return panepersonas;
    }

    public Boolean getPanecita() {
        return panecita;
    }

    public Boolean getPaneinventario() {
        return paneinventario;
    }

    public void setPanepersonas(Boolean panepersonas) {
        this.panepersonas = panepersonas;
    }

    public void setPanecita(Boolean panecita) {
        this.panecita = panecita;
    }

    public void setPaneinventario(Boolean paneinventario) {
        this.paneinventario = paneinventario;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getExit() {
        return exit;
    }

    public Boolean getPaneproveedores() {
        return paneproveedores;
    }

    public void setPaneproveedores(Boolean paneproveedores) {
        this.paneproveedores = paneproveedores;
    }

    public Boolean getPaneusuarios() {
        return paneusuarios;
    }

    public void setPaneusuarios(Boolean paneusuarios) {
        this.paneusuarios = paneusuarios;
    }
    

}
