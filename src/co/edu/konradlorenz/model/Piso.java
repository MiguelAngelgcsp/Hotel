
package co.edu.konradlorenz.model;

import java.util.ArrayList;
import java.util.List;

public class Piso {
    private int numeroPiso;
    private List<Habitacion> habitaciones;

    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.habitaciones = new ArrayList<>();
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    
    public Habitacion buscarDisponible() 
    {
        for (Habitacion h : habitaciones) 
        {
            if (h.isDisponible()) 
            {
                return h;
            }
        }
        return null;
    }

    @Override
    public String toString() 
    {
        return "Piso " + numeroPiso + " con " + habitaciones.size() + " habitaciones.";
    }
}

