package co.edu.konradlorenz.model;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Piso> pisos;
    private List<Reserva> reservas; // Lista para almacenar las reservas realizadas

    public Hotel() {
        pisos = new ArrayList<>();
        reservas = new ArrayList<>();
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
        StringBuilder estado = new StringBuilder();
        for (Piso p : pisos) {
            estado.append(p).append("\n");
            for (Habitacion h : p.getHabitaciones()) {
                estado.append("  - Habitación " + h.getNumeroHabitacion() + " (Disponible: " + h.isDisponible() + ")\n");
            }
        }
        // Mostramos la información en una ventana
        JOptionPane.showMessageDialog(null, estado.toString(), "Estado del Hotel", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para agregar reservas
    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    // Método para obtener las reservas
    public List<Reserva> getReservas() {
        return reservas;
    }
}


