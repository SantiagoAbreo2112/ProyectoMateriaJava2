package Modelo;

public class Avion extends Vehiculo {
    private double longitud;

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    private int cantPasajeros;

    public Avion(int idVehiculo, String nombre, String color, int longitud, int cantPasajeros) {
        super(idVehiculo, nombre, color);
        this.longitud = Double.parseDouble(String.valueOf(longitud));
        this.cantPasajeros = Integer.parseInt(String.valueOf(cantPasajeros));
    }

    @Override
    public String toString()  {
        return "Avión{" +
                "idVehiculo=" + getIdVehiculo() +
                ", nombre='" + getNombre() + '\'' +
                ", color='" + getColor() + '\'' +
                ", longitud='" + longitud + '\'' +
                ", Cantidad Pasajeros='" + cantPasajeros + '\'' +
                '}';
    }
}
