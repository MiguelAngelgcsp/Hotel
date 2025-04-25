/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.konradlorenz.model;

/**
 *
 * @author Usuario
 */
public class HabitacionPremium extends Habitacion {

    private boolean limpieza;
    private boolean miniBar;
    private boolean comidaHabitacion;
    private boolean wfi;

    public HabitacionPremium(int numeroHabitacion) {
        super(numeroHabitacion);
        this.limpieza = true;
        this.miniBar = true;
        this.comidaHabitacion = true;
        this.wfi = true;
    }

    public boolean isLimpieza() {
        return limpieza;
    }

    public void setLimpieza(boolean limpieza) {
        this.limpieza = limpieza;
    }

    public boolean isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }

    public boolean isComidaHabitacion() {
        return comidaHabitacion;
    }

    public void setComidaHabitacion(boolean comidaHabitacion) {
        this.comidaHabitacion = comidaHabitacion;
    }

    public boolean isWfi() {
        return wfi;
    }

    public void setWfi(boolean wfi) {
        this.wfi = wfi;
    }

}
