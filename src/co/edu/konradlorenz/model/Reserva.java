
package co.edu.konradlorenz.model;


import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate entrada, LocalDate salida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = entrada;
        this.fechaSalida = salida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
}

