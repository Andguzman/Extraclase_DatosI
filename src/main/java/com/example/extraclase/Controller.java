package com.example.extraclase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase controlador para el hello-view que contiene la interfaz grafica
 */
public class Controller implements Initializable {

    boolean archivo_cargado = false;
    int filas = 0;

    /**
     *
     * Se declaran las tablas que son mostradas en pantalla
     * Para el caso de las columnas, se indica el objeto del que tomaran el dato y el tipo de dato a tomar
     */
    @FXML
    private TableView<Estudiante> TablaCompleta;

    @FXML
    private TableView<Estudiante> TablaBuscador;

    @FXML
    private TableColumn<Estudiante, String> T1;

    @FXML
    private TableColumn<Estudiante, String> T2;

    @FXML
    private TableColumn<Estudiante, String> T3;

    @FXML
    private TableColumn<Estudiante, String> T4;

    @FXML
    private TableColumn<Estudiante, String> C1;

    @FXML
    private TableColumn<Estudiante, String> C2;

    @FXML
    private TableColumn<Estudiante, String> C3;

    @FXML
    private TableColumn<Estudiante, String> C4;
    @FXML
    private TableColumn<Estudiante, String> C5;
    @FXML
    private TableColumn<Estudiante, String> C6;
    @FXML
    private TableColumn<Estudiante, String> C7;
    @FXML
    private TableColumn<Estudiante, String> C8;
    @FXML
    private TableColumn<Estudiante, String> C9;
    @FXML
    private TableColumn<Estudiante, String> C10;
    @FXML
    private TableColumn<Estudiante, String> C11;
    @FXML
    private TableColumn<Estudiante, String> C12;
    @FXML
    private TableColumn<Estudiante, String> C13;
    @FXML
    private TableColumn<Estudiante, String> C14;
    @FXML
    private TableColumn<Estudiante, String> C15;
    @FXML
    private TextField Buscador; //Buscador es el cuadro de texto donde se colocan las busquedas

    /**
     *  Override de initialize, para colocar los atributos que van a tomar las celdas de los objetos cuando estos se creen
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            T1.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("carne"));
            T2.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
            T3.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("tipoEstudiante"));
            T4.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioFinal"));


            C1.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("carne"));
            C2.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nombre"));
            C3.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("correo"));
            C4.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("telefono"));
            C5.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("nickname"));
            C6.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("tipoEstudiante"));
            C7.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioExamen"));
            C8.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioQuices"));
            C9.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioTareas"));
            C10.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("notaProyecto1"));
            C11.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("notaProyecto2"));
            C12.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("notaProyecto3"));
            C13.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioExamenes"));
            C14.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioProyectos"));
            C15.setCellValueFactory(new PropertyValueFactory<Estudiante, String>("promedioFinal"));

    }

    /**
     * Funcion que se llama cuando el boton cargar archivo se clica
     *
     * @param event evento del boton
     */
    @FXML
    public void cargarclick(ActionEvent event) { //click del boton buscar


        System.out.println("Boton presionado");
        FileChooser fc = new FileChooser(); //Abre el explorador de archivos

        fc.getExtensionFilters().addAll(
                new ExtensionFilter("CSV Files", "*.csv") //Solo acepta archivos tipo .csv
        );

        File selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null){ //Si se selecciona un archivo


            System.out.println("Se ha cargado " + selectedFile.getName()); //Muestra en la consola el archivo cargado
            try{
                archivo_cargado = true;
                BufferedReader br = new BufferedReader(new FileReader(selectedFile.getAbsolutePath()));
                String line = br.readLine();
                Filas fila1 = new Filas(line);
                C1.setText(fila1.carne);
                C2.setText(fila1.nombre);
                C3.setText(fila1.correo);
                C4.setText(fila1.telefono);
                C5.setText(fila1.nickname);
                C6.setText(fila1.tipoEstudiante);
                C7.setText(fila1.promedioExamen);
                C8.setText(fila1.promedioQuices);
                C9.setText(fila1.promedioTareas);
                C10.setText(fila1.notaProyecto1);
                C11.setText(fila1.notaProyecto2);
                C12.setText(fila1.notaProyecto3);
                C13.setText("Promedio Examenes");
                C14.setText("Promedio Proyectos");
                C15.setText("Nota final");

                while((line = br.readLine()) != null) { //Crea los objetos Estudiante leyendo del archivo csv
                    filas ++;


                    Estudiante estudiante = new Estudiante(line);
                    if (estudiante.tipoEstudiante.equals("A")){
                        EstudianteA alumno = new EstudianteA(line); //Se crean las instancias de la clase EstudianteA
                        System.out.println(alumno.promedioExamenes);
                    }

                    ObservableList<Estudiante> estudiantes = TablaCompleta.getItems();
                    estudiantes.add(estudiante);
                    TablaCompleta.setItems(estudiantes);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Esta funcion se llama cuando se intenta realizar una busqueda
     *
     * @param event evento del boton
     */
    public void buscarclick(ActionEvent event){

        if (archivo_cargado){
            for (int i = 0; i < filas; i++){ //Ciclo for que busca el carne en la columna correspondiente

                if (Buscador.getText().equals(C1.getCellData(i))){ //Cuando encuentra el carne, se asignan los valores a la tabla
                    T1.setText("Carne");
                    T2.setText("Nombre y apellido");
                    T3.setText("Tipo de Estudiante");
                    T4.setText("Nota final");
                    Estudiante estudiante = new Estudiante(C1.getCellData(i), C2.getCellData(i), C6.getCellData(i), C15.getCellData(i)); //Se crean instancias de Estudiante
                    ObservableList<Estudiante> estudiantes2 = TablaBuscador.getItems();
                    estudiantes2.add(estudiante);
                    TablaBuscador.setItems(estudiantes2);
                }

            }

        }



    }
}