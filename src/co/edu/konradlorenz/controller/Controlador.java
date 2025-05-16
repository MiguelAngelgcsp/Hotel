package co.edu.konradlorenz.controller;

import co.edu.konradlorenz.model.*;
import javax.swing.*;
import java.time.LocalDate;

public class Controlador {
    private Hotel hotel;

    public Controlador() {
        this.hotel = new Hotel();
    }

    public Hotel getHotel() {
        return hotel;
    }

    // Método para reservar habitación
    public boolean reservarHabitacion(String nombre, String documento, boolean premium, LocalDate entrada, LocalDate salida)
    {
        Cliente cliente = new Cliente(nombre, documento);

        for (Piso piso : hotel.getPisos()) 
        {
            for (Habitacion habitacion : piso.getHabitaciones()) 
            {
                if (habitacion.isDisponible()) 
                {
                    if (premium && habitacion instanceof HabitacionPremium) 
                    {
                        return hacerReserva(cliente, habitacion, entrada, salida);
                    } 
                    else if (!premium && habitacion instanceof HabitacionRegular) 
                    {
                        return hacerReserva(cliente, habitacion, entrada, salida);
                    }
                }
            }
        }
        // Mostrar mensaje si no hay habitaciones disponibles
        JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles del tipo solicitado.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Realiza la reserva y agrega a la lista de reservas
    private boolean hacerReserva(Cliente cliente, Habitacion habitacion, LocalDate entrada, LocalDate salida) 
    {
    habitacion.setDisponible(false);
    Reserva reserva = new Reserva(cliente, habitacion, entrada, salida);
    hotel.agregarReserva(reserva);
    JOptionPane.showMessageDialog(null, "Reserva realizada con éxito para la habitación " + habitacion.getNumeroHabitacion(), "Reserva Confirmada", JOptionPane.INFORMATION_MESSAGE);
    return true;
    }

    public void mostrarReservas() 
    {
        StringBuilder reservasList = new StringBuilder();
        for (Reserva reserva : hotel.getReservas()) 
        {
            reservasList.append("Reserva: " + reserva.getCliente().getNombre() +
                    " - Habitación " + reserva.getHabitacion().getNumeroHabitacion() +
                    " - Entrada: " + reserva.getFechaEntrada() +
                    " - Salida: " + reserva.getFechaSalida() + "\n");
        }
        JOptionPane.showMessageDialog(null, reservasList.toString(), "Lista de Reservas", JOptionPane.INFORMATION_MESSAGE);
    }
    
}

