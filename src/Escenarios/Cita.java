/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Escenarios;

import Constantes.Settings;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Flores
 */
public class Cita {

    Date fecha = new Date();
    BorderPane rootPane;  //*
    Boolean state = true;  //*
    VBox lista;
    Label textnombre;
    TextField tf_nombre;
    Label textclave;
    TextField tf_clave;
    Button search;  // *
    Button back;   //*
    Button back1;  //*
    Button back2;
    Button backPrincipal;  // *
    HBox hbox_search;
    HBox hbox_clave;
    Stage st;
    Label mensaje;
    HBox info;
    GridPane grid;
    Image imagen = new Image("file:plo.png");
    ImageView imagenview = new ImageView(imagen);
    VBox datos = new VBox();  //*
    VBox datosNuevo = new VBox();
    ScrollPane sc = new ScrollPane();  //*
    VBox contePaciente = new VBox();  //*
    VBox pacienteCita;
    
    HBox botones1;  //*
    Button citaActual;  //*
    Button crearCita;  //*
    DatePicker tf_fecha;
    LocalDate fechaElegida;
    ComboBox tf_hora;
    VBox temp_1;  //*
    VBox contenedora;  //*
    VBox contenedora3;  //*
    VBox contenedora4; 
    HBox contenedora2;  //*
    HBox menuIni;
    HBox menuSalvar;
    VBox rece;  //*
    VBox deta;  //*
    VBox exa;  //*
    Button detalles;  //*
    Button receta;  //*
    Button examen;  //*
    Button consentimiento; //*
    Button realizada;   
    Button iniciar;
    Button agregar;
    Button adelantar;
    Button postergarAntes;
    Button postergarDespues;
    Button completar;
    ImageView fondo;
    int filas;
    String dia;
    String hora;
    String paciente;
    public Cita() {
        rootPane = new BorderPane();
        
        fondo = new ImageView();
        fondo.setImage(new Image("Img/fondo.jpg"));
        fondo.setFitWidth(Settings.SCENE_WIDTH + 20);
        fondo.setFitHeight(Settings.SCENE_HEIGHT + 20);
        //rootPane.getChildren().add(fondo);
        
        lista = new VBox();
        cita();
        crearCita();
        menuCitas();
        citaactual();
        metOnClick();
        
        

    }

    private void menuCitas() {
        this.citaActual = new Button("Cita actual");
        this.crearCita = new Button("Crear cita");
        backPrincipal = new Button("Back");
        this.botones1 = new HBox();
        this.botones1.getChildren().addAll(this.citaActual, this.crearCita, backPrincipal);
        this.botones1.setAlignment(Pos.CENTER);
        this.botones1.setSpacing(80);
        rootPane.getChildren().add(fondo);
        this.rootPane.setCenter(this.botones1);

    }

    private void cita(){
        VBox contePaciente3 = new VBox();
        pacienteCita = new VBox(); 
        menuIni = new HBox();
        
        
        Label estadoCita = new Label("Proxima Cita ");
        Label textDia = new Label("Dia: ");
        Label textHora = new Label("Hora: ");
        Label textPaciente = new Label("Paciente: ");
        contePaciente3.getChildren().addAll(estadoCita, textDia, textHora, textPaciente);
        contePaciente3.setAlignment(Pos.CENTER);
        back1 = new Button(" < Back ");
        adelantar = new Button(" Adelantar ");
        iniciar = new Button(" Iniciar > ");
        postergarAntes = new Button(" Postergar ");
        menuIni.getChildren().addAll(back1,adelantar,iniciar,postergarAntes);    // Adelantar--> antes de la hora
        menuIni.setSpacing(10);
        menuIni.setAlignment(Pos.BOTTOM_CENTER);
        //pacienteContenido();
                                                        // Iniciar --> en hora
                                                                            // Postergar --> siempre
        pacienteCita.setAlignment(Pos.CENTER);
        pacienteCita.setSpacing(10);
        pacienteCita.getChildren().addAll(contePaciente3,menuIni);
        
    }
    private void citaactual() {
        back2 = new Button(" < Back ");
        VBox contePaciente2 = new VBox();
        contenedora3 = new VBox();
        detalles = new Button(" Detalles ");
        receta = new Button(" Receta ");
        examen = new Button(" Examen + ");
        consentimiento = new Button(" Consentimmiento ");
        realizada = new Button(" Finalizar Consulta ");
        completar = new Button(" Completar datos ");
        postergarDespues = new Button(" Postergar ");
        
        Label estadoCita = new Label("Proxima Cita ");
        Label textDia = new Label("Dia: ");
        Label textHora = new Label("Hora: ");
        Label textPaciente = new Label("Paciente: ");
        contePaciente2.getChildren().addAll(estadoCita, textDia, textHora, textPaciente);
        contePaciente2.setAlignment(Pos.CENTER);
        contenedora2 = new HBox();
        VBox botones1 = new VBox();
        botones1.getChildren().addAll(detalles, receta);
        botones1.setAlignment(Pos.CENTER);
        botones1.setSpacing(20);
        VBox botones2 = new VBox();
        botones2.setAlignment(Pos.CENTER);
        botones2.setSpacing(20);
        botones2.getChildren().addAll(examen, consentimiento);
        HBox temp3=new HBox();
        temp3.getChildren().addAll(botones1,botones2);
        contenedora2.getChildren().addAll(contePaciente2,temp3);
        contenedora2.setSpacing(300);
        //contenedora2.setAlignment(Pos.CENTER);
        contenedora3.getChildren().addAll(contenedora2, new Separator());
        contenedora3.setAlignment(Pos.TOP_LEFT);
        
        deta=new VBox();
        Label titulo3 = new Label("Detalles");
        TextArea ta_detalles = new TextArea("");
        ta_detalles.setMinHeight(200);
        deta.getChildren().addAll(titulo3, ta_detalles);
        
        rece = new VBox();
        Label titulo2 = new Label("Receta");
        TextArea ta_receta = new TextArea("");
        ta_receta.setMinHeight(200);
        rece.getChildren().addAll(titulo2, ta_receta);
        
        exa=new VBox();
        Label titulo4 = new Label("Examenes complementario");
        TextArea ta_examenes = new TextArea("");
        ta_examenes.setMinHeight(200);
        exa.getChildren().addAll(titulo4, ta_examenes);
        
        menuSalvar = new HBox();
        menuSalvar.setAlignment(Pos.CENTER_RIGHT);
        menuSalvar.setSpacing(20);
        menuSalvar.setPadding(new Insets(10,10,10,10));
        Separator sepa = new Separator();
        sepa.setOrientation(Orientation.VERTICAL);
        menuSalvar.getChildren().addAll(back2,sepa,completar,postergarDespues,realizada);
        
    }

