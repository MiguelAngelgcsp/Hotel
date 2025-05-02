
package co.edu.konradlorenz.model;

public class HabitacionRegular extends Habitacion {

    private boolean limpieza;

    public HabitacionRegular(int numeroHabitacion, boolean disponible) {
        super(numeroHabitacion,disponible);
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
