
package com.mycompany.Practica06_22110092;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private List<Figure> figures = new ArrayList<>();

    public void drawFigure(Figure figure) {
        figures.add(figure);
        repaint(); // Llama a paintComponent para redibujar
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figure figure : figures) {
            figure.draw(g);
        }
    }
}
