
package co.edu.konradlorenz.model;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Piso> pisos;

    public Hotel() {
        pisos = new ArrayList<>();
        crearPisosYHabitaciones();
    }

    private void crearPisosYHabitaciones() {
        for (int i = 1; i <= 7; i++) {  
            Piso piso = new Piso(i);

            for (int j = 1; j <= 16; j++) { 
                int numeroHabitacion = i * 100 + j; 
                
                
                if (j % 2 == 0) {
                    piso.agregarHabitacion(new HabitacionPremium(numeroHabitacion,true));
                } else {
                    piso.agregarHabitacion(new HabitacionRegular(numeroHabitacion,true));
                }
            }

            pisos.add(piso);
        }
    }

    public List<Piso> getPisos() {
        return pisos;
    }

 
    public void mostrarEstadoHotel() {
        for (Piso p : pisos) {
            System.out.println(p);
            for (Habitacion h : p.getHabitaciones()) {
                System.out.println("  - Habitación " + h.getNumeroHabitacion() + " (Disponible: " + h.isDisponible() + ")");
            }
        }
    }
}

