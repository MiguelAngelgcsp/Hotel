
package co.edu.konradlorenz.model;


public abstract class Habitacion{
    protected int numeroHabitacion;
    protected boolean disponible;
    protected int numeroCamas;
    protected int numeroTelevisores;
    protected int  numeroBaños;
    
    
    public Habitacion(int numeroHabitacion,boolean disponible) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible=disponible;
        this.numeroCamas = 2;
        this.numeroTelevisores = 1;
        this.numeroBaños = 1;
        
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public int getNumeroTelevisores() {
        return numeroTelevisores;
    }

    public void setNumeroTelevisores(int numeroTelevisores) {
        this.numeroTelevisores = numeroTelevisores;
    }

    public int getNumeroBaños() {
        return numeroBaños;
    }

    public void setNumeroBaños(int numeroBaños) {
        this.numeroBaños = numeroBaños;
    }

    @Override
    public String toString() 
    {
        return "Habitacion{" + "numeroHabitacion=" + numeroHabitacion + ", numeroCamas=" + numeroCamas + ", numeroTelevisores=" + numeroTelevisores + ", numeroBa\u00f1os=" + numeroBaños + '}';
    }

 
    
    
    
}
