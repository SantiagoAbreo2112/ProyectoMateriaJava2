package Modelo;

public class Vehiculo {
    private int idVehiculo;
    private String nombre, color;

    public Vehiculo(int idVehiculo, String nombre, String color) {
        this.idVehiculo = idVehiculo;
        this.nombre = nombre;
        this.color = color;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }
    public String getNombre() {
        return nombre;
    }
    public String getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Vehiculo{" +
                "idVehiculo=" + idVehiculo +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

