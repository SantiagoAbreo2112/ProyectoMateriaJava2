// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import Vista.*;
import Modelo.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        VentantaPrincipal ventantaPrincipal = new VentantaPrincipal(); // en el main y con el constructor de la clase principal
                                                                       // comienza la ejecución de nuestro programa

        ArrayList<Vehiculo> guardoVehìculo = new ArrayList<>();

        Vehiculo  miVehículo = new Vehiculo (1,"Estrella","rojo");
        guardoVehìculo.add(miVehículo);

        Avion avion1 = new Avion(2, "Boeing 747","Blanco", 102, 250);
        guardoVehìculo.add(avion1);

        Barco barco1 = new Barco(3, "Titanic", "Negro", 320, 52);
        guardoVehìculo.add(barco1);

        Vehiculo miVehìculo2 = new Vehiculo(4, "Ovni", "Color De otro Planeta" );
        guardoVehìculo.add(miVehìculo2);

        Barco barco2 = new Barco(5, "Patito Feo", "Amarillo", 35, 5);
        guardoVehìculo.add(barco2);


        for (int i = 0; i < guardoVehìculo.size(); i++) {   // for para mostra cada vehìculo cargado en la lista
            System.out.println(guardoVehìculo.get(i));
        }
    }
}