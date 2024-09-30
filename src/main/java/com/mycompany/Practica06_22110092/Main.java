
package com.mycompany.Practica06_22110092;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private DrawingPanel drawingPanel;
    private JTextField[] inputFields;

    public Main() {
        setTitle("Dibujo de Figuras");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        JPanel menuPanel = new JPanel();
        String[] figureNames = {"Línea", "Cuadrado", "Rectángulo", "Círculo", "Óvalo"};
        JComboBox<String> figureMenu = new JComboBox<>(figureNames);
        menuPanel.add(figureMenu);

        inputFields = new JTextField[5]; // Cambiar la cantidad según las figuras
        JLabel[] labels = new JLabel[5];

        // Agregar etiquetas y campos de entrada para cada figura
        for (int i = 0; i < inputFields.length; i++) {
            labels[i] = new JLabel(); // Crear una nueva etiqueta
            inputFields[i] = new JTextField(5);
            inputFields[i].setEnabled(false); // Desactivar al inicio
        }

        // Definir las etiquetas según la figura seleccionada
        figureMenu.addActionListener(e -> {
            int selectedIndex = figureMenu.getSelectedIndex();
            enableInputFields(selectedIndex, labels);
        });

        // Crear botón de dibujar
        JButton drawButton = new JButton("Dibujar");
        menuPanel.add(drawButton);

        // Añadir componentes al panel
        for (int i = 0; i < inputFields.length; i++) {
            menuPanel.add(labels[i]);
            menuPanel.add(inputFields[i]);
        }

        drawButton.addActionListener(e -> {
            int selectedIndex = figureMenu.getSelectedIndex();
            drawFigure(selectedIndex);
        });

        add(menuPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private void enableInputFields(int index, JLabel[] labels) {
        // Desactivar todas las cajas de texto y limpiar etiquetas
        for (JTextField field : inputFields) {
            field.setEnabled(false);
            field.setText("");
        }
        for (JLabel label : labels) {
            label.setText(""); // Limpiar etiquetas
        }

        // Habilitar y establecer etiquetas para las entradas correspondientes
        switch (index) {
            case 0: // Línea
                labels[0].setText("X1: ");
                labels[1].setText("Y1: ");
                labels[2].setText("X2: ");
                labels[3].setText("Y2: ");
                inputFields[0].setEnabled(true);
                inputFields[1].setEnabled(true);
                inputFields[2].setEnabled(true);
                inputFields[3].setEnabled(true);
                break;
            case 1: // Cuadrado
                labels[0].setText("X: ");
                labels[1].setText("Y: ");
                labels[2].setText("Lado: ");
                inputFields[0].setEnabled(true);
                inputFields[1].setEnabled(true);
                inputFields[2].setEnabled(true);
                break;
            case 2: // Rectángulo
                labels[0].setText("X: ");
                labels[1].setText("Y: ");
                labels[2].setText("Ancho: ");
                labels[3].setText("Alto: ");
                inputFields[0].setEnabled(true);
                inputFields[1].setEnabled(true);
                inputFields[2].setEnabled(true);
                inputFields[3].setEnabled(true);
                break;
            case 3: // Círculo
                labels[0].setText("Centro X: ");
                labels[1].setText("Centro Y: ");
                labels[2].setText("Radio: ");
                inputFields[0].setEnabled(true);
                inputFields[1].setEnabled(true);
                inputFields[2].setEnabled(true);
                break;
            case 4: // Óvalo
                labels[0].setText("Centro X: ");
                labels[1].setText("Centro Y: ");
                labels[2].setText("Ancho: ");
                labels[3].setText("Alto: ");
                inputFields[0].setEnabled(true);
                inputFields[1].setEnabled(true);
                inputFields[2].setEnabled(true);
                inputFields[3].setEnabled(true);
                break;
        }
    }

    private void drawFigure(int index) {
        int[] params = new int[inputFields.length];
        for (int i = 0; i < inputFields.length; i++) {
            if (inputFields[i].isEnabled()) {
                params[i] = Integer.parseInt(inputFields[i].getText());
            }
        }
        switch (index) {
            case 0: // Línea
                drawingPanel.drawFigure(new Line(params[0], params[1], params[2], params[3]));
                break;
            case 1: // Cuadrado
                drawingPanel.drawFigure(new Square(params[0], params[1], params[2]));
                break;
            case 2: // Rectángulo
                drawingPanel.drawFigure(new Rectangle(params[0], params[1], params[2], params[3]));
                break;
            case 3: // Círculo
                drawingPanel.drawFigure(new Circle(params[0], params[1], params[2]));
                break;
            case 4: // Óvalo
                drawingPanel.drawFigure(new Oval(params[0], params[1], params[2], params[3]));
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
