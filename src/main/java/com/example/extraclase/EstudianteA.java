package com.example.extraclase;

import com.example.extraclase.Estudiante;

/**
 * Estudiante A es hija de Estudiante
 */
public class EstudianteA extends Estudiante {
    String promedioExamenes = String.valueOf((Float.parseFloat(this.promedioExamen) + Float.parseFloat(this.promedioQuices) + Float.parseFloat(this.promedioTareas))/3);

    public String getPromedioExamenes() {
        return promedioExamenes;
    }

    EstudianteA(String fila) { // Constructor
        super(fila);



    }

    /**
     * Polimorfismo del getter PromedioProyectos
     * Dado que Estudiante tipo A no tiene proyectos, el promedio se trabaja como 0
     * @return
     */
    @Override
    public String getPromedioProyectos() {
        return "0";
    }

    public String getPromedioFinal() {
        return promedioFinal;
    }
}