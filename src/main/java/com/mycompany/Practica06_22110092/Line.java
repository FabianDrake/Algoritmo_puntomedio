
package com.mycompany.Practica06_22110092;

import java.awt.*;

public class Line extends Figure {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.RED); // Color para línea
        drawLine(g, x1, y1, x2, y2);
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        // Algoritmo de Punto Medio
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);
        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;
        float x = x1;
        float y = y1;

        for (int i = 0; i <= steps; i++) {
            g.fillRect(Math.round(x), Math.round(y), 1, 1); // Dibuja el pixel
            x += xIncrement;
            y += yIncrement;
        }
    }
}

