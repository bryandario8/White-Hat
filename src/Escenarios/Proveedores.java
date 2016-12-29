/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Flores
 */
public class Proveedores {

    BorderPane rootPane;
    VBox lista;
    Label textnombre;
    TextField tf_nombre;
    Label textclave;
    TextField tf_clave;
    Button search;
    Button add;
    Button back;
    HBox hbox_search;
    HBox hbox_clave;
    Stage st;
    Label mensaje;
    HBox info;
    Pane pane;
    Image imagen = new Image("file:diente_vector_dos-270x250.png");
    ImageView imagenview = new ImageView(imagen);
    VBox datos = new VBox();
    VBox datosNuevo = new VBox();
    ScrollPane sc = new ScrollPane();
    VBox conteImagen = new VBox();
    Boolean state = true;
    Button agregarImagen;
    Button saveee;
    HBox temp1;
    Button edit;
    Button delete;

    public Proveedores() {
        rootPane = new BorderPane();
        lista = new VBox();
        hbox_search = new HBox();
        VBox temp_1 = new VBox();
        add = new Button("add");
        back = new Button("back");
        Image imagenButton = new Image("file:search.png");
        ImageView iVButton = new ImageView(imagenButton);
        iVButton.setFitHeight(imagenButton.getHeight() * 0.05);
        iVButton.setFitWidth(imagenButton.getWidth() * 0.05);
        search = new Button("", iVButton);
        tf_nombre = new TextField();

        mensaje = new Label();
        hbox_search.getChildren().addAll(search, tf_nombre, add, back);
        temp_1.getChildren().addAll(hbox_search, new Separator());
        temp_1.setAlignment(Pos.TOP_CENTER);
        rootPane.setTop(temp_1);
        // rootPane.setCenter(mensaje);

        HBox contenedora = new HBox();
        pane = new Pane();
        nuevoSuministro();
        llenarContenedor();
        Separator sepa = new Separator();
        sepa.setOrientation(Orientation.VERTICAL);
        contenedora.getChildren().addAll(sc);
        contenedora.setAlignment(Pos.CENTER);
        rootPane.setCenter(contenedora);
        tf_nombre.setMinWidth(Settings.SCENE_WIDTH - 110);
        metOnClick();
    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void nuevoSuministro() {
        Label ruc = new Label("Ruc: ");
        TextField tf_ruc = new TextField("");
        HBox conte1 = new HBox();
        conte1.getChildren().addAll(ruc, tf_ruc);
        Label nombre = new Label("Nombre: ");
        TextField tf_nombre = new TextField("");
        HBox conte2 = new HBox();
        conte2.getChildren().addAll(nombre, tf_nombre);
        Label direccion = new Label("Direccion: ");
        TextField tf_direccion = new TextField("");
        HBox conte3 = new HBox();
        conte3.getChildren().addAll(direccion, tf_direccion);
        Label telefono = new Label("Telefono: ");
        TextField tf_telefono = new TextField("");
        HBox conte4 = new HBox();
        conte4.getChildren().addAll(telefono, tf_telefono);
        Label email = new Label("Email: ");
        TextField tf_email = new TextField("");
        HBox conte5 = new HBox();
        conte5.getChildren().addAll(email, tf_email);
        datosNuevo.getChildren().addAll(conte1, conte2, conte3, conte4, conte5);
        datosNuevo.setAlignment(Pos.CENTER);
        //datosNuevo.setSpacing(100);

        saveee = new Button("Save");
        temp1 = new HBox();
        temp1.getChildren().addAll(saveee);
        temp1.setSpacing(20);
    }

    public void llenarContenedor() {
        edit = new Button("Edit");
        delete = new Button("Delete");
        HBox temp2=new HBox();
        temp2.getChildren().addAll(edit,delete);
        Label ruc = new Label("Ruc: ");
        Label contruc = new Label("");
        HBox conte1 = new HBox();
        conte1.getChildren().addAll(ruc, contruc);
        Label nombre = new Label("Nombre: ");
        Label contnombre = new Label("");
        HBox conte2 = new HBox();
        conte2.getChildren().addAll(nombre, contnombre);
        Label direccion = new Label("Direccion: ");
        Label contdireccion = new Label("");
        HBox conte3 = new HBox();
        conte3.getChildren().addAll(direccion, contdireccion);
        Label telefono = new Label("Telefono: ");
        Label conttelefono = new Label("");
        HBox conte4 = new HBox();
        conte4.getChildren().addAll(telefono, conttelefono);
        Label email = new Label("Email: ");
        Label contemail = new Label("");
        HBox conte5 = new HBox();
        conte5.getChildren().addAll(email, contemail);

        datos.getChildren().addAll(temp2,conte1, conte2, conte3, conte4);
        datos.setAlignment(Pos.CENTER);
        //datos.setSpacing(100);
        sc.setContent(datos);
        sc.setMinWidth(Settings.SCENE_WIDTH / 2);

        conteImagen.setAlignment(Pos.CENTER);
    }

    public void metOnClick() {
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            sc.setContent(datosNuevo);
            sc.setMinWidth(Settings.SCENE_WIDTH / 2);

            conteImagen.getChildren().clear();
            conteImagen.setSpacing(20);
            conteImagen.setAlignment(Pos.CENTER);
            }
        });
        search.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            sc.setContent(datos);
            sc.setMinWidth(Settings.SCENE_WIDTH / 2);
            conteImagen.getChildren().clear();
            conteImagen.setAlignment(Pos.CENTER);
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            state = false;
            }
        });
        edit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
           sc.setContent(datosNuevo);
            sc.setMinWidth(Settings.SCENE_WIDTH / 2);

            conteImagen.getChildren().clear();
            conteImagen.setSpacing(20);
            conteImagen.setAlignment(Pos.CENTER);
            }
        });

    }

}
