package com.example.extraclase;
import com.example.extraclase.Estudiante;

/**
 *
 * Clase estudiante es hija de filas, pues, para efectos del programa, los estudiantes son Filas mostradas en pantalla
 * Se aplica el concepto de abstraccion para colocar unicamente lo que me interesa de estudiante
 */
public class Estudiante extends Filas {
    /**
     * Estudiante hereda los atributos y metodos de Filas
     * Estudiante anade tres variables que son utilizadas para las columnas extra de las tablas
     */
    String promedioExamenes;
    String promedioFinal;

    String promedioProyectos;

    /**
     * Getters para acceder a estas variables
     * @return
     */
    public String getPromedioProyectos() {
        return promedioProyectos;
    }

    public String getPromedioExamenes() {
        return promedioExamenes;
    }

    public String getPromedioFinal() {
        return promedioFinal;
    }

    /**
     * Constructor principal de estudiante
     * @param fila fila del archivo csv, que contiene todos los atributos separados por coma
     */
    Estudiante(String fila) {
        super(fila);

        //Dependiendo del tipo de estudiante, se calculan los datos extra.

        if (this.tipoEstudiante.equals("A")) {


            promedioExamenes = String.valueOf((Float.parseFloat(this.promedioExamen) + Float.parseFloat(this.promedioQuices) + Float.parseFloat(this.promedioTareas)) / 3);
            float promedio = (Float.parseFloat(this.promedioExamen) + Float.parseFloat(this.promedioQuices) + Float.parseFloat(this.promedioTareas)) / 15;
            promedioFinal =  String.valueOf(Math.round(promedio)*5);
            promedioProyectos = "0";
        }
        else{
            promedioProyectos = String.valueOf((Float.parseFloat(this.notaProyecto1) + Float.parseFloat(this.notaProyecto2) + Float.parseFloat(this.notaProyecto3)) / 3);
            promedioExamenes = "0";
            float promedio = (Float.parseFloat(this.notaProyecto1) + Float.parseFloat(this.notaProyecto2) + Float.parseFloat(this.notaProyecto3)) / 15;
            promedioFinal = String.valueOf(Math.round(promedio)*5);
        }


    }

    /**
     * Constructor secundario utilizado para la Tabla de busqueda
     * @param carne Muestra el carne
     * @param nombre Muestra el nombre
     * @param tipo Muestra el tipo
     * @param nota Muestra la nota final
     */

    Estudiante(String carne, String nombre, String tipo, String nota){
            super(carne, nombre, tipo, nota);
            this.carne = carne;
            this.nombre = nombre;
            this.tipoEstudiante = tipo;
            this.promedioFinal = nota;
    }
}


