/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.konradlorenz.model;

/**
 *
 * @author Usuario
 */
public class HabitacionRegular extends Habitacion {

    private boolean limpieza;

    public HabitacionRegular(int numeroHabitacion) {
        super(numeroHabitacion);
        this.limpieza = true;
    }

    public boolean isLimpieza() {
        return limpieza;
    }

    public void setLimpieza(boolean limpieza) {
        this.limpieza = limpieza;
    }

    @Override
    public String toString() {
        return "HabitacionRegular{" + "limpieza=" + limpieza + '}';
    }

}
