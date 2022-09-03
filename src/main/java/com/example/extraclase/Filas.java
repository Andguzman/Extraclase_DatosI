package com.example.extraclase;
import com.example.extraclase.Estudiante;

/**
 *Clase padre (herencia)
 * Se crea la clase Filas que corresponde a los datos que son mostrados en la tabla
 *
 */
public class Filas {
    /**
     * Se declaran las variables que toman las distintas columnas
     * Son atributos de la clase
     */
    String carne;
    String nombre;
    String correo;
    String telefono;
    String nickname;
    String tipoEstudiante;
    String promedioExamen;
    String promedioQuices;
    String promedioTareas;
    String notaProyecto1;
    String notaProyecto2;
    String notaProyecto3;


    /**
     * Primer constructor que toma una fila leida del archivo csv, separa los valores y los asigna
     * @param fila fila leida del archivo csv
     */

    Filas(String fila){
        String[] datos = fila.split(",");
        this.carne = datos[0];
        this.nombre = datos[1];
        this.correo = datos[2];
        this.telefono = datos[3];
        this.nickname = datos[4];
        this.tipoEstudiante = datos[5];
        this.promedioExamen = datos[6];
        this.promedioQuices = datos[7];
        this.promedioTareas = datos[8];
        this.notaProyecto1 = datos[9];
        this.notaProyecto2 = datos[10];
        this.notaProyecto3 = datos[11];


    }

    /**
     * Segundo constructor (overload), no requiere de una fila con todos los datos. Solo los importantes para la tabla 2
     *
     * @param carne Muestra el carne en la tabla
     * @param nombre Muestra el nombre
     * @param tipo Muestra el tipo de estudiante
     * @param nota Muestra la nota final
     */
    Filas (String carne, String nombre, String tipo, String nota){
        this.carne = carne;
        this.nombre = nombre;
        this.tipoEstudiante = tipo;
    }

    /**
     * Getters para que sea posible acceder a los datos.
     * Se utiliza encapsulacion para separar metodos de atributos en una sola clase.
     * Los getters son metodos
     * @return
     */
    public String getCarne() {
        return carne;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTipoEstudiante() {
        return tipoEstudiante;
    }

    public String getPromedioExamen() {
        return promedioExamen;
    }

    public String getPromedioQuices() {
        return promedioQuices;
    }

    public String getPromedioTareas() {
        return promedioTareas;
    }

    public String getNotaProyecto1() {
        return notaProyecto1;
    }

    public String getNotaProyecto2() {
        return notaProyecto2;
    }

    public String getNotaProyecto3() {
        return notaProyecto3;
    }

}
