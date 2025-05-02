
package co.edu.konradlorenz.model;

public class HabitacionPremium extends Habitacion {

    private boolean limpieza;
    private boolean miniBar;
    private boolean comidaHabitacion;
    private boolean wifi;

    public HabitacionPremium(int numeroHabitacion, boolean disponible) {
        super(numeroHabitacion, disponible);
        this.limpieza = true;
        this.miniBar = true;
        this.comidaHabitacion = true;
        this.wifi = true;
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

    public boolean isWifi() {
        return wifi;
    }

    public void setWfi(boolean wifi) {
        this.wifi = wifi;
    }

}
