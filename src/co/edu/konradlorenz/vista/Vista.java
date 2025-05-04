package co.edu.konradlorenz.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Vista {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField inputField;
    private JButton enviarButton;
    private JTextField nombreClienteField;
    private JTextField documentoClienteField;
    private JRadioButton premiumButton;
    private JRadioButton regularButton;
    private ButtonGroup buttonGroup;

    public Vista() {
        // Crear la ventana principal
        frame = new JFrame("Sistema de Reservas de Hotel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Crear un área de texto para mostrar mensajes
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel para las opciones de usuario
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Nombre del cliente
        JPanel nombrePanel = new JPanel(new FlowLayout());
        JLabel nombreLabel = new JLabel("Nombre del cliente:");
        nombreClienteField = new JTextField(20);
        nombrePanel.add(nombreLabel);
        nombrePanel.add(nombreClienteField);
        panel.add(nombrePanel);

        // Documento del cliente
        JPanel documentoPanel = new JPanel(new FlowLayout());
        JLabel documentoLabel = new JLabel("Documento del cliente:");
        documentoClienteField = new JTextField(20);
        documentoPanel.add(documentoLabel);
        documentoPanel.add(documentoClienteField);
        panel.add(documentoPanel);

        // Tipo de habitación
        JPanel tipoPanel = new JPanel(new FlowLayout());
        premiumButton = new JRadioButton("Premium");
        regularButton = new JRadioButton("Regular");
        buttonGroup = new ButtonGroup();
        buttonGroup.add(premiumButton);
        buttonGroup.add(regularButton);
        tipoPanel.add(premiumButton);
        tipoPanel.add(regularButton);
        panel.add(tipoPanel);

        // Botón de reserva
        enviarButton = new JButton("Realizar Reserva");
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMensaje("Reserva realizada con éxito.");
            }
        });
        panel.add(enviarButton);

        // Agregar el panel de entrada
        frame.add(panel, BorderLayout.SOUTH);

        // Hacer visible la ventana
        frame.setVisible(true);
    }

    // Mostrar mensaje en el área de texto
    public void mostrarMensaje(String mensaje) {
        textArea.append(mensaje + "\n");
    }

    // Obtener nombre del cliente
    public String pedirNombreCliente() {
        return nombreClienteField.getText();
    }

    // Obtener documento del cliente
    public String pedirDocumentoCliente() {
        return documentoClienteField.getText();
    }

    // Obtener si la habitación es Premium
    public boolean pedirTipoHabitacion() {
        return premiumButton.isSelected();
    }
    public LocalDate pedirFecha(String mensaje) {
    while (true) {
        String fechaTexto = JOptionPane.showInputDialog(null, mensaje + " (Formato: AAAA-MM-DD)");
        try {
            return LocalDate.parse(fechaTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Intenta de nuevo.");
        }
    }
}

}