    private void crearCita() {
        VBox  contePaciente1 = new VBox();
        
        hbox_search = new HBox();
        temp_1 = new VBox();
        back = new Button("< Back");
        Image imagenButton = new Image("file:search.png");
        ImageView iVButton = new ImageView(imagenButton);
        iVButton.setFitHeight(imagenButton.getHeight() * 0.05);
        iVButton.setFitWidth(imagenButton.getWidth() * 0.05);
        search = new Button("", iVButton);
        tf_nombre = new TextField();

        mensaje = new Label();
        hbox_search.getChildren().addAll(search, tf_nombre, back);
        temp_1.getChildren().addAll(hbox_search, new Separator());
        temp_1.setAlignment(Pos.TOP_CENTER);

        contenedora = new VBox();
        
        Label estadoCita = new Label("Proxima Cita ");
        Label textDia = new Label("Dia: ");
        Label textHora = new Label("Hora: ");
        Label textPaciente = new Label("Paciente: ");
        contePaciente1.getChildren().addAll(estadoCita, textDia, textHora, textPaciente);
        contePaciente1.setAlignment(Pos.CENTER);
        Separator sepa = new Separator();
        sepa.setOrientation(Orientation.VERTICAL);
        Label titulo_1 = new Label("Seleccione un paciente y fecha de la cita");
        Label fecha = new Label("Fecha(dd/mm/yyyy): ");
        tf_fecha = new DatePicker();
        HBox conte1 = new HBox();
        agregar = new Button("Agregar");
        Label hora = new Label("Hora(hh:mm): ");
        tf_hora = new ComboBox();
        llenarComboBoxHora();
        tf_hora.setPromptText("Horas Disponibles");
        tf_hora.setEditable(true);
        
        conte1.getChildren().addAll(fecha, tf_fecha, hora, tf_hora, agregar);
        llenarContenedor();
        contenedora.getChildren().addAll(titulo_1, conte1, this.mensaje, sc, sepa, contePaciente1);
        contenedora.setAlignment(Pos.CENTER);

        tf_nombre.setMinWidth(Settings.SCENE_WIDTH - 80);
        
    }

    private void llenarComboBoxHora(){
        tf_hora.getItems().addAll("09:00","09:15","09:30","09:45","10:00","10:15","10:30","10:45","11:00","11:15","11:30","11:45",
                "12:00","12:15","12:30","12:45","14:00","14:15","14:30","14:45","15:00","15:15","15:30","15:45","16:00","16:15","16:30","16:45",
                "17:00","17:15","17:30","17:45","18:00","18:15","18:30","18:45","19:00","19:15");
        /*int hora = 9;
        for(int i=0,j=0; hora<17; i++,j+=5){
            tf_hora.getItems().add(hora+":"+i+j);
            if(i==1){ i++; j=0; }
            if(i==4){ i=0; j=0; }
        }*/
    }
    public void llenarContenedor() {
        grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.add(new Label("N. "), 0, 0);
        grid.add(new Label("Fecha"), 1, 0);
        grid.add(new Label("Hora"), 2, 0);
        grid.add(new Label("Cedula"), 3, 0);
        grid.add(new Label("Nombre"), 4, 0);
        grid.add(new Label("Duracion"), 5, 0);
        //grid.add(new Button("Confirmar"), 5, 0);
        filas=0;
        
        sc.setContent(grid);
        sc.setMinWidth(Settings.SCENE_WIDTH / 2);
        //VBox conteImagen = new VBox();
        
    }
    
