
package com.mycompany.Practica06_22110092;

import java.awt.*;

public class Square extends Figure {
    private int x, y, side;

    public Square(int x, int y, int side) {
        this.x = x;
        this.y = y;
        this.side = side;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.BLUE); // Color para cuadrado
        for (int i = 0; i < side; i++) {
            g.drawLine(x, y + i, x + side, y + i); // Dibuja las líneas horizontales
        }
        for (int i = 0; i < side; i++) {
            g.drawLine(x + i, y, x + i, y + side); // Dibuja las líneas verticales
        }
    }
}
