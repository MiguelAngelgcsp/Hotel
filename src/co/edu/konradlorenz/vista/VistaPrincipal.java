package co.edu.konradlorenz.vista;

import co.edu.konradlorenz.controller.Controlador;
import java.time.LocalDate;

import javax.swing.*;

public class VistaPrincipal {
    private Controlador controlador;

    public VistaPrincipal() {
        this.controlador = new Controlador();  // Inicializa el controlador
    }

    public void ejecutar() {
        int opcion;
        do {
            opcion = mostrarMenuYSeleccionar();

            switch (opcion) {
                case 1:
                    realizarReserva();
                    break;
                case 2:
                    mostrarReservas();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!", "Salida", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida, por favor intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcion != 0);
    }

    private int mostrarMenuYSeleccionar() {
        String[] opciones = {"Salir", "Realizar reserva", "Mostrar reservas"};
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción:",
                "Menú Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

       
        if (seleccion == 1) return 1;
        else if (seleccion == 2) return 2;
        else return 0;
    }

private void realizarReserva() {
    String descripcion = "TIPOS DE HABITACIÓN:\n\n"
            + "Habitación Regular:\n"
            + "- 2 camas\n"
            + "- 1 televisor\n"
            + "- 1 baño\n"
            + "- Servicio de limpieza\n\n"
            + "Habitación Premium:\n"
            + "- Todo lo de la regular, más:\n"
            + "- Mini bar\n"
            + "- Comida a la habitación\n"
            + "- Wifi incluido\n";

    JOptionPane.showMessageDialog(null, descripcion, "Información de habitaciones", JOptionPane.INFORMATION_MESSAGE);

    String[] opciones = {"Habitación Regular", "Habitación Premium"};
    int tipoSeleccionado = JOptionPane.showOptionDialog(
            null,
            "¿Qué tipo de habitación desea reservar?",
            "Tipo de Habitación",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
    );

    if (tipoSeleccionado == JOptionPane.CLOSED_OPTION) return;
    boolean premium = tipoSeleccionado == 1;

    String nombreCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente:", "Nombre del Cliente", JOptionPane.QUESTION_MESSAGE);
    if (nombreCliente == null || nombreCliente.trim().isEmpty()) return;

    String documentoCliente = JOptionPane.showInputDialog(null, "Ingrese el documento del cliente:", "Documento del Cliente", JOptionPane.QUESTION_MESSAGE);
    if (documentoCliente == null || documentoCliente.trim().isEmpty()) return;

    // Fecha de entrada
    String entradaTexto = JOptionPane.showInputDialog(null, "Ingrese la fecha de entrada (formato AAAA-MM-DD):", "Fecha de Entrada", JOptionPane.QUESTION_MESSAGE);
    if (entradaTexto == null || entradaTexto.trim().isEmpty()) return;

    LocalDate fechaEntrada;
    try {
        fechaEntrada = LocalDate.parse(entradaTexto);
        if (fechaEntrada.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "La fecha de entrada no puede ser anterior a hoy.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use AAAA-MM-DD.", "Error de formato", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Número de noches
    String nochesTexto = JOptionPane.showInputDialog(null, "¿Cuántas noches desea reservar?", "Duración de la Estancia", JOptionPane.QUESTION_MESSAGE);
    if (nochesTexto == null || nochesTexto.trim().isEmpty()) return;

    int noches;
    try {
        noches = Integer.parseInt(nochesTexto);
        if (noches <= 0) {
            JOptionPane.showMessageDialog(null, "El número de noches debe ser mayor que cero.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido de noches.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    LocalDate fechaSalida = fechaEntrada.plusDays(noches);

    // Reserva
    boolean exito = controlador.reservarHabitacion(nombreCliente, documentoCliente, premium, fechaEntrada, fechaSalida);

    if (exito) {
        JOptionPane.showMessageDialog(null, "Reserva realizada con éxito.\nSalida: " + fechaSalida, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo realizar la reserva. Verifique disponibilidad.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void mostrarReservas() {
        controlador.mostrarReservas();
    }
}

