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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Flores
 */
public class Login {
    Boolean state=false;
    StackPane rootPane;
    VBox lista;
    Label textnombre;
    TextField tf_nombre;
    Label textclave;
    TextField tf_clave;
    Button login;
    Button exit;
    HBox hbox_usuario;
    HBox hbox_clave;
    ImageView fondo;

    public Login() {
        rootPane = new StackPane();
        
        fondo = new ImageView();
        fondo.setImage(new Image("Img/fondo.jpg"));
        fondo.setFitWidth(Settings.SCENE_WIDTH + 20);
        fondo.setFitHeight(Settings.SCENE_HEIGHT + 20);
        rootPane.getChildren().add(fondo);
        
        lista = new VBox();
        textnombre = new Label();
        tf_nombre = new TextField();
        textclave = new Label();
        tf_clave = new TextField();
        
        login = new Button("Login");
        exit = new Button("Exit");
        
        hbox_usuario = new HBox();
        hbox_usuario.getChildren().addAll(textnombre, tf_nombre);
        hbox_usuario.setAlignment(Pos.CENTER);
        hbox_clave = new HBox();
        hbox_clave.getChildren().addAll(textclave, tf_clave);
        hbox_clave.setAlignment(Pos.CENTER);
        seteo();
        HBox contenedor=new HBox();
        contenedor.getChildren().addAll(login,exit);
        contenedor.setAlignment(Pos.CENTER);
        lista.getChildren().addAll(hbox_usuario, hbox_clave, contenedor);
        lista.setAlignment(Pos.CENTER);
        rootPane.getChildren().addAll(lista);
        metOnClick();
    }

    public void seteo() {
        textnombre.setText("Usuario: ");
        textnombre.setFont(new Font("helvetica", 20.0));
        textnombre.setTextFill(Color.WHITE);
        
        tf_nombre.setPromptText("Ingrese su usuario");
        
        textclave.setText("Clave: ");
        textclave.setFont(new Font("helvetica", 20.0));
        textclave.setTextFill(Color.WHITE);
        
        tf_clave.setPromptText("Ingrese su clave");
    }

    public StackPane getRootPane() {
        return rootPane;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    public void metOnClick() {
        login.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            state=false;
            }
        });
        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            System.exit(0);
            }
        });
        

    }

}
