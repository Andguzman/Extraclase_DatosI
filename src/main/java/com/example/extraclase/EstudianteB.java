package com.example.extraclase;

import com.example.extraclase.Estudiante;

/**
 * Estudiante B es hija de Estudiante
 */

public class EstudianteB extends Estudiante {
    EstudianteB(String fila) {
        super(fila);
    }
    @Override
    public String getPromedioProyectos() {
        return promedioProyectos;
    }

    /**
     * Polimorfismo del getter PromedioExamenes
     * Dado que Estudiante tipo B no tiene examenes, el promedio se trabaja como 0
     * @return
     */

    @Override
    public String getPromedioExamenes() {
        return "0";
    }
    @Override
    public String getPromedioFinal() {
        return promedioFinal;
    }
}
