package Modelo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Persona {
    private String nombre, apellido, dptoResidencia;
    private byte cantHijos;
    private int idPersona;
    LocalDate fechaNac;
    LinkedList<Vehiculo> vehiculo = new LinkedList<>();

    public Persona(int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos,
                   LocalDate fechaNac, LinkedList<Vehiculo> vehiculo) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dptoResidencia = dptoResidencia;
        this.cantHijos = cantHijos;
        this.idPersona = idPersona;
        this.fechaNac = fechaNac;
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {                         // armamos el soString que usaremos para mostrar los datos en el JTextArea
        return  "Id : " + idPersona + " | " +
                "Nombre: " + nombre + " | " +
                "Apellido: " + apellido + " | " +
                "Dpto. Res.: " + dptoResidencia + " | " +
                "Cant. Hijos: " + cantHijos + " | " +
                "F. Nac: " + fechaNac;
    }

    //GETTERS Y SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDptoResidencia() {
        return dptoResidencia;
    }
    public void setDptoResidencia(String dptoResidencia) {
        this.dptoResidencia = dptoResidencia;
    }

    public byte getCantHijos() {
        return cantHijos;
    }
    public void setCantHijos(byte cantHijos) {
        this.cantHijos = cantHijos;
    }

    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }
}
