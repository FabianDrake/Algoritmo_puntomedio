
package com.mycompany.Practica06_22110092;

import java.awt.*;

public class Rectangle extends Figure {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    void draw(Graphics g) {
        g.setColor(Color.GREEN); // Color para rectángulo
        g.drawRect(x, y, width, height);
    }
}
