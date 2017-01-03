/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Flores
 */
public class SearchPerson {

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
    Image imagen = new Image("file:plo.png");
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
    ImageView fondo;

    public SearchPerson(Stage stage) {
        rootPane = new BorderPane();
        
        fondo = new ImageView();
        fondo.setImage(new Image("Img/fondo.jpg"));
        fondo.setFitWidth(Settings.SCENE_WIDTH + 20);
        fondo.setFitHeight(Settings.SCENE_HEIGHT + 20);
        rootPane.getChildren().add(fondo);
        
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

        st = stage;
        mensaje = new Label();
        hbox_search.getChildren().addAll(search, tf_nombre, add, back);
        temp_1.getChildren().addAll(hbox_search, new Separator());
        temp_1.setAlignment(Pos.TOP_CENTER);
        rootPane.setTop(temp_1);
        // rootPane.setCenter(mensaje);
        
        HBox contenedora = new HBox();
        pane = new Pane();
        nuevoPaciente();
        llenarContenedor();
        Separator sepa = new Separator();
        sepa.setOrientation(Orientation.VERTICAL);
        contenedora.getChildren().addAll(sc, sepa, conteImagen);
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

    public void nuevoPaciente() {
        Label cedula = new Label("Cedula: ");
        TextField tf_cedula = new TextField("");
        HBox conte1 = new HBox();
        conte1.getChildren().addAll(cedula, tf_cedula);
        Label nombre = new Label("Nombre: ");
        TextField tf_nombre = new TextField("");
        HBox conte2 = new HBox();
        conte2.getChildren().addAll(nombre, tf_nombre);
        Label apellido = new Label("Apellido");
        TextField tf_apellido = new TextField("");
        HBox conte3 = new HBox();
        conte3.getChildren().addAll(apellido, tf_apellido);
        Label direccion = new Label("Direccion: ");
        TextField tf_direccion = new TextField("");
        HBox conte4 = new HBox();
        conte4.getChildren().addAll(direccion, tf_direccion);
        Label fechadenacimiento = new Label("Fecha de nacimiento: ");
        TextField tf_fechanacimiento = new TextField("");
        HBox conte5 = new HBox();
        conte5.getChildren().addAll(fechadenacimiento, tf_fechanacimiento);
        Label estadocivil = new Label("Estado civil: ");
        TextField tf_estadocivil = new TextField("");
        HBox conte6 = new HBox();
        conte6.getChildren().addAll(estadocivil, tf_estadocivil);
        Label sexo = new Label("Sexo: ");
        TextField tf_sexo = new TextField("");
        HBox conte7 = new HBox();
        conte7.getChildren().addAll(sexo, tf_sexo);
        Label email = new Label("Email: ");
        TextField tf_email = new TextField("");
        HBox conte8 = new HBox();
        conte8.getChildren().addAll(email, tf_email);
        datosNuevo.getChildren().addAll(conte1, conte2, conte3, conte4, conte5, conte6, conte7, conte8);
        datosNuevo.setAlignment(Pos.CENTER);
        //datosNuevo.setSpacing(100);
        agregarImagen = new Button("Agregar foto");

        saveee = new Button("Save");
        temp1 = new HBox();
        temp1.getChildren().addAll(agregarImagen, saveee);
        temp1.setSpacing(20);
    }

    public void llenarContenedor() {
        edit = new Button("Edit");
        delete = new Button("Delete");
        HBox temp2=new HBox();
        temp2.getChildren().addAll(edit,delete);
        Label cedula = new Label("Cedula: ");
        Label contCedula = new Label("");
        HBox conte1 = new HBox();
        conte1.getChildren().addAll(cedula, contCedula);
        Label nombre = new Label("Nombre: ");
        Label contNombre = new Label("");
        HBox conte2 = new HBox();
        conte2.getChildren().addAll(nombre, contNombre);
        Label apellido = new Label("Apellido");
        Label contApellido = new Label("");
        HBox conte3 = new HBox();
        conte3.getChildren().addAll(apellido, contApellido);
        Label direccion = new Label("Direccion: ");
        Label contDireccion = new Label("");
        HBox conte4 = new HBox();
        conte4.getChildren().addAll(direccion, contDireccion);
        Label fechadenacimiento = new Label("Fecha de nacimiento: ");
        Label contFechadenacimiento = new Label("");
        HBox conte5 = new HBox();
        conte5.getChildren().addAll(fechadenacimiento, contFechadenacimiento);
        Label estadocivil = new Label("Estado civil: ");
        Label contEstadocivil = new Label("");
        HBox conte6 = new HBox();
        conte6.getChildren().addAll(estadocivil, contEstadocivil);
        Label sexo = new Label("Sexo: ");
        Label contSexo = new Label("");
        HBox conte7 = new HBox();
        conte7.getChildren().addAll(sexo, contSexo);
        Label email = new Label("Email: ");
        Label contEmail = new Label("");
        HBox conte8 = new HBox();
        conte8.getChildren().addAll(email, contEmail);
        TextArea ta_tratamiento =new TextArea("");
        ta_tratamiento.setEditable(false);
        Label trata=new Label("Tratamientos");
        datos.getChildren().addAll(temp2,conte1, conte2, conte3, conte4, conte5, conte6, conte7, conte8,trata,ta_tratamiento);
        datos.setAlignment(Pos.CENTER);
        //datos.setSpacing(100);
        sc.setContent(datos);
        sc.setMinWidth(Settings.SCENE_WIDTH / 2);
        Image imagen = new Image("file:plo.png");
        imagenview = new ImageView(imagen);
        conteImagen.getChildren().addAll(imagenview);
        conteImagen.setAlignment(Pos.CENTER);
    }

    public void metOnClick() {
        add.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            sc.setContent(datosNuevo);
            sc.setMinWidth(Settings.SCENE_WIDTH / 2);

            conteImagen.getChildren().clear();
            conteImagen.getChildren().addAll(imagenview, temp1);
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
            conteImagen.getChildren().addAll(imagenview);
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
            conteImagen.getChildren().addAll(imagenview, temp1);
            conteImagen.setSpacing(20);
            conteImagen.setAlignment(Pos.CENTER);
            }
        });
        this.agregarImagen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Buscar Imagen");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Images", "*.*"),
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File imgFile = fileChooser.showOpenDialog(st);
            if (imgFile != null) {
                mensaje.setText(imgFile.getAbsolutePath());
            }
            }
        });
    }

}