    public BorderPane getRootPane() {
        return rootPane;
    }

    public Boolean getState() {
        return state;
    }

    public TextField getTf_clave() {
        return tf_clave;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    
    public Pane getPacienteContenido(){
        return contePaciente;
    }

    private void metOnClick() {
        search.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                //sc.setContent(datos);
                sc.setMinWidth(Settings.SCENE_WIDTH / 2);
                contePaciente.setAlignment(Pos.CENTER);
            }
        }
        );
        backPrincipal.setOnAction(new EventHandler<ActionEvent>() {
            //Boolean stateN = state;
            @Override
            public void handle(ActionEvent t) {
                state = false;
            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.getChildren().add(fondo);
                rootPane.setCenter(botones1);
            }
        });
        back1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.getChildren().add(fondo);
                rootPane.setCenter(botones1);
            }
        });
        back2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.getChildren().add(fondo);
                rootPane.setCenter(botones1);
            }
        });
        crearCita.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.setTop(temp_1);
                rootPane.setCenter(contenedora);
                
            }
        });
        citaActual.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.setCenter(pacienteCita);
            }
        });
        iniciar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.setTop(contenedora3);
                rootPane.setBottom(menuSalvar);
            }
        });
        adelantar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootPane.getChildren().clear();
                rootPane.setTop(contenedora3);
                rootPane.setBottom(menuSalvar);
            }
        });
        postergarAntes.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                // mover cita a Pendiente o asignar nuevo horario disponible automáticamente
            }
        });
        postergarDespues.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                // mover cita a Pendiente o asignar nuevo horario disponible automáticamente
            }
        });
        detalles.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),deta,realizada);
            }
        });
        receta.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
             contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),rece,realizada);
            }
        });
        examen.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
             contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),exa,realizada);
            }
        });
        agregar.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent t) throws NullPointerException{
                try{
                    if(!(fechaElegida.toString().isEmpty()) && tf_fecha.getValue() != null && 
                            !(tf_hora.getValue().toString().isEmpty()) && tf_hora.getValue() != null){
                        filas++;
                        grid.add(new Label(filas+". "), 0, filas);
                        grid.add(new Label(fechaElegida.toString()), 1, filas);
                        grid.add(new Label(tf_hora.getValue().toString()), 2, filas);
                        grid.add(new TextField(""), 3, filas);
                        grid.add(new TextField(""), 4, filas);
                        grid.add(new TextField(""), 5, filas);
                        grid.add(new Button("Confirmar"), 6, filas);
                        grid.add(new Button("Eliminar"), 7, filas);

                        //tf_hora.getItems().remove(tf_hora.getValue());   //elimina hora elegida (Para impelmentarlo debe hacerse por día)
                        tf_hora.setValue(null);
                        tf_fecha.setValue(null);

                    }
                }catch(NullPointerException e){
                    
                }
            }
            
        });
        tf_fecha.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                fechaElegida = tf_fecha.getValue();
            }
            
        });
        consentimiento.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
            }
        });
        /*search.setOnAction(e -> 
            sc.setContent(datos);
            sc.setMinWidth(Settings.SCENE_WIDTH / 2);
            conteImagen.setAlignment(Pos.CENTER);

        });
        backPrincipal.setOnAction(e -> {
            this.state = false;

        });
        back.setOnAction(e -> {
            rootPane.getChildren().clear();
            this.rootPane.setCenter(this.botones1);

        });
        back1.setOnAction(e -> {
            rootPane.getChildren().clear();
            this.rootPane.setCenter(this.botones1);

        });
        crearCita.setOnAction(e -> {
            rootPane.getChildren().clear();
            rootPane.setTop(temp_1);
            rootPane.setCenter(contenedora);
        });
        citaActual.setOnAction(e -> {
            rootPane.getChildren().clear();

            rootPane.setTop(contenedora3);
        });
        detalles.setOnAction(e -> {
            contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),deta,realizada);
        });
        receta.setOnAction(e -> {
             contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),rece,realizada);
        });
        examen.setOnAction(e -> {
             contenedora3.getChildren().clear();
            contenedora3.getChildren().addAll(contenedora2, new Separator(),exa,realizada);
        });
        consentimiento.setOnAction(e -> {
            
        });*/
    }

}
